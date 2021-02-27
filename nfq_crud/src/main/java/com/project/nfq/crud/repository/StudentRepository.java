package com.project.nfq.crud.repository;

import com.project.nfq.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByName(String name);
}
