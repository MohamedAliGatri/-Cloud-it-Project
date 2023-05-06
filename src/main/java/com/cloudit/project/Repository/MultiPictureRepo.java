package com.cloudit.project.Repository;

import com.cloudit.project.model.MultiPicture;
import com.cloudit.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MultiPictureRepo extends JpaRepository<MultiPicture,Long> {
    ArrayList<MultiPicture> findByImage(Product product);
}
