package com.libreria.libreria.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class indexController {
    @FXML
    public void loadNewBorrower(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/libreria/libreria/createBorrower.fxml"));
            Scene scene = new Scene(fxmlLoader.load(),500,450);

            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("Crear Borrower");
            BorrowerController borrowerController = fxmlLoader.getController();
            borrowerController.setModo("crear");
            nuevaVentana.setScene(scene);
            nuevaVentana.show();

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al abrir la ventana de creacion de Borrower"+e.getMessage());

        }
    }
    @FXML
    public void loadNewDebt(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profesoresPU"));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al abrir ventana de deudores: "+e);
        }
    }
}
