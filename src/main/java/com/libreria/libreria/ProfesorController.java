package com.libreria.libreria;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ProfesorController {
    @FXML private TextField nombreField;
    @FXML private TextField apellidoField;
    @FXML private TextField emailField;
    private ProfesorService profesorService = new ProfesorService();
    @FXML
    private void guardarProfesor() {
        Profesor profesor = new Profesor();
        profesor.setNombre(nombreField.getText());
        profesor.setApellido(apellidoField.getText());
        profesor.setEmail(emailField.getText());
        profesorService.guardarProfesor(profesor);
        // Limpiar campos
        nombreField.clear();
        apellidoField.clear();
        emailField.clear();
    }
}
