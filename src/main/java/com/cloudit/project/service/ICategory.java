package com.cloudit.project.service;

import com.cloudit.project.model.Category;

import java.util.List;

public interface ICategory {
    List<Category> retrieveAllCategories();
    Category addOrUpdateCategory(Category category);
    void removeCategory (Category category);
    Category retrieveCategory (Long id_category);
}
