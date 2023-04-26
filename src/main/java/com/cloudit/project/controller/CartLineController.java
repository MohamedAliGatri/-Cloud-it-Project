package com.cloudit.project.controller;

import com.cloudit.project.model.CartLine;
import com.cloudit.project.service.ICartLine;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartline")
@AllArgsConstructor
public class CartLineController  {
    ICartLine cartLine;

    @PostMapping("/addcartline/{id_cart}")
    public CartLine addCartLineAndAssignToProductAndCart(@RequestBody CartLine cartline, @PathVariable("id_cart") Long id_cart) {
        System.out.println(cartline);
        System.out.println(id_cart);
        return cartLine.addCartLineAndAssignToProductAndCart(cartline, id_cart);
    }
}
