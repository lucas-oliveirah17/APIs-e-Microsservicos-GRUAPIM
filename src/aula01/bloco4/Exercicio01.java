package aula01.bloco4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/* Removendo Duplicatas: Crie um ArrayList de Integer que contenha números duplicados. Escreva um código
 *  que receba esta lista e retorne uma nova coleção sem os elementos duplicados. (Dica: a forma mais
 *   fácil é usar um HashSet).
 * */

public class Exercicio01 {
	public static void main(String[] args) {
        ArrayList<Integer> listaComDuplicatas = new ArrayList<>(
            Arrays.asList(5, 3, 8, 3, 1, 9, 5, 2, 8, 7, 1, 4, 7)
        );

        System.out.println("Lista original  : " + listaComDuplicatas);
        System.out.println("Tamanho original: " + listaComDuplicatas.size());

        // HashSet remove as duplicatas automaticamente
        HashSet<Integer> semDuplicatas = new HashSet<>(listaComDuplicatas);

        System.out.println("\nColeção sem duplicatas: " + semDuplicatas);
        System.out.println("Tamanho sem duplicatas: " + semDuplicatas.size());
    }
}
