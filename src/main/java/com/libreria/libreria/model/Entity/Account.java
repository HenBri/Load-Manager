package com.libreria.libreria.model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
    @Table(name = "account_table")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private Long Id;

    @Column(name = "balance_account")
    private Integer balance;
    @Column(name="credit_account")
    private Integer credit;
    @Column(name = "date_create_account")
    private Date dateCreate;
    @Column(name = "state_account")
    private boolean state;

    @PrePersist
    public void onPersist(){
        this.balance=0;
        this.credit=0;
        this.dateCreate = new Date();
        this.state = true;
    }

}
