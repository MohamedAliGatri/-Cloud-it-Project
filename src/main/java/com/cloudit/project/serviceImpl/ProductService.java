package com.cloudit.project.serviceImpl;

import com.cloudit.project.model.Category;
import com.cloudit.project.model.Product;
import com.cloudit.project.repository.CategoryRepo;
import com.cloudit.project.repository.ProductRepo;
import com.cloudit.project.service.IProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements IProduct {

    ProductRepo productrepo;
    CategoryRepo categoryRepo;

    @Override
    public List<Product> retrieveAllProducts() {
        return productrepo.findAll();
    }

    @Override
    public Product addOrUpdateProduct(Product product) {
        return productrepo.save(product);
    }

    @Override
    public void removeProduct(Product product) {
        productrepo.delete(product);
    }

    @Override
    public Product retrieveProduct(Long id_product) {
        return productrepo.findById(id_product).orElse(null);
    }

    @Override
    public Product assignProductToCategory(Product product , Long id_category){
        Category category = categoryRepo.findById(id_category).orElse(null);
        product.setCategory(category);
        return productrepo.save(product);
    }
}
