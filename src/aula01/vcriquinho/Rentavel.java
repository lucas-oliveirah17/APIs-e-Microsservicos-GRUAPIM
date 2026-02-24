package aula01.vcriquinho;

/**
 * Interface que define o contrato de rendimento para contas e produtos.
 * Usa polimorfismo para calcular rendimentos de formas diferentes.
 */
public interface Rentavel {
    /**
     * Calcula o rendimento bruto para um período dado em dias.
     * @param dias período de simulação
     * @return rendimento bruto gerado
     */
    double calcularRendimento(int dias);
}