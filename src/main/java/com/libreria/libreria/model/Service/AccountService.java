package com.libreria.libreria.model.Service;

import com.libreria.libreria.model.Entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AccountService {
    private EntityManagerFactory emf;
    public AccountService(){
        this.emf = Persistence.createEntityManagerFactory("profesoresPU");
    }

    public void saveAccount(Account account){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(account);
            em.getTransaction().commit();

        }catch (IllegalArgumentException e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
    public Account getById(Long idAccount){
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Account.class, idAccount);
        }catch (IllegalArgumentException e){
            throw new RuntimeException(e);
        }finally {
            em.close();
        }

    }

    public List<Account> getAll(){
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("SELECT u FROM Account u"
                            , Account.class)
                        .getResultList();

        }catch (IllegalArgumentException e){
            throw new RuntimeException(e);
        }
    }
    public void updateAccount(Account accountUpdate, Long idAccountUpdate){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Account account = getById(idAccountUpdate.longValue());
            account.setBalance(accountUpdate.getBalance());
            account.setCredit(accountUpdate.getCredit());

            em.merge(account);
            em.getTransaction().commit();

        }catch (IllegalArgumentException e){
            throw new RuntimeException(e);
        }finally {
            em.close();
        }

    }
}
