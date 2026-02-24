package aula01.bloco1;

/* Soma de Ímpares em um Array: Crie um array de inteiros com números 
 * pré-definidos. Utilize um laço for-each para percorrer o array e somar 
 * todos os números que forem ímpares. Exiba o resultado final.
 * */

public class Exercicio04 {
	public static void main(String[] args) {
        int[] numeros = {3, 8, 15, 42, 7, 10, 21, 6, 13, 4};

        int soma = 0;

        for (int num : numeros) {
            if (num % 2 != 0) {
                soma += num;
            }
        }

        System.out.println("Array: {3, 8, 15, 42, 7, 10, 21, 6, 13, 4}");
        System.out.println("Soma dos números ímpares: " + soma);
    }
}
