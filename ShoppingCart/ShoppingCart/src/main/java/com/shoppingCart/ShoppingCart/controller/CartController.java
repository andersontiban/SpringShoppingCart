package com.shoppingCart.ShoppingCart.controller;

import com.shoppingCart.ShoppingCart.model.Product;
import com.shoppingCart.ShoppingCart.model.ShoppingCart;
import com.shoppingCart.ShoppingCart.model.ShoppingCartEntry;
import com.shoppingCart.ShoppingCart.model.ShoppingCartEntryDTO;
import com.shoppingCart.ShoppingCart.repository.CartRepository;
import com.shoppingCart.ShoppingCart.service.CartService;
import com.shoppingCart.ShoppingCart.service.ProductService;
import com.shoppingCart.ShoppingCart.service.ShoppingCartEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final ShoppingCartEntryService shoppingCartEntryService;
    private final CartService cartService;
    private final ProductService productService;


    @Autowired
    public CartController(ShoppingCartEntryService shoppingCartEntryService, CartService cartService, ProductService productService){
        this.shoppingCartEntryService = shoppingCartEntryService;
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<ShoppingCartEntry> allCarts(){
        return shoppingCartEntryService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addItemToCart(@RequestBody ShoppingCartEntryDTO shoppingCartEntryDTO){
        System.out.println(shoppingCartEntryDTO.getCartId());
        System.out.println(shoppingCartEntryDTO.getProductId());
        ShoppingCart cart = cartService.findCartById(shoppingCartEntryDTO.getCartId());
        Product product = productService.findProductById(shoppingCartEntryDTO.getProductId());
        ShoppingCartEntry entry = new ShoppingCartEntry();
        entry.setId(shoppingCartEntryDTO.getId());
        entry.setShoppingCart(cart);
        entry.setProduct(product);
        shoppingCartEntryService.addItem(entry);
        return new ResponseEntity<>("Added", HttpStatus.OK);
    }
}
