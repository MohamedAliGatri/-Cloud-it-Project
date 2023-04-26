package com.cloudit.project.repository;

import com.cloudit.project.model.CartLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartLineRepo extends JpaRepository<CartLine,Long> {
}
