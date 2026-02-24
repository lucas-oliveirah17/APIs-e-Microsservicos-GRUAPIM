package aula01.cadastro;

public abstract class Pessoa {
    public String nome;
    public Data nascimento;

    public Pessoa(String nome, Data nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public abstract void imprimeDados();
}