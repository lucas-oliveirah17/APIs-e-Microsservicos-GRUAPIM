package aula01.bloco3;

import java.util.ArrayList;
import java.util.Scanner;

/* Busca por Elemento: Crie um ArrayList de Strings com nomes de cidades. Peça ao usuário para digitar 
 * o nome de uma cidade. Verifique se a cidade está presente na lista usando o método contains(). Se 
 * estiver, informe o índice da sua primeira ocorrência usando o método indexOf().
 * */

public class Exercicio04 {
	public static void main(String[] args) {
        ArrayList<String> cidades = new ArrayList<>();

        cidades.add("São Paulo");
        cidades.add("Rio de Janeiro");
        cidades.add("Belo Horizonte");
        cidades.add("Salvador");
        cidades.add("Fortaleza");
        cidades.add("Curitiba");
        cidades.add("Manaus");
        cidades.add("Recife");
        cidades.add("Porto Alegre");
        cidades.add("Goiânia");

        System.out.println("Cidades disponíveis: " + cidades);
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome de uma cidade para buscar: ");
        String busca = scanner.nextLine();

        if (cidades.contains(busca)) {
            int idx = cidades.indexOf(busca);
            System.out.println("Cidade \"" + busca + "\" encontrada no índice " + idx + ".");
        } else {
            System.out.println("Cidade \"" + busca + "\" não encontrada na lista.");
        }

        scanner.close();
    }
}
