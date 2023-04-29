package com.cloudit.project.métier;

import com.cloudit.project.ExeptionHnadler.ProjectsNotFoundExeption;
import com.cloudit.project.model.Projects;
import org.springframework.stereotype.Service;

@Service
public class ProjectsValidationService {

    public void validateProjectData(Projects project) throws ProjectsNotFoundExeption {
        if (project.getBudget() <= 0) {
            throw new ProjectsNotFoundExeption("Invalid project budget");
        }

        if (project.getDuration_months() <= 0) {
            throw new ProjectsNotFoundExeption("Invalid project duration in months");
        }

        if (project.getLand_area() <= 0) {
            throw new ProjectsNotFoundExeption("Invalid project land area");
        }
    }
}