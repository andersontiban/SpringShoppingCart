package com.shoppingCart.ShoppingCart.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    @Id
    private Long cartId;

    @OneToMany(mappedBy = "shoppingCart")
    @JsonManagedReference
    private List<ShoppingCartEntry> entries;
}
