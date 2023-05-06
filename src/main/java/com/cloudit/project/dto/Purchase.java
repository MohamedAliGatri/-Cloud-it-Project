package com.cloudit.project.dto;



import com.cloudit.project.model.OrderItem;
import com.cloudit.project.model.Orders;
import com.cloudit.project.model.User;
import lombok.Data;


import java.util.Set;

@Data
public class Purchase {

    private User customer;

    private Orders order;
    private Set<OrderItem> orderItems;

}