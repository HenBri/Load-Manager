package com.libreria.libreria.controller;

import com.libreria.libreria.model.Entity.Borrower;
import com.libreria.libreria.model.Service.BorrowerService;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.List;

public class BorrowerController {

    @FXML ListView<Borrower> listView;
    private BorrowerService borrowerService = new BorrowerService();

    @FXML
    private void initialize(){
        List<Borrower> borrowers=borrowerService.getAllBorrower();
        System.out.println("Borrowers desde BDD: " + borrowers);
        ObservableList<Borrower> borrowerObservableList= FXCollections.observableList(borrowers);
        listView.setItems(borrowerObservableList);
    }
}
