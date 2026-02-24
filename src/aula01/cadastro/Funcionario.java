package aula01.cadastro;

public class Funcionario extends Pessoa {
    public float salario;

    public Funcionario(String nome, Data nascimento, float salario) {
        super(nome, nascimento);
        this.salario = salario;
    }

    public float calculaImposto() {
        return this.salario * 0.03f;
    }

    @Override
    public void imprimeDados() {
        System.out.println("--- Dados do Funcionário ---");
        System.out.println("Nome: " + this.nome);
        System.out.println("Nascimento: " + this.nascimento.toString());
        System.out.println("Salário: R$ " + this.salario);
        System.out.println("Imposto (3%): R$ " + this.calculaImposto());
    }
}