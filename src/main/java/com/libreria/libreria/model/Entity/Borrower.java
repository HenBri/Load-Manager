package com.libreria.libreria.model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name= "borrower_table")
@Getter
@Setter
public class Borrower {
    @Id
    @Column(name="borrower_id")
    private Long id;
    @Column(name= "borrower_nombre")
    private String nombre;
    @Column(name = "borrower_apellido")
    private String apellido;
    @Column(name="borrower_turno")
    private String turno;
    @Column(name = "date_create")
    private Date fechaCreate;
    @Column(name="fecha_update")
    private Date fechaUpdate;
    @Column(name = "borrower_state")
    private boolean state;
    @Column(name = "borrower_age")
    private int age;


}
