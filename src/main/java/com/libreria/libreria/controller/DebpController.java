package com.libreria.libreria.controller;

import com.libreria.libreria.model.Entity.Debt;
import com.libreria.libreria.model.Service.DebtService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DebpController implements Initializable {
    @FXML
    private TableView<Debt> tableview;
    @FXML
    private TableColumn<Debt, Integer> idColumn;




    private DebtService debtService = new DebtService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            idColumn.setCellValueFactory(new PropertyValueFactory<>("idDebt"));

            List<Debt> debts = debtService.getAll();

            if(debts==null){
                System.out.println("No hay datos disponibles");
                tableview.setItems(FXCollections.observableArrayList()); // lista vacía
                return;
            }
            ObservableList<Debt> observableList = FXCollections.observableArrayList(debts);
            tableview.setItems(observableList);




        }catch (Exception e){
            System.out.println("Error al inicializar: "+e);
            e.printStackTrace();

        }

    }
}
