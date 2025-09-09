package com.libreria.libreria.model.Service;

import com.libreria.libreria.model.Entity.Payment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class PaymentService {
    private EntityManagerFactory emf;
    public PaymentService(){
        emf = Persistence.createEntityManagerFactory("profesoresUP");
    }
    public void savePayment(Payment payment){
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(payment);
            em.getTransaction().commit();

        }catch (IllegalArgumentException e){
            em.getTransaction().rollback();
            throw new RuntimeException("Error al guadar Payment"+e);
        }finally {
            em.close();
        }
    }
    public Payment getById(Long idPayment){
        EntityManager em = emf.createEntityManager();

        try{
            return em.find(Payment.class, idPayment);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }finally {
            em.close();
        }
    }
    public List<Payment> getAll(){
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("SELECT u FROM Payment u"
                    , Payment.class).getResultList();

        }catch (IllegalArgumentException e){
            throw  new RuntimeException("Error al obtener todos"+e);
        }finally {
            em.close();
        }
    }
    public void updatePayment(Payment updatePayment, Long idUpdate){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Payment payment = getById(idUpdate);

            payment.setAmount(updatePayment.getAmount());
            payment.setMethod(updatePayment.getMethod());
            payment.setDetail(updatePayment.getDetail());
            em.merge(payment);

            em.getTransaction().commit();

        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error al actualizar"+e);
        }finally {
            em.close();
        }

    }
    public void deletePayment(Long idDelete){
        EntityManager em = emf.createEntityManager();
        try{
            Payment paymentDelete = getById(idDelete);
            paymentDelete.setState(false);

            em.merge(paymentDelete);
            em.getTransaction().commit();

        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error al eliminar Payment"+e);
        }finally {
            em.close();
        }
    }


}
