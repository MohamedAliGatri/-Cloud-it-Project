package com.cloudit.project.serviceImpl;

import com.cloudit.project.model.CategoryProduct;

import java.util.List;

public interface IProductCategoryService {
    public List<CategoryProduct> findAllCategory();

    public CategoryProduct findProdById(Long id);

    public CategoryProduct addProduct(CategoryProduct categoryProduct);

    public CategoryProduct editProduct(CategoryProduct categoryProduct);

    public void deleteProduct(Long id);


}
