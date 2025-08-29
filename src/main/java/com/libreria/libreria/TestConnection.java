package com.libreria.libreria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestConnection {
    public static void main(String[] args) {
        ProfesorService service = new ProfesorService();
        Profesor profesor = new Profesor();
        profesor.setNombre("Juan");
        profesor.setApellido("Pérez");
        profesor.setEmail("juan.perez@example.com");
        service.guardarProfesor(profesor);
    }
}