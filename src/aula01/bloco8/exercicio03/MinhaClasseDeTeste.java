package aula01.bloco8.exercicio03;

public class MinhaClasseDeTeste {
	@Teste
    public void testeSoma() {
        System.out.println("Executando testeSoma: SUCESSO");
	}

    public void metodoComum() {
        System.out.println("Este não é um teste.");
    }

    @Teste
    public void testeLogin() {
        System.out.println("Executando testeLogin: SUCESSO");
    }
}
