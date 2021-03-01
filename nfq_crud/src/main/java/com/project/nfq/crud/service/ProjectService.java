package com.project.nfq.crud.service;

import com.project.nfq.crud.entity.Project;
import com.project.nfq.crud.entity.Student;
import com.project.nfq.crud.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveProject(Project project){
        return projectRepository.save(project);
    }


    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    public Project getProjectById(int id){
        return projectRepository.findById(id).orElse(null);
    }

    public void deleteProject(int id)
    {
        projectRepository.deleteById(id);
    }

}
