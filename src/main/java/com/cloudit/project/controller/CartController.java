package com.cloudit.project.controller;

import com.cloudit.project.service.ICart;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {
    ICart cartInterface;

    @PostMapping("/getTotal/{id_cart}")
    public HashMap<String, Double> CartTotal(@PathVariable("id_cart") Long id_cart) {
        return cartInterface.CartTotal(id_cart);
    }
}
