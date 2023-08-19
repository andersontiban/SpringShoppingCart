package com.shoppingCart.ShoppingCart.service;

import com.shoppingCart.ShoppingCart.model.ShoppingCartEntry;
import com.shoppingCart.ShoppingCart.repository.ShoppingCartEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartEntryService {

    private final ShoppingCartEntryRepository shoppingCartEntryRepository;

    @Autowired
    public ShoppingCartEntryService(ShoppingCartEntryRepository shoppingCartEntryRepository){
        this.shoppingCartEntryRepository = shoppingCartEntryRepository;
    }


    public void addItem(ShoppingCartEntry shoppingCartEntry) {
        shoppingCartEntryRepository.save(shoppingCartEntry);
    }

    public List<ShoppingCartEntry> getAll() {
        return (List<ShoppingCartEntry>) shoppingCartEntryRepository.findAll();
    }
}
