package aula01.bloco1;

import java.util.Scanner;

/* Tabuada com for: Peça ao usuário um número inteiro. Use um laço for 
 * tradicional para calcular e exibir a tabuada de multiplicação desse número, 
 * do 1 ao 10. (Ex: “5 x 1 = 5”, “5 x 2 = 10”, …).
 * */

public class Exercicio02 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();

        System.out.println("\nTabuada de " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }

        scanner.close();
    }
}
