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
            nuevaVentana.setScene(scene);
            nuevaVentana.show();

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al abrir la ventana de creacion de Borrower"+e.getMessage());

        }
    }
}
