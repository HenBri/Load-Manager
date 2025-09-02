package com.libreria.libreria;

import com.libreria.libreria.controller.BorrowerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("createBorrower.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 340);
        stage.setTitle("Hello!");

        stage.setScene(scene);
        stage.show();

        BorrowerController controller = fxmlLoader.getController();
        controller.setModo("otro");
    }

    public static void main(String[] args) {
        launch();
    }
}