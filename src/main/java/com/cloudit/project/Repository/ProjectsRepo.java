package com.cloudit.project.Repository;

import com.cloudit.project.model.Plants;
import com.cloudit.project.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectsRepo extends JpaRepository<Projects, Long> {
    Projects findProjectsById(Long id);
   //boolean existsByIdAndProjects(long id, Projects project);

    void deleteProjectsById(Long id);
}
