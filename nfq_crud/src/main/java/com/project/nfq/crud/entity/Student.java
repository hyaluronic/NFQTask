package com.project.nfq.crud.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="STUDENT_TBL")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer group;
}
