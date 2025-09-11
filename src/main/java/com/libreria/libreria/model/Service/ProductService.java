package com.libreria.libreria.model.Service;

import com.libreria.libreria.model.Entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.sql.Update;

import javax.xml.stream.events.ProcessingInstruction;
import java.util.Date;
import java.util.List;

public class ProductService {
    EntityManagerFactory entityManagerFactory;
    public ProductService(){
        entityManagerFactory = Persistence.createEntityManagerFactory("profesoresPU");
    }

    public void saveProduct(Product product){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            entityManager.getTransaction().begin();

            entityManager.persist(product);

            entityManager.getTransaction().commit();

        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error al guardar producto: "+e);
        }finally {
            entityManager.close();
        }
    }

    public Product getById(Long idProduct){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Product.class,idProduct);
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error al obtener por Id: "+e);
        }finally {
            entityManager.close();
        }
    }
    public List<Product> getAll(){
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        try{
            return entityManager.createQuery("SELECT u FROM Product u").getResultList();
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error al obtener todos: "+e);
        }finally {
            entityManager.close();
        }
    }
    public void deleteProduct(Long id){
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Product deleteProduct = getById(id);

            deleteProduct.setState(false);
            deleteProduct.setDateDelete(new Date());

            entityManager.getTransaction().commit();

        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error al eliminar producto: "+e);
        }finally {
            entityManager.close();
        }
    }
    public void updateProduct(Product newProduct, Long idProduct){
        EntityManager entityManager= entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Product productDelete = getById(idProduct);
            entityManager.merge(newProduct);

            entityManager.getTransaction().commit();

        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error al eliminar producto: "+e);
        }finally {
            entityManager.close();
        }

    }
}
