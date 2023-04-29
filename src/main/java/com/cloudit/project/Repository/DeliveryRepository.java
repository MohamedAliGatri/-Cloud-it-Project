package com.cloudit.project.Repository;

import com.cloudit.project.model.Delivery;
import com.cloudit.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findAllByClient(User client);
}
