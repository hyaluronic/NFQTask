package com.project.nfq.crud.controller.PageController;

import com.project.nfq.crud.entity.Project;
import com.project.nfq.crud.entity.Student;
import com.project.nfq.crud.service.ProjectService;
import com.project.nfq.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class StatusPageController {

    private Project project;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private StudentService studentService;


    @GetMapping("/statusPage")
    public String statusPage(@RequestParam(name = "projectId", required = false) Integer projectId, Model model) {

        project = getProject(projectId);
        project.setStudents(studentService.getStudents());
        model.addAttribute("project", project);
        return "statusPage";
    }

    @PostMapping("/statusPage")
    public String statusPageAddStudent(String studentName) {
        project = getProject(100);
        studentService.saveStudent(new Student(studentName, project) );
        project.setStudents(studentService.getStudents());
        return "redirect:/statusPage";
    }

    private Project getProject(Integer id) {
        return new Project(100, "Pirmas", 5, 2, Collections.emptyList());
        /*return projectService.getProjectById(id) == null
                ? new Project(100, "Pirmas", 5, 2, Collections.emptyList())
                : projectService.getProjectById(id);*/
    }


}

