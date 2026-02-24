package aula01.bloco2.exercicio04;

public class ContaBancaria {
	private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado. Saldo atual: R$ %.2f%n", valor, saldo);
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException(saldo, valor);
        }
        saldo -= valor;
        System.out.printf("Saque de R$ %.2f realizado. Saldo atual: R$ %.2f%n", valor, saldo);
    }

    public double getSaldo() { return saldo; }
    public String getTitular() { return titular; }
}
