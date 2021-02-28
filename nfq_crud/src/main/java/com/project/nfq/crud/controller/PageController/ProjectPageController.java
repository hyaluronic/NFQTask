package com.project.nfq.crud.controller.PageController;

import com.project.nfq.crud.entity.Project;
import com.project.nfq.crud.entity.Student;
import com.project.nfq.crud.service.ProjectService;
import com.project.nfq.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class ProjectPageController {

    private List<Project> projects = Collections.emptyList();
    @Autowired
    private ProjectService projectService;
    @Autowired
    private StudentService studentService;


    @GetMapping("/")
    public String statusPage(Model model) {
        projects = projectService.getProjects();
        model.addAttribute("projects", projects);
        return "ProjectPage";
    }

    @PostMapping("/addProject")
    public String addProject(String projectName, Integer numberOfGroups, Integer studentsPerGroup) {
        Project project = new Project();
        project.setName(projectName);
        project.setNumberOfGroups(numberOfGroups);
        project.setStudentsPerGroup(studentsPerGroup);
        projectService.saveProject(project);
        return "redirect:/";
    }

    @PostMapping("/deleteProject")
    public String addStudent(Integer projectId) {
        studentService.deleteStudentsByProjectId(projectId);
        projectService.deleteProject(projectId);
        return "redirect:/";
    }
}
