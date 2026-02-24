package aula01.bloco3;

import java.util.ArrayList;
import java.util.Collections;

/* Ordenando Números: Crie um ArrayList de Integer. Adicione 10 números inteiros aleatórios 
 * ou definidos por você. Utilize a classe Collections e seu método sort() para ordenar a 
 * lista em ordem crescente e, em seguida, exiba o resultado.
 * */

public class Exercicio02 {
	public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(42);
        numeros.add(7);
        numeros.add(99);
        numeros.add(3);
        numeros.add(55);
        numeros.add(18);
        numeros.add(76);
        numeros.add(31);
        numeros.add(64);
        numeros.add(11);

        System.out.println("Lista original : " + numeros);

        Collections.sort(numeros);

        System.out.println("Lista ordenada : " + numeros);
    }
}
