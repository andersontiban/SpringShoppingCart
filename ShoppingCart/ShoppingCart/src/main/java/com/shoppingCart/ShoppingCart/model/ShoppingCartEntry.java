package com.shoppingCart.ShoppingCart.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ShoppingCartEntry {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonBackReference
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
