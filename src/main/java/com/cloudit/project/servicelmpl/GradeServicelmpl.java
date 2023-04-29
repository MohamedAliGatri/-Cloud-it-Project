package com.cloudit.project.servicelmpl;

import com.cloudit.project.model.Grade;
import com.cloudit.project.repository.GradeRepo;
import com.cloudit.project.service.GradeServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServicelmpl implements GradeServices {
    @Autowired
    GradeRepo gradeRepository;

    @Override
    public Grade saveGrade(Grade grade) {
        validateGrade(grade);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(Integer id, Grade grade) {
        validateGrade(grade);
        Grade gradeToUpdate = gradeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Grade not found with id " + id));
        gradeToUpdate.setSalaire_base(grade.getSalaire_base());
        return gradeRepository.save(gradeToUpdate);
    }

    @Override
    public void deleteGrade(Integer id) {
        Grade gradeToDelete = gradeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Grade not found with id " + id));
        gradeRepository.delete(gradeToDelete);
    }

    @Override
    public Grade getGradeById(Integer id) {
        return gradeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Grade not found with id " + id));
    }

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    private void validateGrade(Grade grade) {
        if (grade.getSalaire_base() == null || grade.getSalaire_base() < 0) {
            throw new IllegalArgumentException("Salaire_base cannot be null or negative.");
        }
    }
}
