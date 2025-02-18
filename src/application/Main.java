package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private double saldo = 0.0; // Variável para armazenar o saldo

    @Override
    public void start(Stage primaryStage) {
        // Configuração do layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Campos de entrada
        Label lblTitular = new Label("Titular:");
        grid.add(lblTitular, 0, 0);

        TextField txtTitular = new TextField();
        grid.add(txtTitular, 1, 0);

        Label lblSaldo = new Label("Saldo:");
        grid.add(lblSaldo, 0, 1);

        TextField txtSaldo = new TextField();
        txtSaldo.setEditable(false); // O saldo não pode ser editado diretamente
        grid.add(txtSaldo, 1, 1);

        Label lblConta = new Label("Conta:");
        grid.add(lblConta, 0, 2);

        TextField txtConta = new TextField();
        grid.add(txtConta, 1, 2);

        Label lblAgencia = new Label("Agência:");
        grid.add(lblAgencia, 0, 3);

        TextField txtAgencia = new TextField();
        grid.add(txtAgencia, 1, 3);

        // Campo para valor de saque/depósito
        Label lblValor = new Label("Valor:");
        grid.add(lblValor, 0, 4);

        TextField txtValor = new TextField();
        grid.add(txtValor, 1, 4);

        // Botão de saque
        Button btnSaque = new Button("Sacar");
        grid.add(btnSaque, 0, 5);

        // Botão de depósito
        Button btnDeposito = new Button("Depositar");
        grid.add(btnDeposito, 1, 5);

        // Botão de salvar
        Button btnSalvar = new Button("Salvar");
        grid.add(btnSalvar, 1, 6);

        // Ação do botão salvar
        btnSalvar.setOnAction(e -> {
            String titular = txtTitular.getText();
            int conta = Integer.parseInt(txtConta.getText());
            int agencia = Integer.parseInt(txtAgencia.getText());

            // Aqui você pode adicionar a lógica para salvar os dados
            System.out.println("Titular: " + titular);
            System.out.println("Saldo: " + saldo);
            System.out.println("Conta: " + conta);
            System.out.println("Agência: " + agencia);
        });

        // Ação do botão de saque
        btnSaque.setOnAction(e -> {
            try {
                double valor = Double.parseDouble(txtValor.getText());
                if (valor > 0 && valor <= saldo) {
                    saldo -= valor; // Subtrai o valor do saldo
                    txtSaldo.setText(String.format("%.2f", saldo)); // Atualiza o campo de saldo
                    System.out.println("Saque de " + valor + " realizado. Novo saldo: " + saldo);
                } else {
                    System.out.println("Valor de saque inválido ou saldo insuficiente.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Valor inválido para saque.");
            }
        });

        // Ação do botão de depósito
        btnDeposito.setOnAction(e -> {
            try {
                double valor = Double.parseDouble(txtValor.getText());
                if (valor > 0) {
                    saldo += valor; // Adiciona o valor ao saldo
                    txtSaldo.setText(String.format("%.2f", saldo)); // Atualiza o campo de saldo
                    System.out.println("Depósito de " + valor + " realizado. Novo saldo: " + saldo);
                } else {
                    System.out.println("Valor de depósito inválido.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Valor inválido para depósito.");
            }
        });

        // Configuração da cena
        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setTitle("Conta Bancária");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}