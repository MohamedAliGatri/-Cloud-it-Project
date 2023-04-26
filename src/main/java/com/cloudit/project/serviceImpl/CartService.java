package com.cloudit.project.serviceImpl;

import com.cloudit.project.model.Cart;
import com.cloudit.project.model.Product;
import com.cloudit.project.repository.CartRepo;
import com.cloudit.project.repository.ProductRepo;
import com.cloudit.project.service.ICart;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CartService implements ICart {

    CartRepo cartRepo;
    ProductRepo productrepo;
    public Cart getCartById(Long id) {
        return cartRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }


  /*  @Override
    public Cart addProductToCart(Long id_product, Cart cart) {
        Product products = productrepo.findById(id_product).orElse(null);
        cart.getProducts().add(products);
        return cartRepo.save(cart);
    }*/

   /* @Override
    public void removeProductFromCart(Long id,Product product) {

        Cart cart = getCartById(id);
        cart.getProducts().remove(product);
        cartRepo.save(cart);
    }
    */
/*
    @Override
    public void clear() {
        cartRepo.deleteAll();

    }

    @Override
    public List<Product> getProducts() {
        List<Cart> carts = cartRepo.findAll();
        List<Product> products = new ArrayList<>();
        for (Cart cart : carts) {
            products.addAll(cart.getProducts());
        }
        return products;
    }*/

   /* @Override
    public double getTotal() {
        double total = 0;
        List<Product> products = getProducts();
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public Cart assignProductToCart(Long id_product, Long id_cart) {
        Product product = productrepo.findById(id_product).orElse(null);
        Cart cart = cartRepo.findById(id_cart).orElse(null);
        //cart.getListeProduct().add(product);
        cartRepo.save(cart);
        return cart;
    }*/
}

