package com.libreria.libreria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProfesorService {
    private EntityManagerFactory emf;
    public ProfesorService() {
        emf = Persistence.createEntityManagerFactory("profesoresPU");
    }
    public void guardarProfesor(Profesor profesor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(profesor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
