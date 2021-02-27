package com.project.nfq.crud.service;

import com.project.nfq.crud.entity.Student;
import com.project.nfq.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> saveStudents(List<Student> students){
        return studentRepository.saveAll(students);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(int id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student getStudentByName(String name){
        return studentRepository.findByName(name);
    }

    public String deleteStudent(int id)
    {
        studentRepository.deleteById(id);
        return "product removed " + id;
    }

    public Student updateStudent(Student student)
    {
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        existingStudent.setName(student.getName());
        existingStudent.setGroup(student.getGroup());
        return studentRepository.save(existingStudent);
    }
}
