package com.project.nfq.crud.service;

import com.project.nfq.crud.entity.Student;
import com.project.nfq.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

//    public List<Student> saveStudents(List<Student> students){
//        return studentRepository.saveAll(students);
//    }

    public List<Student> getStudents(){
        List<Student> students;
        students = studentRepository.findAll();
        return students;
    }

    public List<Student> getStudentByGroup(Integer groupNumber, Integer projectId){
        List<Student> students = getStudentsByProjectId(projectId);
        students.removeIf(student -> !student.getGroup().equals(groupNumber));
        return students;
    }

    public List<Student> getStudentsByProjectId(Integer projectId){
        List<Student> students = getStudents();
        students.removeIf(student -> !student.getProject().getId().equals(projectId));
        return students;
    }

    public Student getStudentById(int id){
        return studentRepository.findById(id).orElse(null);
    }

//    public Student getStudentByName(String name){
//        return studentRepository.findByName(name);
//    }

    public void deleteStudent(int id)
    {
        studentRepository.deleteById(id);
    }

    public void deleteStudentsByProjectId(Integer projectId)
    {
        List<Student> students = getStudents();
        for (Student student : students) {
            if(student.getProject().getId().equals(projectId))
            {
                deleteStudent(student.getId());
            }
        }
    }

    public Student updateStudent(Student student)
    {
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        existingStudent.setName(student.getName());
        existingStudent.setGroup(student.getGroup());
        existingStudent.setProject(student.getProject());
        return studentRepository.save(existingStudent);
    }
}
