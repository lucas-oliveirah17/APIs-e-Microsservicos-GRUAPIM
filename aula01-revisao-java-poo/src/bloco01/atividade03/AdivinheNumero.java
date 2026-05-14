package bloco01.atividade03;

import java.util.Scanner;

/*
 * 3. Adivinhe o Número: Gere um número aleatório entre 1 e 100. Peça ao usuário para adivinhar o número. 
 * Use um laço while para continuar pedindo um número até que o usuário acerte. A cada tentativa, dê uma 
 * dica se o palpite foi “muito alto” ou “muito baixo”. No final, informe o número de tentativas.
 */
public class AdivinheNumero {
	
	static final int MIN_VALUE = 1;
	static final int MAX_VALUE = 100;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int randomNumber = (int) (Math.random() * (MAX_VALUE - MIN_VALUE + 1)) + MIN_VALUE;
		int number = 0, tries = 0;
		
		while (number != randomNumber) {
			System.out.print("Entre 1 à 100, adivinhe o número! ");
						
			number = scanner.nextInt();
			
			if (number < MIN_VALUE || number > MAX_VALUE) {
				System.out.printf("Número inválido. Somente número de %d à %d!%n", MIN_VALUE, MAX_VALUE);
				continue;
			}
			tries++;
			
			if (number > randomNumber) {
				System.out.println("Muito Alto!");
			}
			else if (number < randomNumber) {
				System.out.println("Muito Baixo!");
			}
			else {
				System.out.println("ACERTOU!!!");
				System.out.printf("Foram realizadas %d tentativas válidas para acertar!", tries);
			}
		}
		
		scanner.close();
	}
	
}
