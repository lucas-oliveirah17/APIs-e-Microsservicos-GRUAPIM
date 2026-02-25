package aula01.bloco4.exercicio05;

public class Produto implements Comparable<Produto> {
	private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome()  { return nome; }
    public double getPreco() { return preco; }

    @Override
    public int compareTo(Produto outro) {
        // Ordena do menor para o maior preço
        int resultado = Double.compare(this.preco, outro.preco);
        // Desempate pelo nome para evitar que produtos com mesmo preço
        // sejam tratados como duplicatas pelo TreeSet
        if (resultado == 0) {
            resultado = this.nome.compareTo(outro.nome);
        }
        return resultado;
    }

    @Override
    public String toString() {
        return String.format("%-20s R$ %.2f", nome, preco);
    }
}
