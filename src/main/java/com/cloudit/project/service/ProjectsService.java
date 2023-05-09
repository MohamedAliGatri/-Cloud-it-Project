package com.cloudit.project.service;

import com.cloudit.project.Repository.PetsRepo;
import com.cloudit.project.Repository.PlantsRepo;
import com.cloudit.project.Repository.ProjectsRepo;
import com.cloudit.project.model.Pets;
import com.cloudit.project.model.Plants;
import com.cloudit.project.model.Projects;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProjectsService  {
    private final ProjectsRepo p_Repository;

@Autowired
    public ProjectsService(ProjectsRepo pRepository) {
        p_Repository = pRepository;
}
    public Projects addProjects(Projects Project) {

        return p_Repository.save(Project);
    }

    public List<Projects> findAllProjects() {
        return p_Repository.findAll();
    }

    public Projects updateProjects(Projects Project) {
        return p_Repository.save(Project);
    }

    public Projects findProjectsById(Long id) {

        return (Projects) p_Repository.findProjectsById(id);

    }





    public void deleteEmployee(Long id){
        p_Repository.deleteProjectsById(id);
    }


}
