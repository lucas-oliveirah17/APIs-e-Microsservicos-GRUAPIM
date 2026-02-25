package aula01.bloco7.exercicio01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/* Catálogo de Produtos por Categoria: Crie uma estrutura de dados para um catálogo de produtos. Use um Map<String, 
 * List<Produto>>, onde a chave é o nome da categoria (ex: “Eletrônicos”) e o valor é uma lista de objetos da 
 * classe Produto pertencentes àquela categoria. Popule a estrutura com alguns dados e depois escreva um código 
 * para listar todos os produtos de uma categoria específica.
 * */

public class MainB7E1 {
	public static void main(String[] args) {
        Map<String, List<Produto>> catalogo = new HashMap<>();

        // Populando o catálogo
        List<Produto> eletronicos = new ArrayList<>();
        eletronicos.add(new Produto("Notebook Dell",    4500.00));
        eletronicos.add(new Produto("Smartphone Samsung", 2800.00));
        eletronicos.add(new Produto("Tablet iPad",      3200.00));

        List<Produto> livros = new ArrayList<>();
        livros.add(new Produto("Clean Code",      120.00));
        livros.add(new Produto("Effective Java",   95.00));
        livros.add(new Produto("Design Patterns", 110.00));

        List<Produto> esportes = new ArrayList<>();
        esportes.add(new Produto("Tênis Nike",    350.00));
        esportes.add(new Produto("Bicicleta Speed", 1800.00));
        esportes.add(new Produto("Raquete de Tênis", 280.00));

        catalogo.put("Eletrônicos", eletronicos);
        catalogo.put("Livros",      livros);
        catalogo.put("Esportes",    esportes);

        // Listando categorias disponíveis
        System.out.println("=== Catálogo de Produtos ===");
        System.out.println("Categorias disponíveis: " + catalogo.keySet());

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite o nome de uma categoria: ");
        String categoria = scanner.nextLine();

        if (catalogo.containsKey(categoria)) {
            List<Produto> produtos = catalogo.get(categoria);
            System.out.println("\n--- Produtos em \"" + categoria + "\" ---");
            for (Produto p : produtos) {
                System.out.println("  • " + p);
            }
        } else {
            System.out.println("Categoria \"" + categoria + "\" não encontrada.");
        }

        scanner.close();
    }
}
