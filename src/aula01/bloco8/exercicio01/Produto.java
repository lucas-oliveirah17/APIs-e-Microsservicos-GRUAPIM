package aula01.bloco8.exercicio01;

public class Produto {
	@SuppressWarnings("unused")
	private int codigo;
    public String nome;
    protected double preco;

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    @SuppressWarnings("unused")
    private double calcularImposto() {
        return preco * 0.1;
    }
}
