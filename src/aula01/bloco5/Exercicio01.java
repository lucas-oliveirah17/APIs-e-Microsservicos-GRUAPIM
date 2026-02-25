package aula01.bloco5;

import java.util.HashMap;
import java.util.Scanner;

/* Dicionário Simples (HashMap): Crie um HashMap para funcionar como um dicionário de tradução simples 
 * (Português -> Inglês). Adicione 5 palavras e suas traduções. Peça ao usuário uma palavra em português e, 
 * se ela existir no mapa, exiba sua tradução.
 * */

public class Exercicio01 {
	public static void main(String[] args) {
        HashMap<String, String> dicionario = new HashMap<>();

        dicionario.put("gato",    "cat");
        dicionario.put("cachorro","dog");
        dicionario.put("casa",    "house");
        dicionario.put("carro",   "car");
        dicionario.put("livro",   "book");

        System.out.println("=== Dicionário Português -> Inglês ===");
        System.out.println("Palavras disponíveis: " + dicionario.keySet());

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite uma palavra em português: ");
        String palavra = scanner.nextLine().toLowerCase();

        if (dicionario.containsKey(palavra)) {
            System.out.println("Tradução: " + dicionario.get(palavra));
        } else {
            System.out.println("Palavra \"" + palavra + "\" não encontrada no dicionário.");
        }

        scanner.close();
    }
}
