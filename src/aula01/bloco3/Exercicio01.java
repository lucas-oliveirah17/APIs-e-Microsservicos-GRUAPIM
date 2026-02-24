package aula01.bloco3;

import java.util.ArrayList;
import java.util.Scanner;

/* Lista de Tarefas (ArrayList): Crie um programa que gerencia uma lista de tarefas (Strings). 
 * Permita ao usuário: adicionar uma tarefa, remover uma tarefa pelo seu índice e listar todas 
 * as tarefas. Use um ArrayList.
 * */

public class Exercicio01 {
	public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== Gerenciador de Tarefas ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Remover tarefa pelo índice");
            System.out.println("3 - Listar tarefas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a tarefa: ");
                    String tarefa = scanner.nextLine();
                    tarefas.add(tarefa);
                    System.out.println("Tarefa adicionada com sucesso!");
                    break;

                case 2:
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                        break;
                    }
                    System.out.print("Digite o índice da tarefa a remover (0 a " + (tarefas.size() - 1) + "): ");
                    int indice = scanner.nextInt();
                    if (indice >= 0 && indice < tarefas.size()) {
                        System.out.println("Tarefa \"" + tarefas.get(indice) + "\" removida.");
                        tarefas.remove(indice);
                    } else {
                        System.out.println("Índice inválido!");
                    }
                    break;

                case 3:
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        System.out.println("\n--- Lista de Tarefas ---");
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println("[" + i + "] " + tarefas.get(i));
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
