package com.libreria.libreria.model.Service;

import com.libreria.libreria.model.Entity.Debt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class DebtService {
    private EntityManagerFactory emf;
    public DebtService(){
        emf = Persistence.createEntityManagerFactory("profesoresPU");
    }

    public void saveDebt(Debt debt){
        EntityManager entityManager = emf.createEntityManager();

        try{
            entityManager.getTransaction().begin();

            entityManager.persist(debt);
            entityManager.getTransaction().commit();

        }catch (IllegalArgumentException e){
            throw  new RuntimeException("Error al guardar debt"+e);
        }finally {
            entityManager.close();
        }


    }
    public Debt getById(Long idDebt){
        EntityManager entityManager= emf.createEntityManager();
        try {
            return entityManager.find(Debt.class,idDebt);
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error al obtener Debt por Id"+e);

        }finally {
            entityManager.close();
        }
    }
    public List<Debt> getAll(){
        EntityManager entityManager = emf.createEntityManager();
        try {
            return entityManager.createQuery("SELECT u FROM Debt u",Debt.class).getResultList();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error al obtener todos: "+e);
        }finally {
            entityManager.close();
        }
    }
    public void updateDebt(Debt debt, Long idDebt){
        EntityManager entityManager= emf.createEntityManager();

        try{
            entityManager.getTransaction().begin();

            Debt debtUpdate = getById(idDebt);

            debtUpdate.setAmount(debt.getAmount());
            debtUpdate.setDetail(debt.getDetail());

            entityManager.merge(debtUpdate);

            entityManager.getTransaction().commit();

        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error al actualizar debt"+e);
        }finally {
            entityManager.close();
        }
    }

    public void deleteDebt(Long idDebtDelete){
        EntityManager entityManager= emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Debt debt = getById(idDebtDelete);

            debt.setState(false);
            entityManager.merge(debt);

            entityManager.getTransaction().commit();

        }catch (IllegalArgumentException e){
            throw  new RuntimeException("Error al eliminar Debt"+e);
        }finally {
            entityManager.close();
        }
    }
}
