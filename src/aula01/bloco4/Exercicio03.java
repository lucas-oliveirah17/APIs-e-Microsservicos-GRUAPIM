package aula01.bloco4;

import java.util.LinkedHashSet;

/* Ordem de Inserção (LinkedHashSet): Crie um LinkedHashSet e adicione os nomes dos dias da semana fora de 
 * ordem (ex: “Quarta”, “Segunda”, “Sexta”). Itere sobre o Set e imprima os elementos para verificar que 
 * eles são exibidos na ordem exata em que foram inseridos.
 * */

public class Exercicio03 {
	public static void main(String[] args) {
        LinkedHashSet<String> diasDaSemana = new LinkedHashSet<>();

        // Adicionando fora de ordem
        diasDaSemana.add("Quarta-feira");
        diasDaSemana.add("Segunda-feira");
        diasDaSemana.add("Sexta-feira");
        diasDaSemana.add("Domingo");
        diasDaSemana.add("Terça-feira");
        diasDaSemana.add("Sábado");
        diasDaSemana.add("Quinta-feira");

        System.out.println("Dias na ordem em que foram inseridos:");
        int i = 1;
        for (String dia : diasDaSemana) {
            System.out.println(i++ + ". " + dia);
        }

        System.out.println("\nO LinkedHashSet preserva a ordem de inserção.");
    }
}
