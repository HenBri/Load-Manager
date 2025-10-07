package com.libreria.libreria.model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products_table")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long Id;
    @Column(name = "name_product")
    private String name;
    @Column(name = "price_product")
    private Integer price;
    @Column(name = "state_product")
    private Boolean state;

}
