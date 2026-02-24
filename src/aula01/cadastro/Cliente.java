package aula01.cadastro;

public class Cliente extends Pessoa {
    public int codigo;

    public Cliente(String nome, Data nascimento, int codigo) {
        super(nome, nascimento);
        this.codigo = codigo;
    }

    @Override
    public void imprimeDados() {
        System.out.println("--- Dados do Cliente ---");
        System.out.println("Nome: " + this.nome);
        System.out.println("Nascimento: " + this.nascimento.toString());
        System.out.println("Código: " + this.codigo);
    }
}