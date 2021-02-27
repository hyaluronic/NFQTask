package nfq.project.nfqdemo.Domain.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name="Teacher")
public class Teacher implements Serializable {

    public Teacher()
    {

    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;
    private List<Project> projects = Collections.emptyList();

    public List<Project> getProjects() {
        return projects;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addProject (Project... projects)
    {
        this.projects.addAll(Arrays.asList(projects));
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
