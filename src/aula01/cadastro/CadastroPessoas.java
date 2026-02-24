package aula01.cadastro;

public class CadastroPessoas {
    public int qtdAtual;
    public Pessoa[] pessoas;

    public CadastroPessoas(int tamanhoMaximo) {
        this.pessoas = new Pessoa[tamanhoMaximo];
        this.qtdAtual = 0;
    }

    public void cadastraPessoa(Pessoa pess) {
        if (qtdAtual < pessoas.length) {
            pessoas[qtdAtual] = pess;
            qtdAtual++;
            System.out.println(pess.nome + " cadastrado(a) com sucesso!");
        } else {
            System.out.println("Erro: Cadastro lotado. Não é possível adicionar mais pessoas.");
        }
    }

    public void imprimeCadastro() {
        System.out.println("\n===== LISTA DE CADASTRADOS =====");
        for (int i = 0; i < qtdAtual; i++) {
            pessoas[i].imprimeDados();
            System.out.println("--------------------------------");
        }
    }
}