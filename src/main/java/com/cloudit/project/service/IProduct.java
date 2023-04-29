package com.cloudit.project.service;

import com.cloudit.project.model.Product;

import java.util.List;

public interface IProduct {
    List<Product> retrieveAllProducts();
    Product addOrUpdateProduct(Product product);
    void removeProduct (Product product);
    Product retrieveProduct (Long id_product);
    Product assignProductToCategory(Product product , Long id_category);
}
