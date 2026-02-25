package aula01.bloco5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Agenda de Contatos: Use um HashMap para criar uma agenda onde a chave é o nome do contato (String) e o 
 * valor é o número de telefone (String). Permita ao usuário: adicionar um novo contato, buscar um telefone 
 * pelo nome e listar todos os contatos (nome e telefone).
 * */

public class Exercicio03 {
	public static void main(String[] args) {
        HashMap<String, String> agenda = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== Agenda de Contatos ===");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Buscar telefone pelo nome");
            System.out.println("3 - Listar todos os contatos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    agenda.put(nome, telefone);
                    System.out.println("Contato \"" + nome + "\" adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome para buscar: ");
                    String busca = scanner.nextLine();
                    if (agenda.containsKey(busca)) {
                        System.out.println("Telefone de " + busca + ": " + agenda.get(busca));
                    } else {
                        System.out.println("Contato \"" + busca + "\" não encontrado.");
                    }
                    break;

                case 3:
                    if (agenda.isEmpty()) {
                        System.out.println("Agenda vazia.");
                    } else {
                        System.out.println("\n--- Contatos ---");
                        for (Map.Entry<String, String> contato : agenda.entrySet()) {
                            System.out.printf("%-20s : %s%n", contato.getKey(), contato.getValue());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando agenda...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
