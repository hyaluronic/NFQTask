package com.project.nfq.crud.controller;

import com.project.nfq.crud.entity.Project;
import com.project.nfq.crud.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService service;

/*    @PostMapping("/addProject")
    public Project addStudent(@RequestBody Project project){
        return service.saveProject(project);
    }*/

    @PostMapping("/addProjects")
    public List<Project> addStudents(@RequestBody List<Project> projects){
        return service.saveProjects(projects);
    }

    @GetMapping("/projects")
    public List<Project> findAllStudents(){
        return service.getProjects();
    }

    @GetMapping("/project/{id}")
    public Project findStudentById(@PathVariable int id){
        return service.getProjectById(id);
    }

    @GetMapping("/project/{name}")
    public Project findProjectByName(@PathVariable String name){
        return service.getProjectByName(name);
    }

    @PutMapping("/updateProject")
    public Project updateProject(@RequestBody Project project){
        return service.updateProject(project);
    }

    @DeleteMapping("deleteProject/{id}")
    public String deleteProject(int id){
        return service.deleteProject(id);
    }
}
