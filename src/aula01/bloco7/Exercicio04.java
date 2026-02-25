package aula01.bloco7;

import java.util.LinkedList;


/* Histórico de Navegação: Use uma LinkedList para simular o histórico de um navegador. Crie métodos 
 * visitar(String url), voltar() e avancar(). O método voltar deve navegar para a URL anterior no histórico, 
 * e o avancar para a próxima, gerenciando um “ponteiro” ou índice da página atual.
 * */

public class Exercicio04 {

    private LinkedList<String> historico;
    private int indiceAtual;

    public Exercicio04() {
        this.historico = new LinkedList<>();
        // 	Indice negativo para indicar que o navegador está vazio
        this.indiceAtual = -1; 
    }

    public void visitar(String url) {
        if (indiceAtual < historico.size() - 1) {
            historico.subList(indiceAtual + 1, historico.size()).clear();
        }
        
        historico.add(url);
        indiceAtual++;
        System.out.println("Visitando: " + url);
    }

    public void voltar() {
        if (indiceAtual > 0) {
            indiceAtual--;
            System.out.println("Voltando para: " + historico.get(indiceAtual));
        } else {
            System.out.println("Aviso: Não há histórico anterior.");
        }
    }

    public void avancar() {
        if (indiceAtual < historico.size() - 1) {
            indiceAtual++;
            System.out.println("Avançando para: " + historico.get(indiceAtual));
        } else {
            System.out.println("Aviso: Não há histórico para avançar.");
        }
    }

    public void exibirPaginaAtual() {
        if (indiceAtual >= 0) {
            System.out.println(">> Página atual: " + historico.get(indiceAtual) + " <<");
        } else {
            System.out.println("Navegador vazio.");
        }
    }

    public static void main(String[] args) {
        Exercicio04 navegador = new Exercicio04();

        System.out.println("Iniciando navegação...\n");
        navegador.visitar("google.com");
        navegador.visitar("github.com/lucas");
        navegador.visitar("stackoverflow.com");

        System.out.println("\nTestando o botão Voltar:");
        navegador.voltar();
        navegador.voltar();
        navegador.voltar();

        System.out.println("\nTestando o botão Avançar:");
        navegador.avancar();

        System.out.println("\nVisitando novo site após ter voltado:");
        navegador.visitar("youtube.com");

        System.out.println("\nTentando avançar (não deve ser possível):");
        navegador.avancar(); 

        System.out.println("\nVerificando o histórico final:");
        navegador.voltar();
        navegador.exibirPaginaAtual();
    }
}
