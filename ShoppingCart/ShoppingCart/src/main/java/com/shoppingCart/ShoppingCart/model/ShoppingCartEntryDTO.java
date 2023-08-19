package com.shoppingCart.ShoppingCart.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ShoppingCartEntryDTO {

    @Id
    private Long id;
    private Long cartId;
    private Long productId;
}
