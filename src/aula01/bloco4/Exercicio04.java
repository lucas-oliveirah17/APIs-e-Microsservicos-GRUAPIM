package aula01.bloco4;

import java.util.TreeSet;

/* Nomes em Ordem Alfabética (TreeSet): Crie um TreeSet de Strings e adicione 5 nomes de pessoas fora da ordem 
 * alfabética. Itere sobre o Set e observe que os nomes são impressos em ordem alfabética natural.
 * */

public class Exercicio04 {
	public static void main(String[] args) {
        TreeSet<String> nomes = new TreeSet<>();

        // Adicionando fora de ordem alfabética
        nomes.add("Rodrigo");
        nomes.add("Ana");
        nomes.add("Marcos");
        nomes.add("Fernanda");
        nomes.add("Bruno");

        System.out.println("Nomes em ordem alfabética natural:");
        int i = 1;
        for (String nome : nomes) {
            System.out.println(i++ + ". " + nome);
        }

        System.out.println("\nO TreeSet ordena os elementos automaticamente.");
    }
}
