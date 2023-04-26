package com.cloudit.project.serviceImpl;

import com.cloudit.project.model.Cart;
import com.cloudit.project.model.CartLine;
import com.cloudit.project.model.Product;
import com.cloudit.project.repository.CartLineRepo;
import com.cloudit.project.repository.CartRepo;
import com.cloudit.project.repository.ProductRepo;
import com.cloudit.project.service.ICartLine;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartLineService implements ICartLine {
    CartLineRepo cartLineRepo;
    CartRepo cartRepo;
    ProductRepo productRepo;

    @Override
    public CartLine addCartLineAndAssignToProductAndCart(CartLine cartline, Long id_cart) {
        cartline = cartLineRepo.save(cartline);
        Cart cart = cartRepo.findById(id_cart).orElse(null);
        cartline.setPanier(cart);
        Product p = productRepo.findById( cartline.getProd().getId_product()).orElse(null);
        assert p != null;
        cartline.setPrix(p.getPrice());
        cartline.setProd(p);
        assert cart != null;
        cartRepo.save(cart);
        return cartline;
    }
/*
    public double getTotal() {
        double total = 0;
        List<CartLine> cartlines =
                    ;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }*/
}
