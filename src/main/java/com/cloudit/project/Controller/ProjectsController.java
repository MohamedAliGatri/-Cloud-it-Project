package com.cloudit.project.Controller;
import com.cloudit.project.Repository.ProjectsRepo;
import com.cloudit.project.model.Pets;
import com.cloudit.project.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
    @RequestMapping("/api/projects")
    public class ProjectsController {

        @Autowired
        private ProjectsRepo projectsRepository;

        @GetMapping
        public List<Projects> getAllProjects() {
            return projectsRepository.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Projects> getProjectById(@PathVariable Long id) {
            Optional<Projects> project = projectsRepository.findById(id);
            if (project.isPresent()) {
                return ResponseEntity.ok(project.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping("/")
        public Projects createProject(@RequestBody Projects project) {
            return projectsRepository.save(project);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Projects> updateProject(@PathVariable Long id, @RequestBody Projects projectDetails) {
            Optional<Projects> project = projectsRepository.findById(id);
            if (project.isPresent()) {
                Projects updatedProject = project.get();
                updatedProject.setBudget(projectDetails.getBudget());
                updatedProject.setDuration_months(projectDetails.getDuration_months());
                updatedProject.setLand_area(projectDetails.getLand_area());
                updatedProject.setPetsSet(projectDetails.getPetsSet());
                updatedProject.setPlantsSet(projectDetails.getPlantsSet());
                return ResponseEntity.ok(projectsRepository.save(updatedProject));
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity deleteProject(@PathVariable Long id) {
            Optional<Projects> project = projectsRepository.findById(id);
            if (project.isPresent()) {
                projectsRepository.delete(project.get());
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }


