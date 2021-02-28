package com.project.nfq.crud.controller.PageController;

import com.project.nfq.crud.entity.Project;
import com.project.nfq.crud.entity.Student;
import com.project.nfq.crud.service.ProjectService;
import com.project.nfq.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class StatusPageController {

    private Project project;
    private List<Student> students = Collections.emptyList();
    @Autowired
    private ProjectService projectService;
    @Autowired
    private StudentService studentService;


    @GetMapping("/statusPage/{id}")
    public String statusPage(@PathVariable("id") int id, Model model) {
        project = projectService.getProjectById(id);
/*        students = studentService.getStudentsByProject(project.getId());
        project.setStudents(students);*/
        model.addAttribute("project", project);
        return "statusPage";
    }

    @PostMapping("/addStudent")
    public String statusPageAddStudent(String studentName, Integer projectId) {
        project = projectService.getProjectById(projectId);
        Student student = new Student();
        student.setName(studentName);
        student.setProject(project);
        studentService.saveStudent(student);
        return "redirect:/statusPage/{id}";
    }
}

