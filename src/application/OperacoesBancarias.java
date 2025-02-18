package application;

public class OperacoesBancarias {
    private double saldo;

    public OperacoesBancarias(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de " + valor + " realizado. Novo saldo: " + saldo);
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de " + valor + " realizado. Novo saldo: " + saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }
}