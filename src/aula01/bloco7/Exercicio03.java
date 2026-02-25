package aula01.bloco7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/* Invertendo uma Frase: Peça ao usuário uma frase. Use um Deque (como uma pilha) para armazenar cada palavra 
 * da frase. Em seguida, desempilhe as palavras uma a uma para formar e exibir a frase na ordem inversa.
 * */

public class Exercicio03 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();

        String[] palavras = frase.trim().split("\\s+");

        // Empilha cada palavra na pilha
        Deque<String> pilha = new ArrayDeque<>();
        for (String palavra : palavras) {
            pilha.push(palavra);
        }

        // Desempilha para montar a frase invertida
        StringBuilder fraseInvertida = new StringBuilder();
        while (!pilha.isEmpty()) {
            fraseInvertida.append(pilha.pop());
            if (!pilha.isEmpty()) {
                fraseInvertida.append(" ");
            }
        }

        System.out.println("\nFrase original : " + frase);
        System.out.println("Frase invertida: " + fraseInvertida);

        scanner.close();
    }
}
