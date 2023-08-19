package com.shoppingCart.ShoppingCart.service;

import com.shoppingCart.ShoppingCart.model.ShoppingCart;
import com.shoppingCart.ShoppingCart.repository.CartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }
    public ShoppingCart findCartById(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found"));

    }
}
