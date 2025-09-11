package com.libreria.libreria.model.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "payment_entity")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Long id;

    @Column(name = "date_create_payment")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "amount_payment")
    private Integer amount;

    @Column(name = "detail")
    private String detail;

    @Column(name = "method_payment")
    private String method;
    @Column(name = "state_payment")
    private Boolean state;

    @PrePersist
    private void onPrePersist(){
        this.date = new Date();
        this.setState(true);
    }
}
