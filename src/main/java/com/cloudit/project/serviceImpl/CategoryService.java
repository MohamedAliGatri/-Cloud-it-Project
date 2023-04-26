package com.cloudit.project.serviceImpl;

import com.cloudit.project.model.Category;
import com.cloudit.project.repository.CategoryRepo;
import com.cloudit.project.service.ICategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService implements ICategory {

    CategoryRepo categoryRepo;
    @Override
    public List<Category> retrieveAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category addOrUpdateCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public void removeCategory(Category category) {
        categoryRepo.delete(category);

    }

    @Override
    public Category retrieveCategory(Long id_category) {
        return categoryRepo.findById(id_category).orElse(null);
    }
}
