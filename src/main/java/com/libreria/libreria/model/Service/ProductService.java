package com.libreria.libreria.model.Service;

import com.libreria.libreria.model.Entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProductService {
    private EntityManagerFactory emf;

    public ProductService(){
        emf = Persistence.createEntityManagerFactory("profesoresPU");
    }

    private void SaveProduct(Product product){
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error al guardar Product"+e);
        }finally {
            entityManager.close();
        }

    }

    private Product getById(Long idProduct){
        EntityManager entityManager = emf.createEntityManager();
        try{
            return entityManager.find(Product.class, idProduct);
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error al obtener Product por Id"+e);
        }finally {
            entityManager.close();
        }
    }
    private void updateProduct(Product product, Long idProduct){
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Product productUpdate = getById(idProduct);
            productUpdate.setState(false);
            entityManager.persist(product);

            entityManager.getTransaction().commit();
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error al actualizar Product"+e);
        }finally {
            entityManager.close();
        }
    }

    private void deleteProduct(Long idProduct){
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Product product = getById(idProduct);
            product.setState(false);
            entityManager.merge(product);
            entityManager.getTransaction().commit();
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error al eliminar Product"+e);
        }finally {
            entityManager.close();
        }
    }
    private List<Product> getAll(){
        EntityManager entityManager = emf.createEntityManager();
        try{
            return entityManager.createQuery("SELECT u FROM Product u", Product.class).getResultList();
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error al obtener todos los Product"+e);
        }finally {
            entityManager.close();
        }
    }
}
