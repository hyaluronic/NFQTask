package com.project.nfq.crud.repository;

import com.project.nfq.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByName(String name);

    List<Student> findAll();
}
