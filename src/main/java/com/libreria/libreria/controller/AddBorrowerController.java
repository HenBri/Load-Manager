package com.libreria.libreria.controller;

import com.libreria.libreria.model.Entity.Borrower;
import com.libreria.libreria.model.Service.BorrowerService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddBorrowerController {
    private BorrowerService borrowerService =new BorrowerService();

    @FXML private TextField textFieldNombre;
    @FXML private TextField textFieldApellido;
    @FXML private TextField textFieldTurno;
    @FXML private Label lblTitle;

    public void setModo(String modo){
        if(modo.equals("crear")){
            lblTitle.setText("Crear Usuario");
        }else{
            lblTitle.setText("Update un Usuario");
        }
    }


    @FXML
    private void createBorrower(){
        Borrower borrower=new Borrower();
        borrower.setNombre(textFieldNombre.getText());
        borrower.setApellido(textFieldApellido.getText());
        borrower.setTurno(textFieldTurno.getText());

        borrowerService.saveBorrower(borrower);

        textFieldNombre.clear();
        textFieldApellido.clear();
        textFieldTurno.clear();
    }


}
