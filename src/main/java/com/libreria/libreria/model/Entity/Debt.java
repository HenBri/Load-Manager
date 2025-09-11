package com.libreria.libreria.model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "debt_table")
public class Debt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_debt")
    private Long id;

    @Column(name = "create_date_debt")
    @Temporal(TemporalType.DATE)
    private Date date;

        @Column(name = "amount_leaves_debt")
        private Integer leaves;

        @Column(name = "additional_debt")
        private Integer additional;

        @Column(name = "detail_debt")
        private String detail;

        @Column(name = "amount_debt")
        private Integer amount;

    @Column(name = "state_debt")
    private Boolean state;

    @PrePersist
    private void onPrePersist(){
        this.date= new Date();
        this.state = true;
    }

}
