package com.libreria.libreria;

import com.libreria.libreria.model.Entity.Account;
import com.libreria.libreria.model.Entity.Borrower;
import com.libreria.libreria.model.Service.AccountService;
import com.libreria.libreria.model.Service.BorrowerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class TestConnection {
    public static void main(String[] args) {
        BorrowerService borrowerService = new BorrowerService();
        // verificar GetALL

        List<Borrower> accounts = borrowerService.getAllBorrower();

        for (int i = 0; i < accounts.toArray().length-1; i++) {
            System.out.println("los datos son: "+accounts.get(i).getNombre());
        }



    }
}