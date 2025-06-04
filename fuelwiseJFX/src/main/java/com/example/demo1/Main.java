package com.example.demo1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Fuelwise");

        VBox box1 = new VBox();
        box1.setAlignment(Pos.CENTER);
        box1.setSpacing(20);

        VBox box2 = new VBox();
        box2.setAlignment(Pos.CENTER);
        box2.setSpacing(20);

        VBox box3 = new VBox();
        box3.setAlignment(Pos.CENTER);
        box3.setSpacing(20);

        Label lbl1 = new Label("Home");
        lbl1.setAlignment(Pos.CENTER);
        lbl1.setFont(new Font("Arial", 28));
        box1.getChildren().add(lbl1);


        //GridPane onde os inputs vao ficar
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setAlignment(Pos.CENTER);

        box2.getChildren().add(grid);
AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA

        //Input pra placa
        final TextField placa = new TextField();
        placa.setPromptText("Insira a placa do veículo:");
        placa.setPrefColumnCount(15);
        placa.getText();
        GridPane.setConstraints(placa, 0, 0);
        grid.getChildren().add(placa);

        //Input pro modelo
        final TextField modelo = new TextField();
        modelo.setPromptText("Insira o modelo do veículo");
        modelo.setPrefColumnCount(15);
        modelo.getText();
        GridPane.setConstraints(modelo, 0, 1);
        grid.getChildren().add(modelo);

        //Input pra observação
        final TextField observacao = new TextField();
        observacao.setPromptText("Insira uma observação sobre o veículo");
        observacao.setPrefColumnCount(15);
        observacao.getText();
        GridPane.setConstraints(observacao, 0, 2);
        grid.getChildren().add(observacao);

        //Input pros eixos
        final TextField eixos = new TextField();
        eixos.setPromptText("Insira os eixos do veículo");
        eixos.setPrefColumnCount(15);
        eixos.getText();
        GridPane.setConstraints(eixos, 0, 3);
        grid.getChildren().add(eixos);

        //Input pros litragem
        final TextField litragem = new TextField();
        litragem.setPromptText("Insira a capacidade de litragem do veículo");
        litragem.setPrefColumnCount(15);
        litragem.getText();
        GridPane.setConstraints(litragem, 0, 4);
        grid.getChildren().add(litragem);




        //Botão de submit
        Button submit = new Button("Adicionar");
        GridPane.setConstraints(submit, 1, 0);
        grid.getChildren().add(submit);

        //Botão de clear
        Button clear = new Button("Limpar Campos");
        GridPane.setConstraints(clear, 1, 1);
        grid.getChildren().add(clear);

        //Label
        final Label lultimo = new Label();
        GridPane.setConstraints(lultimo, 0, 5);
        GridPane.setColumnSpan(lultimo, 2);
        grid.getChildren().add(lultimo);

        final Label lveiculo = new Label();
        GridPane.setConstraints(lveiculo, 0, 6);
        GridPane.setColumnSpan(lveiculo, 2);
        grid.getChildren().add(lveiculo);

        final Label lveiculo2 = new Label();
        GridPane.setConstraints(lveiculo2, 0, 7);
        GridPane.setColumnSpan(lveiculo2, 2);
        grid.getChildren().add(lveiculo2);

        final Label lveiculo3 = new Label();
        GridPane.setConstraints(lveiculo3, 0, 8);
        GridPane.setColumnSpan(lveiculo3, 2);
        grid.getChildren().add(lveiculo3);

        final Label lveiculo4 = new Label();
        GridPane.setConstraints(lveiculo4, 0, 9);
        GridPane.setColumnSpan(lveiculo4, 2);
        grid.getChildren().add(lveiculo4);

        final Label lveiculo5 = new Label();
        GridPane.setConstraints(lveiculo5, 0, 10);
        GridPane.setColumnSpan(lveiculo5, 2);
        grid.getChildren().add(lveiculo5);


        //Setando ação pro botao de submit
        ObservableList<Veiculo> veiculos = FXCollections.observableArrayList();
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!placa.getText().isEmpty() && !modelo.getText().isEmpty()
                    && !eixos.getText().isEmpty() && !litragem.getText().isEmpty()){
                        Veiculo veiculo = new Veiculo (placa.getText(), modelo.getText(), eixos.getText(), observacao.getText(), litragem.getText());
                        lultimo.setText("Dados do ultimo veículo adicionado:");
                        lveiculo.setText("Placa do veiculo: "+veiculo.getPlaca());
                        lveiculo2.setText("Modelo do veiculo: "+veiculo.getModelo());
                        lveiculo3.setText("Eixos do veiculo: "+veiculo.getEixos());
                        lveiculo4.setText("Litragem do veiculo: "+veiculo.getLitragem());
                        lveiculo5.setText("Observacao do veiculo: "+veiculo.getObservacao());
                        veiculos.add(veiculo);
                        placa.clear();
                        modelo.clear();
                        observacao.clear();
                        litragem.clear();
                        eixos.clear();
                }else{
                    lveiculo.setText("Todos os campos precisam ser preenchidos");
                }
            }

        });


        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                placa.clear();
                modelo.clear();
                eixos.clear();
                observacao.clear();
            }
        });



        Stage addVeiculo = new Stage();
        addVeiculo.initOwner(stage);
        addVeiculo.initModality(Modality.WINDOW_MODAL);

        Scene modalScene = new Scene(box2, 400, 400);
        addVeiculo.setScene(modalScene);

        Scene scene3 = new Scene(box3,500,400);
        stage.setScene(scene3);
        stage.show();

        Button btn1 = new Button();
        btn1.setText("Visualizar Veículos");
        btn1.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(scene3);
            }
        });
        box1.getChildren().add(btn1);


        Button adicionarVeiculo = new Button("Adicionar novo veiculo");
        adicionarVeiculo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addVeiculo.showAndWait();
            }
        });


        Scene scene = new Scene(box1,500,400);
        stage.setScene(scene);

        Button fecharAddVeiculos = new Button("Fechar");
        fecharAddVeiculos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addVeiculo.close();
            }
        });

        Button voltarHome2 = new Button("Voltar para tela");
        voltarHome2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(scene);
            }
        });
        box2.getChildren().add(fecharAddVeiculos);

         TableView table = new TableView();
         table.setEditable(true);

        TableColumn placaCol = new TableColumn("Placa");
        TableColumn modeloCol = new TableColumn("Modelo");
        TableColumn eixosCol = new TableColumn("Eixos");
        TableColumn litragemCol = new TableColumn("Litragem");
        TableColumn observacaoCol = new TableColumn("Observação");

        placaCol.setCellValueFactory(
                new PropertyValueFactory<Veiculo, String>("placa")
        );
        modeloCol.setCellValueFactory(
                new PropertyValueFactory<Veiculo, String>("modelo")
        );
        eixosCol.setCellValueFactory(
                new PropertyValueFactory<Veiculo, String>("eixos")
        );
        litragemCol.setCellValueFactory(
                new PropertyValueFactory<Veiculo, String>("litragem")
        );
        observacaoCol.setCellValueFactory(
                new PropertyValueFactory<Veiculo, String>("observacao")
        );


        table.setItems(veiculos)    ;
        table.getColumns().addAll(placaCol, modeloCol, eixosCol, litragemCol, observacaoCol);

        Label lbl5 = new Label("Veículos Registrados");
        lbl5.setAlignment(Pos.TOP_CENTER);
        lbl5.setFont(new Font("Arial", 20));

        box3.getChildren().addAll(lbl5, table);
        box3.getChildren().add(voltarHome2);
        box3.getChildren().add(adicionarVeiculo);


    }

    public static void main(String [] args){
        launch();
    }
}
