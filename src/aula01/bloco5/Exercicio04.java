package aula01.bloco5;

import java.util.LinkedHashMap;
import java.util.Map;

/* Mantendo a Ordem de Cadastro (LinkedHashMap): Crie um LinkedHashMap para armazenar produtos e seus 
 * respectivos códigos (ex: Integer como chave, String como valor). Adicione 5 produtos. Itere sobre o 
 * mapa e mostre que a ordem de exibição é a mesma da ordem de inserção.
 * */

public class Exercicio04 {
	public static void main(String[] args) {
        LinkedHashMap<Integer, String> produtos = new LinkedHashMap<>();

        produtos.put(1042, "Notebook");
        produtos.put(3015, "Mouse sem fio");
        produtos.put(2278, "Teclado mecânico");
        produtos.put(5001, "Monitor 24\"");
        produtos.put(1899, "Headset Gamer");

        System.out.println("=== Produtos cadastrados (ordem de inserção) ===");
        System.out.printf("%-10s | %s%n", "Código", "Produto");
        System.out.println("-----------|--------------------");

        for (Map.Entry<Integer, String> entrada : produtos.entrySet()) {
            System.out.printf("%-10d | %s%n", entrada.getKey(), entrada.getValue());
        }

        System.out.println("\nO LinkedHashMap garante a ordem de inserção.");
    }
}
