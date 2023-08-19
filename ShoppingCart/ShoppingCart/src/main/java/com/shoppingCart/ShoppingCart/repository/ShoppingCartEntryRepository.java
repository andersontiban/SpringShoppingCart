package com.shoppingCart.ShoppingCart.repository;

import com.shoppingCart.ShoppingCart.model.ShoppingCartEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartEntryRepository extends CrudRepository<ShoppingCartEntry, Long> {
}
