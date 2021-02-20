package nfq.project.nfqdemo.Domain.Entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Teacher {

    public Teacher()
    {

    }

    private Integer _Id;
    private String name;
    private List<Project> projects = Collections.emptyList();

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject (Project... projects)
    {
        this.projects.addAll(Arrays.asList(projects));
    }

    public Integer get_Id() {
        return _Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
