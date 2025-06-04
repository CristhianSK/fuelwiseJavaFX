package teste.main;

import com.example.demo1.Integrante;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainIntegrante extends Application {
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


        //Input pra email
        final TextField email = new TextField();
        email.setPromptText("Insira o email de cadastro:");
        email.setPrefColumnCount(15);
        email.getText();
        GridPane.setConstraints(email, 0, 0);
        grid.getChildren().add(email);

        //Input pro nome
        final TextField nome = new TextField();
        nome.setPromptText("Insira seu nome de usuário");
        nome.setPrefColumnCount(15);
        nome.getText();
        GridPane.setConstraints(nome, 0, 1);
        grid.getChildren().add(nome);

        //Input pra senha
        final TextField senha = new TextField();
        senha.setPromptText("Insira sua senha");
        senha.setPrefColumnCount(15);
        senha.getText();
        GridPane.setConstraints(senha, 0, 2);
        grid.getChildren().add(senha);

        //Input pros telefone
        final TextField telefone = new TextField();
        telefone.setPromptText("Insira seu telefone");
        telefone.setPrefColumnCount(15);
        telefone.getText();
        GridPane.setConstraints(telefone, 0, 3);
        grid.getChildren().add(telefone);

        //Input pros cpf
        final TextField cpf = new TextField();
        cpf.setPromptText("Insira seu cpf");
        cpf.setPrefColumnCount(15);
        cpf.getText();
        GridPane.setConstraints(cpf, 0, 4);
        grid.getChildren().add(cpf);




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

        final Label lintegrante = new Label();
        GridPane.setConstraints(lintegrante, 0, 6);
        GridPane.setColumnSpan(lintegrante, 2);
        grid.getChildren().add(lintegrante);

        final Label lintegrante2 = new Label();
        GridPane.setConstraints(lintegrante2, 0, 7);
        GridPane.setColumnSpan(lintegrante2, 2);
        grid.getChildren().add(lintegrante2);

        final Label lintegrante3 = new Label();
        GridPane.setConstraints(lintegrante3, 0, 8);
        GridPane.setColumnSpan(lintegrante3, 2);
        grid.getChildren().add(lintegrante3);

        final Label lintegrante4 = new Label();
        GridPane.setConstraints(lintegrante4, 0, 9);
        GridPane.setColumnSpan(lintegrante4, 2);
        grid.getChildren().add(lintegrante4);

        final Label lintegrante5 = new Label();
        GridPane.setConstraints(lintegrante5, 0, 10);
        GridPane.setColumnSpan(lintegrante5, 2);
        grid.getChildren().add(lintegrante5);


        //Setando ação pro botao de submit
        ObservableList<Integrante> integrantes = FXCollections.observableArrayList();
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!email.getText().isEmpty() && !nome.getText().isEmpty()
                        && !senha.getText().isEmpty() && !telefone.getText().isEmpty() && !cpf.getText().isEmpty()){
                    Integrante veiculo = new Integrante(email.getText(), nome.getText(), senha.getText(), telefone.getText(), cpf.getText());
                    lultimo.setText("Dados do ultimo veículo adicionado:");
                    lintegrante.setText("Email: "+integrante.getEmail());
                    lintegrante2.setText("Senha: "+integrante.getSenha());
                    lintegrante3.setText("Usuário: "+integrante.getNome());
                    lintegrante4.setText("Telefone: "+integrante.getTelefone());
                    lintegrante5.setText("CPF: "+integrante.getCpf());
                    integrantes.add(integrante);
                    email.clear();
                    nome.clear();
                    senha.clear();
                    telefone.clear();
                    cpf.clear();
                }else{
                    lintegrante.setText("Todos os campos precisam ser preenchidos");
                }
            }

        });


        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                email.clear();
                nome.clear();
                senha.clear();
                telefone.clear();
                cpf.clear();
            }
        });



        Stage addIntegrante = new Stage();
        addIntegrante.initOwner(stage);
        addIntegrante.initModality(Modality.WINDOW_MODAL);

        Scene modalScene = new Scene(box2, 400, 400);
        addIntegrante.setScene(modalScene);

        Scene scene3 = new Scene(box3,500,400);
        stage.setScene(scene3);
        stage.show();

        Button btn1 = new Button();
        btn1.setText("Visualizar Integrantes");
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
                addIntegrante.showAndWait();
            }
        });


        Scene scene = new Scene(box1,500,400);
        stage.setScene(scene);

        Button fecharAddIntegrantes = new Button("Fechar");
        fecharAddIntegrantes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                addIntegrante.close();
            }
        });

        Button voltarHome2 = new Button("Voltar para tela");
        voltarHome2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(scene);
            }
        });
        box2.getChildren().add(fecharAddIntegrantes);

        TableView table = new TableView();
        table.setEditable(true);

        TableColumn emailCol = new TableColumn("Email");
        TableColumn nomeCol = new TableColumn("Nome");
        TableColumn senhaCol = new TableColumn("Senha");
        TableColumn telefoneCol = new TableColumn("Telefone");
        TableColumn cpfCol = new TableColumn("CPF");

       emailCol.setCellValueFactory(
                new PropertyValueFactory<Integrante, String>("email")
        );
        nomeCol.setCellValueFactory(
                new PropertyValueFactory<Integrante, String>("nome")
        );
        senhaCol.setCellValueFactory(
                new PropertyValueFactory<Integrante, String>("senha")
        );
        telefoneCol.setCellValueFactory(
                new PropertyValueFactory<Integrante, String>("litragem")
        );
        cpfCol.setCellValueFactory(
                new PropertyValueFactory<Integrante, String>("observacao")
        );


        table.setItems(integrantes)    ;
        table.getColumns().addAll(emailCol, nomeCol, senhaCol, telefoneCol, cpfCol);

        Label lbl5 = new Label("Veículos Registrados");
        lbl5.setAlignment(Pos.TOP_CENTER);
        lbl5.setFont(new Font("Arial", 20));

        box3.getChildren().addAll(lbl5, table);
        box3.getChildren().add(voltarHome2);
        box3.getChildren().add(addIntegrante);


    }

    public static void main(String [] args){
        launch();
    }
}
