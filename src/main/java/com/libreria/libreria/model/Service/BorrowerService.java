package com.libreria.libreria.model.Service;

import com.libreria.libreria.model.Entity.Borrower;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BorrowerService {
    private EntityManagerFactory emf ;
    public BorrowerService(){
        emf = Persistence.createEntityManagerFactory("profesoresPU");
    }
        public void saveBorrower(Borrower borrower){
            EntityManager em =emf.createEntityManager();
            try{
                em.getTransaction().begin();
                em.persist(borrower);
                em.getTransaction().commit();

            }catch (Exception e){
                em.getTransaction().rollback();
                e.printStackTrace();
            }finally {
                em.close();
            }
        }
}
