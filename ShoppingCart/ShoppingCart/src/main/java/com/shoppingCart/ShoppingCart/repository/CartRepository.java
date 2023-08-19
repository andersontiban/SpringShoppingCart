package com.shoppingCart.ShoppingCart.repository;

import com.shoppingCart.ShoppingCart.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<ShoppingCart, Long> {
}
