package com.cloudit.project.controller;

import com.cloudit.project.model.Product;
import com.cloudit.project.service.IProduct;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    IProduct productservice;

    @GetMapping("/allproducts")
    public List<Product> getAllProducts(){
        return productservice.retrieveAllProducts();
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productservice.addOrUpdateProduct(product);
    }

    @DeleteMapping("/deleteproduct")
    public void deleteProduct(@RequestBody Product product){
        productservice.removeProduct(product);
    }

    @GetMapping("/getproductbyid/{id_product}")
    public Product getProductById(@PathVariable("id_product") Long id_product){
        return productservice.retrieveProduct(id_product);
    }

    @PostMapping("/assignprodToCategory/{id_category}")
    public Product assignProductToCategory(@RequestBody Product product,@PathVariable("id_category") Long id_category) {
        return productservice.assignProductToCategory(product, id_category);
    }
}
