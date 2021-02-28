package com.project.nfq.crud.controller;

import com.project.nfq.crud.entity.Student;
import com.project.nfq.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

/*    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }*/

    @PostMapping("/addStudents")
    public List<Student> addStudents(@RequestBody List<Student> students){
        return service.saveStudents(students);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents(){
        return service.getStudents();
    }

    @GetMapping("/student/{id}")
    public Student findStudentById(@PathVariable int id){
        return service.getStudentById(id);
    }

    @GetMapping("/student/{name}")
    public Student findStudentByName(@PathVariable String name){
        return service.getStudentByName(name);
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }

/*    @DeleteMapping("deleteStudent/{id}")
    public String deleteStudent(int id){
        return service.deleteStudent(id);
    }*/
}
