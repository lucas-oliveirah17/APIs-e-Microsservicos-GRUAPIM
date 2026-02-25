package aula01.bloco4.exercicio05;

import java.util.TreeSet;

/* Objetos Personalizados em um TreeSet: Crie uma classe Produto com nome (String) e preco (double). Faça 
 * com que a classe Produto implemente a interface Comparable para que os produtos sejam ordenados pelo 
 * preço (do menor para o maior). Crie um TreeSet<Produto> e adicione alguns produtos para testar a ordenação.
 * */

public class MainB4E5 {
	public static void main(String[] args) {
        TreeSet<Produto> produtos = new TreeSet<>();

        produtos.add(new Produto("Notebook",        3500.00));
        produtos.add(new Produto("Mouse",             89.90));
        produtos.add(new Produto("Teclado",          199.99));
        produtos.add(new Produto("Monitor",         1250.00));
        produtos.add(new Produto("Headset",          349.90));
        produtos.add(new Produto("Webcam",           259.00));

        System.out.println("Produtos ordenados do menor para o maior preço:");
        System.out.println("--------------------------------------------");
        int i = 1;
        for (Produto p : produtos) {
            System.out.println(i++ + ". " + p);
        }
    }
}
