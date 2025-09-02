package com.libreria.libreria.model.Service;

import com.libreria.libreria.model.Entity.Borrower;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

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

        public Borrower getById(Long idBorrower){
            EntityManager em =emf.createEntityManager();

            try{
                return  em.find(Borrower.class, idBorrower);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Error en el id"+e);
            }finally {
                em.close();
            }
        }

        public List<Borrower> getAllBorrower(){
            EntityManager em = emf.createEntityManager();
            try{
                 return em.createQuery("SELECT u FROM borrower_Table", Borrower.class)
                         .getResultList();
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Eror, el metodo get all no se completo:"+e);
            }finally {
                emf.close();
            }
        }

        public void updateBorrower(Long id, Borrower updateBorrower){
            EntityManager em = emf.createEntityManager();
            try{
                em.getTransaction().begin();

                Borrower borrower = getById(id);

                borrower.setNombre(updateBorrower.getNombre());
                borrower.setApellido(updateBorrower.getApellido());
                borrower.setTurno(updateBorrower.getTurno());

                em.merge(borrower);
                em.getTransaction().commit();


            }catch (IllegalArgumentException e){
                throw new RuntimeException("Error, no se pudo actualizar"+e);
            }finally {
                emf.close();
            }
        }
}
