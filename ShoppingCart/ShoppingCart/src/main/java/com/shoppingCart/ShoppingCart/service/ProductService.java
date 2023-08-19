package com.shoppingCart.ShoppingCart.service;

import com.shoppingCart.ShoppingCart.model.Product;
import com.shoppingCart.ShoppingCart.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//Class performs business logic for all crud operations
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getItems() {
       return (List<Product>) productRepository.findAll();
    }

    public void addNewItem(Product product){
        productRepository.save(product);
    }


    public int calculatePrice(List<Product> cart) {
        int total = cart.stream().mapToInt(Product::getPrice).sum();
        return total;
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }
}
