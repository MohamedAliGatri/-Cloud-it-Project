package com.cloudit.project.serviceImpl;

import com.cloudit.project.Repository.UserRepository;
import com.cloudit.project.dto.Purchase;
import com.cloudit.project.model.OrderItem;
import com.cloudit.project.model.Orders;
import com.cloudit.project.model.Product;
import com.cloudit.project.model.User;
import com.roky.thunderspi.dto.PurchaseResponse;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CheckoutServiceImpl implements ICheckoutService {


    private  IProductService productService;

    private UserRepository customerRepository;


    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // retrieve the order info from dto
        Orders order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> {
            Product newProduct = new Product();
            try {
                newProduct = productService.findProdById(item.getProductId());
                newProduct.setQuantity(newProduct.getQuantity() - item.getQuantity());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            order.add(item);

        });


        // populate customer with order
        User customer = purchase.getCustomer();
        customer.add(order);

        // save to the database
        customerRepository.save(customer);

        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }



    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }
}


