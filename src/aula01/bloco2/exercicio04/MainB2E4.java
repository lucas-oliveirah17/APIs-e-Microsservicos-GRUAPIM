package aula01.bloco2.exercicio04;

/* Exceção Personalizada SaldoInsuficienteException: Reutilizando a ideia da 
 * ContaBancaria da aula, crie sua própria exceção checada SaldoInsuficienteException. 
 * Modifique o método sacar para que, em vez de retornar false, ele lance essa exceção 
 * quando o saldo for insuficiente. Crie uma classe de teste para tratar essa exceção 
 * com um bloco try-catch.
 * */

public class MainB2E4 {
	public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("João Silva", 1000.00);

        System.out.println("Titular: " + conta.getTitular());
        System.out.printf("Saldo inicial: R$ %.2f%n%n", conta.getSaldo());

        // Operação bem-sucedida
        try {
            conta.depositar(500.00);
            conta.sacar(300.00);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println();

        // Operação que lança a exceção
        try {
            conta.sacar(5000.00);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Operação bloqueada!");
            System.out.println(e.getMessage());
        }
    }
}
