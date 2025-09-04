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
        Account account = new Account();
        account.setCredit(100);
        account.setBalance(200);

        AccountService accountService = new AccountService();

        accountService.saveAccount(account);
        System.out.println("Se guardo Con exito");


        // VERIFICAR getById

        Account accountById = accountService.getById(Long.valueOf(6));
        System.out.println("el balance de account ById es: "+ accountById.getBalance());

        // verificar update

        Account updateAccount = new Account();

        updateAccount.setCredit(10);
        updateAccount.setBalance(10);
        accountService.updateAccount(updateAccount,Long.valueOf(6));

        Account cuentaActualizada = accountService.getById(Long.valueOf(1));

        System.out.println("si la cuenta se actualizo deberia de ser 10; "+cuentaActualizada.getCredit());

        // verificar GetALL

        List<Account> accounts = accountService.getAll();

        for (int i = 0; i < accounts.toArray().length-1; i++) {
            System.out.println("los datos son: "+accounts.get(i).getCredit());
        }



    }
}