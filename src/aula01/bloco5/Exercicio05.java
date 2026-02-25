package aula01.bloco5;

import java.util.Map;
import java.util.TreeMap;

/* Listagem Ordenada (TreeMap): Crie um TreeMap para armazenar as notas de alunos em uma prova, onde a chave é 
 * o nome do aluno (String) e o valor é a nota (Double). Adicione 5 alunos fora de ordem alfabética. Ao listar 
 * os alunos e suas notas, observe que o TreeMap os exibe em ordem alfabética pelo nome.
 * */

public class Exercicio05 {
	public static void main(String[] args) {
        TreeMap<String, Double> notas = new TreeMap<>();

        // Inseridos fora de ordem alfabética
        notas.put("Rodrigo",  7.5);
        notas.put("Ana",      9.0);
        notas.put("Marcos",   6.0);
        notas.put("Beatriz",  8.5);
        notas.put("Carlos",   5.5);

        System.out.println("=== Notas dos Alunos (ordem alfabética) ===");
        System.out.printf("%-15s | %s%n", "Aluno", "Nota");
        System.out.println("----------------|------");

        for (Map.Entry<String, Double> entrada : notas.entrySet()) {
            System.out.printf("%-15s | %.1f%n", entrada.getKey(), entrada.getValue());
        }

        System.out.println("\nO TreeMap ordena automaticamente as chaves em ordem alfabética.");
    }
}
