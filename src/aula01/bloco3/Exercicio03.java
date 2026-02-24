package aula01.bloco3;

import java.util.LinkedList;

/* Manipulando o Início e o Fim (LinkedList): Crie uma LinkedList para simular uma fila de atendimento. 
 * Adicione 5 nomes de clientes no final da fila. Em seguida, “atenda” os 2 primeiros clientes 
 * (removendo-os do início da lista). Por fim, adicione 2 novos clientes “prioritários” no início da 
 * fila. Exiba a ordem final da fila.
 * */

public class Exercicio03 {
	public static void main(String[] args) {
        LinkedList<String> fila = new LinkedList<>();

        // Adiciona 5 clientes no final da fila
        fila.addLast("Carlos");
        fila.addLast("Ana");
        fila.addLast("Beatriz");
        fila.addLast("Diego");
        fila.addLast("Elisa");

        System.out.println("Fila inicial: " + fila);

        // Atende os 2 primeiros clientes (remove do início)
        String atendido1 = fila.removeFirst();
        String atendido2 = fila.removeFirst();
        System.out.println("\nAtendendo: " + atendido1);
        System.out.println("Atendendo: " + atendido2);
        System.out.println("Fila após atendimentos: " + fila);

        // Adiciona 2 clientes prioritários no início
        fila.addFirst("Zilda (Prioritário)");
        fila.addFirst("Roberto (Prioritário)");
        System.out.println("\nNovos clientes prioritários adicionados.");
        System.out.println("Fila final: " + fila);
    }
}
