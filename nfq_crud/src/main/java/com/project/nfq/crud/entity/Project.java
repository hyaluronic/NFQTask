package com.project.nfq.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Project")
public class Project {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer numberOfGroups;
    private Integer studentsPerGroup;
    @OneToMany(mappedBy = "project")
    private List<Student> students;
}
