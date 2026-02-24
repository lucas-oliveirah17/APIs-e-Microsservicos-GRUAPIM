package aula01.bloco2.exercicio04;

public class SaldoInsuficienteException extends Exception {
    private static final long serialVersionUID = 1L;
	private double saldoAtual;
    private double valorSolicitado;

    public SaldoInsuficienteException(double saldoAtual, double valorSolicitado) {
        super(String.format(
            "Saldo insuficiente! Saldo disponível: R$ %.2f | Valor solicitado: R$ %.2f",
            saldoAtual, valorSolicitado
        ));
        this.saldoAtual = saldoAtual;
        this.valorSolicitado = valorSolicitado;
    }

    public double getSaldoAtual() { return saldoAtual; }
    public double getValorSolicitado() { return valorSolicitado; }
}
