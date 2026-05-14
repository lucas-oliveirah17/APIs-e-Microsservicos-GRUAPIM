package bloco01.atividade04;

import java.util.Arrays;

/*
 * 4. Soma de Ímpares em um Array: Crie um array de inteiros com números pré-definidos. Utilize um 
 * laço for-each para percorrer o array e somar todos os números que forem ímpares. Exiba o resultado 
 * final.
 */
public class SomaImpares {
		
	public static void main (String[] args) {
		
		int sum = 0;
		
		int[] numbers = {12, 35, 42, 57, 88, 91, 104, 113};
		
		for (Integer number : numbers) {
			if (number % 2 != 0) {
				sum += number;
			}
		}
		
		System.out.println("Array: " + Arrays.toString(numbers));
		System.out.printf("Resultado: %d%n", sum);
	}
	
}
