package com.cloudit.project.serviceImpl;

import com.cloudit.project.model.Cart;
import com.cloudit.project.model.CartLine;
import com.cloudit.project.model.Orderr;
import com.cloudit.project.model.Product;
import com.cloudit.project.repository.CartLineRepo;
import com.cloudit.project.repository.CartRepo;
import com.cloudit.project.repository.OrderRepo;
import com.cloudit.project.repository.ProductRepo;
import com.cloudit.project.service.ICart;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CartService implements ICart {

    @Autowired
    CartLineRepo cartLineRepo;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
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
    @Override
    //@Autowired
   public HashMap<String,Double> CartTotal(Long id_cart) {
       Cart cart = cartRepo.findById(id_cart).
               orElseThrow(() ->new EntityNotFoundException("cart not found with id " + id_cart));

       double total = 0;
       HashMap<String, Double> CartMap = new HashMap<>();
        for (CartLine cartLine : cart.getCartLineList()) {
            Orderr order= orderRepo.findById(cartLine.getOrdre().getId_order()).orElse(null);
            double cartsum = cartLine.getPrix()*cartLine.getQuantie();
            CartMap.put("CartLine id "+cartLine.getId_linecart(),cartsum);
            total = total + cartsum;
            order.setTotal(total);
        }
       CartMap.put("Cart total  ", total);

       return CartMap;
   }
}

