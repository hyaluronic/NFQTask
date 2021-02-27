package com.project.nfq.crud.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Student")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer group;
    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    public Student(String name, Project project)
    {
        this.name=name;
        this.project=project;
    }
}
