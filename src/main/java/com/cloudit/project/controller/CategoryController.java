package com.cloudit.project.controller;

import com.cloudit.project.model.Category;
import com.cloudit.project.service.ICategory;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    ICategory catInterface;

    @GetMapping("/getAllCategories")
    public List<Category> retrieveAllCategories() {
        return catInterface.retrieveAllCategories();
    }

    @PostMapping("/addCategory")
    public Category addOrUpdateCategory(@RequestBody Category category) {
        return catInterface.addOrUpdateCategory(category);
    }

    @DeleteMapping("/deletecategory")
    public void removeCategory(@RequestBody Category category) {
        catInterface.removeCategory(category);
    }

    @GetMapping("/getcategorybyid/{idCat}")
    public Category retrieveCategory(@PathVariable("idCat") Long id_category) {
        return catInterface.retrieveCategory(id_category);
    }
}
