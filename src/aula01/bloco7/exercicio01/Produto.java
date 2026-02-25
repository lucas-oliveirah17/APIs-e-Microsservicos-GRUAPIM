package aula01.bloco7.exercicio01;

public class Produto {
	private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("%-22s R$ %.2f", nome, preco);
    }
}
