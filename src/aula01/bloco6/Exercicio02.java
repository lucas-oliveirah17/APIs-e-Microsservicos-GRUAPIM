package aula01.bloco6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/* Pilha de Livros (Deque como Stack): Use um ArrayDeque para simular uma pilha de livros. Permita ao usuário 
 * “empilhar” 3 livros (push). Depois, “desempilhe” um livro (pop) e veja qual foi removido (o último que entrou). 
 * Por fim, use peek para “espiar” o livro que está no topo da pilha sem removê-lo.
 * */
		 
public class Exercicio02 {
	public static void main(String[] args) {
        Deque<String> pilha = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        // Empilha 3 livros
        System.out.println("=== Pilha de Livros ===");
        System.out.println("Empilhando 3 livros...\n");

        for (int i = 1; i <= 3; i++) {
            System.out.print("Digite o nome do livro " + i + ": ");
            String livro = scanner.nextLine();
            pilha.push(livro);
            System.out.println("\"" + livro + "\" empilhado. Topo atual: " + pilha.peek());
            System.out.println("Pilha: " + pilha + "\n");
        }

        // Desempilha 1 livro
        System.out.println("--- Desempilhando um livro ---");
        String removido = pilha.pop();
        System.out.println("Livro removido (último que entrou): \"" + removido + "\"");
        System.out.println("Pilha após remoção: " + pilha);

        // Espia o topo sem remover
        System.out.println("\n--- Espiando o topo da pilha ---");
        String topo = pilha.peek();
        System.out.println("Livro no topo (sem remover): \"" + topo + "\"");
        System.out.println("Pilha continua intacta: " + pilha);

        scanner.close();
    }
}
