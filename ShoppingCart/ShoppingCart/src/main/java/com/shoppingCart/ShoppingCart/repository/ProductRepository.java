package com.shoppingCart.ShoppingCart.repository;

import com.shoppingCart.ShoppingCart.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
