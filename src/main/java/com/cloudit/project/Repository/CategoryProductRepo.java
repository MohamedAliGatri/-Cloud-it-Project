package com.cloudit.project.Repository;

import com.cloudit.project.model.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryProductRepo extends JpaRepository<CategoryProduct,Long> {
    Optional<CategoryProduct> findCategoryById(Long id);
}
