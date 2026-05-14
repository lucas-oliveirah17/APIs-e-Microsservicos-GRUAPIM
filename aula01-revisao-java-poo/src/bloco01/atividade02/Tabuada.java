package bloco01.atividade02;

import java.util.Scanner;

/*
 * 2. Tabuada com for: Peça ao usuário um número inteiro. Use um laço for tradicional para calcular e 
 * exibir a tabuada de multiplicação desse número, do 1 ao 10. (Ex: “5 x 1 = 5”, “5 x 2 = 10”, …).
 */
public class Tabuada {
	static final int MIN_VALUE = 1;
	static final int MAX_VALUE = 10;

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int number;
		
		System.out.print("Digite um número inteiro: ");
		number = scanner.nextInt();
		
		for (int index = MIN_VALUE; index <= MAX_VALUE; index++) {
			System.out.printf("%d x %d = %d%n", number, index, number * index);
		}
		
		scanner.close();
	}
	
}
