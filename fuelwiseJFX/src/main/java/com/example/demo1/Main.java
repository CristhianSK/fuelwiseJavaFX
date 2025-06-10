package com.example.demo1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Fuelwise");

        // Criação da instância do CRUD de veículos
        VeiculosCrud veiculosCrud = new VeiculosCrud(stage);

        // Interface da tela inicial (Home)
        VBox homeBox = new VBox(20);
        homeBox.setAlignment(Pos.CENTER);

        Label lbl1 = new Label("Home");
        lbl1.setFont(new Font("Arial", 28));

        Button visualizarBtn = new Button("Visualizar Veículos");
        visualizarBtn.setOnAction(e -> stage.setScene(veiculosCrud.getVisualizarScene()));

        homeBox.getChildren().addAll(lbl1, visualizarBtn);

        Scene homeScene = new Scene(homeBox, 500, 400);
        stage.setScene(homeScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
