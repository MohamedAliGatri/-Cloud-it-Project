package com.cloudit.project.service;

import com.cloudit.project.model.Grade;
import java.util.List;

public interface GradeServices {
    Grade saveGrade(Grade grade);
    Grade updateGrade(Integer id, Grade grade);
    void deleteGrade(Integer id);
    Grade getGradeById(Integer id);
    List<Grade> getAllGrades();
}
