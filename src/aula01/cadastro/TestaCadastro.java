package aula01.cadastro;

/* Exercício - Uso de classe abstratas
 * 
 * Implemente a aplicação correspondente ao diagrama de classes mostrado abaixo. 
 *
 * O método "imprimeDados" deve exibir as informações da classe com a qual estamos lidando. Elabore, junto com 
 * a implementação, um pequeno texto (dois a quatro parágrafos) propondo melhorias no sistema de cadastro e/ou 
 * em seu diagrama de classes.
 *
 * */

public class TestaCadastro {
    public static void main(String[] args) {
        CadastroPessoas cadastro = new CadastroPessoas(10);

        Data dataCliente = new Data(15, 8, 1990);
        Data dataFunc = new Data(22, 5, 1985);
        Data dataGerente = new Data(10, 11, 1980);

        Cliente cliente = new Cliente("Lucas Silva", dataCliente, 1001);
        Funcionario funcionario = new Funcionario("Luiz Fernando", dataFunc, 3500.00f);
        Gerente gerente = new Gerente("Giovani Disperati", dataGerente, 8000.00f, "TI");

        System.out.println("Realizando cadastros...");
        cadastro.cadastraPessoa(cliente);
        cadastro.cadastraPessoa(funcionario);
        cadastro.cadastraPessoa(gerente);

        cadastro.imprimeCadastro();
    }
}