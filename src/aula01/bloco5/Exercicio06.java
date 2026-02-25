package aula01.bloco5;

import java.util.HashMap;
import java.util.Scanner;

/* Verificando a Existência de Chave e Valor: Usando o HashMap do exercício da agenda, escreva um código que 
 * verifique se um determinado nome (containsKey) e se um determinado telefone (containsValue) já existem na 
 * agenda.
 * */

public class Exercicio06 {
	public static void main(String[] args) {
        HashMap<String, String> agenda = new HashMap<>();

        // Agenda pré-populada
        agenda.put("Ana",     "(11) 91234-5678");
        agenda.put("Bruno",   "(21) 99876-5432");
        agenda.put("Carla",   "(31) 98765-4321");
        agenda.put("Diego",   "(41) 97654-3210");
        agenda.put("Elisa",   "(51) 96543-2109");

        System.out.println("=== Agenda ===");
        agenda.forEach((nome, tel) -> System.out.printf("%-10s : %s%n", nome, tel));

        Scanner scanner = new Scanner(System.in);

        // Verificação por nome (containsKey)
        System.out.print("\nDigite um nome para verificar se está na agenda: ");
        String nomeBusca = scanner.nextLine();

        if (agenda.containsKey(nomeBusca)) {
            System.out.println("✔ Nome \"" + nomeBusca + "\" encontrado na agenda. Telefone: " + agenda.get(nomeBusca));
        } else {
            System.out.println("✘ Nome \"" + nomeBusca + "\" NÃO está na agenda.");
        }

        // Verificação por telefone (containsValue)
        System.out.print("\nDigite um telefone para verificar se está cadastrado: ");
        String telBusca = scanner.nextLine();

        if (agenda.containsValue(telBusca)) {
            System.out.println("✔ Telefone \"" + telBusca + "\" encontrado na agenda.");
        } else {
            System.out.println("✘ Telefone \"" + telBusca + "\" NÃO está cadastrado na agenda.");
        }

        scanner.close();
    }
}
