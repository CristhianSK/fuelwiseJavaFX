package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VeiculosCrud {
    private ObservableList<Veiculo> veiculos = FXCollections.observableArrayList();

    private Scene cadastroScene;
    private Scene visualizarScene;
    private Stage cadastroStage;

    public VeiculosCrud(Stage primaryStage) {
        initCadastroScene(primaryStage);
        initVisualizarScene(primaryStage);
    }

    private void initCadastroScene(Stage owner) {
        VBox box2 = new VBox(20);
        box2.setAlignment(Pos.CENTER);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setAlignment(Pos.CENTER);
        box2.getChildren().add(grid);

        TextField placa = new TextField();
        placa.setPromptText("Placa");
        GridPane.setConstraints(placa, 0, 0);

        TextField modelo = new TextField();
        modelo.setPromptText("Modelo");
        GridPane.setConstraints(modelo, 0, 1);

        TextField fabricante = new TextField();
        fabricante.setPromptText("Fabricante");
        GridPane.setConstraints(fabricante, 0, 2);

        TextField ano = new TextField();
        ano.setPromptText("Ano de Fabricação");
        GridPane.setConstraints(ano, 0, 3);

        TextField obs = new TextField();
        obs.setPromptText("Observações");
        GridPane.setConstraints(obs, 0, 4);

        Button addBtn = new Button("Adicionar");
        Button clearBtn = new Button("Limpar");
        GridPane.setConstraints(addBtn, 1, 0);
        GridPane.setConstraints(clearBtn, 1, 1);

        Label info = new Label();
        GridPane.setConstraints(info, 0, 5, 2, 1);

        grid.getChildren().addAll(placa, modelo, fabricante, ano, obs, addBtn, clearBtn, info);

        addBtn.setOnAction(e -> {
            if (!placa.getText().isEmpty() && !modelo.getText().isEmpty() &&
                    !fabricante.getText().isEmpty() && !ano.getText().isEmpty()) {
                Veiculo v = new Veiculo(placa.getText(), modelo.getText(), ano.getText(), obs.getText(), fabricante.getText());
                veiculos.add(v);
                info.setText("Veículo adicionado: " + v.getPlaca());
                placa.clear(); modelo.clear(); fabricante.clear(); ano.clear(); obs.clear();
            } else {
                showAlert("Preencha todos os campos obrigatórios.");
            }
        });

        clearBtn.setOnAction(e -> {
            placa.clear(); modelo.clear(); fabricante.clear(); ano.clear(); obs.clear();
        });

        Button closeBtn = new Button("Fechar");
        closeBtn.setOnAction(e -> cadastroStage.close());
        box2.getChildren().add(closeBtn);

        cadastroScene = new Scene(box2, 400, 400);

        cadastroStage = new Stage();
        cadastroStage.initOwner(owner);
        cadastroStage.initModality(Modality.WINDOW_MODAL);
        cadastroStage.setScene(cadastroScene);
        cadastroStage.setTitle("Cadastro de Veículo");
    }

    private void initVisualizarScene(Stage primaryStage) {
        VBox box3 = new VBox(15);
        box3.setAlignment(Pos.CENTER);

        Label lbl = new Label("Veículos Registrados");
        lbl.setFont(new Font("Arial", 20));

        TableView<Veiculo> table = new TableView<>();
        table.setEditable(true);
        table.setItems(veiculos);

        TableColumn<Veiculo, String> placaCol = new TableColumn<>("Placa");
        placaCol.setCellValueFactory(new PropertyValueFactory<>("placa"));
        placaCol.setCellFactory(TextFieldTableCell.forTableColumn());
        placaCol.setOnEditCommit(e -> {
            if (!e.getNewValue().trim().isEmpty()) {
                e.getRowValue().setPlaca(e.getNewValue());
            } else {
                table.refresh();
            }
        });

        TableColumn<Veiculo, String> modeloCol = new TableColumn<>("Modelo");
        modeloCol.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        modeloCol.setCellFactory(TextFieldTableCell.forTableColumn());
        modeloCol.setOnEditCommit(e -> {
            if (!e.getNewValue().trim().isEmpty()) {
                e.getRowValue().setModelo(e.getNewValue());
            } else {
                table.refresh();
            }
        });

        TableColumn<Veiculo, String> fabricanteCol = new TableColumn<>("Fabricante");
        fabricanteCol.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
        fabricanteCol.setCellFactory(TextFieldTableCell.forTableColumn());
        fabricanteCol.setOnEditCommit(e -> {
            if (!e.getNewValue().trim().isEmpty()) {
                e.getRowValue().setFabricante(e.getNewValue());
            } else {
                table.refresh();
            }
        });

        TableColumn<Veiculo, String> anoCol = new TableColumn<>("Ano");
        anoCol.setCellValueFactory(new PropertyValueFactory<>("anoFabricacao"));
        anoCol.setCellFactory(TextFieldTableCell.forTableColumn());
        anoCol.setOnEditCommit(e -> {
            if (!e.getNewValue().trim().isEmpty()) {
                e.getRowValue().setAnoFabricacao(e.getNewValue());
            } else {
                table.refresh();
            }
        });

        TableColumn<Veiculo, String> obsCol = new TableColumn<>("Observações");
        obsCol.setCellValueFactory(new PropertyValueFactory<>("observacao"));
        obsCol.setCellFactory(TextFieldTableCell.forTableColumn());
        obsCol.setOnEditCommit(e -> e.getRowValue().setObservacao(e.getNewValue()));

        table.getColumns().addAll(placaCol, modeloCol, fabricanteCol, anoCol, obsCol);

        Button addBtn = new Button("Adicionar novo veículo");
        addBtn.setOnAction(e -> cadastroStage.showAndWait());

        Button removeBtn = new Button("Remover selecionado");
        removeBtn.setOnAction(e -> {
            Veiculo v = table.getSelectionModel().getSelectedItem();
            if (v != null) veiculos.remove(v);
            else showAlert("Selecione um veículo para remover.");
        });

        Button voltarBtn = new Button("Voltar");
        voltarBtn.setOnAction(e -> primaryStage.setScene(getHomeScene(primaryStage)));

        box3.getChildren().addAll(lbl, table, addBtn, removeBtn, voltarBtn);
        visualizarScene = new Scene(box3, 500, 400);
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    // Apenas para simular botão de "home" no visualizador
    private Scene getHomeScene(Stage stage) {
        VBox homeBox = new VBox(20);
        homeBox.setAlignment(Pos.CENTER);
        Label lbl1 = new Label("Home");
        lbl1.setFont(new Font("Arial", 28));
        Button btn = new Button("Visualizar Veículos");
        btn.setOnAction(e -> stage.setScene(visualizarScene));
        homeBox.getChildren().addAll(lbl1, btn);
        return new Scene(homeBox, 500, 400);
    }

    public Scene getVisualizarScene() {
        return visualizarScene;
    }

    public void showCadastroModal() {
        cadastroStage.showAndWait();
    }
}
