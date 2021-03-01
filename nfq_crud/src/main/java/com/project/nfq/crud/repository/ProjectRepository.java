package com.project.nfq.crud.repository;

import com.project.nfq.crud.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
