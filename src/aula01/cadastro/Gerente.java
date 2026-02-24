package aula01.cadastro;

public class Gerente extends Funcionario {
    public String area;

    public Gerente(String nome, Data nascimento, float salario, String area) {
        super(nome, nascimento, salario);
        this.area = area;
    }

    @Override
    public float calculaImposto() {
        return this.salario * 0.05f;
    }

    @Override
    public void imprimeDados() {
        System.out.println("--- Dados do Gerente ---");
        System.out.println("Nome: " + this.nome);
        System.out.println("Nascimento: " + this.nascimento.toString());
        System.out.println("Área: " + this.area);
        System.out.println("Salário: R$ " + this.salario);
        System.out.println("Imposto (5%): R$ " + this.calculaImposto());
    }
}