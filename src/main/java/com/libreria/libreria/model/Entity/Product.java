package com.libreria.libreria.model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "product_table")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer id;


    @Column(name ="name_product")
    private String name;

    @Column(name = "price_product")
    private Integer price;

    @Column(name="date_create_product")
    @Temporal(TemporalType.DATE)
    private Date dateCreate;

    @Column(name = "date_delete_product")
    @Temporal(TemporalType.DATE)
    private Date dateDelete;

    @Column(name = "state_date")
    private boolean state;

}
