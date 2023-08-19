package com.shoppingCart.ShoppingCart.controller;

import com.shoppingCart.ShoppingCart.model.Product;
import com.shoppingCart.ShoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/items")
    public List<Product> getAllItems(){
        return productService.getItems();
    }

    @PostMapping("/new")
    public ResponseEntity<String> addItem(@RequestBody Product newProduct){
        productService.addNewItem(newProduct);
        return new ResponseEntity<>("Added Item", HttpStatus.OK);
    }

    @GetMapping("/checkout")
    public int getTotalPrice(){
        List<Product> cart = productService.getItems();
        return productService.calculatePrice(cart);
    }
}
