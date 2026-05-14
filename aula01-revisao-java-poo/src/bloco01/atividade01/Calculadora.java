package bloco01.atividade01;

import java.util.Scanner;

/*
 * 1. Calculadora de Média: Escreva um programa que utiliza a classe Scanner para ler 3 notas de um aluno. 
 * Calcule e exiba a média aritmética das notas. Em seguida, usando uma estrutura if-else, informe se o
 * aluno foi “Aprovado” (média >= 7), “Recuperação” (média >= 5 e < 7) ou “Reprovado” (média < 5).
 */
public class Calculadora {
	
	static final int MIN_GRADE = 0;
	static final int MAX_GRADE = 10;
	
	static final int APPROVED_GRADE = 7;
	static final int RECOVERY_GRADE = 5;

	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		float[] grades = new float[3];
		float average = 0;
		boolean isValidGrade;

		for (int index = 0; index < grades.length; index++) {
			do {

				System.out.printf("Nota %d: ", index + 1);
				grades[index] = scanner.nextFloat();
				isValidGrade = (grades[index] >= MIN_GRADE && grades[index] <= MAX_GRADE);

				if (!isValidGrade) {
					System.out.printf("NOTA INVÁLIDA! Somente notas de %d à %d são aceitas.%n", MIN_GRADE, MAX_GRADE);
				}
			} while (!isValidGrade);

			average += grades[index];
		}

		average /= grades.length;
		if (average >= APPROVED_GRADE) {
			System.out.print("Aprovado! ");
		} else if (average >= RECOVERY_GRADE) {
			System.out.print("Recuperação! ");
		} else {
			System.out.print("Reprovado! ");
		}
		System.out.printf("Média = %.2f", average);

		scanner.close();
	}
	
}
