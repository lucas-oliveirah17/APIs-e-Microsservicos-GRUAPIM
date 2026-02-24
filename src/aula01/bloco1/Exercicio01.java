package aula01.bloco1;

import java.util.Scanner;

/* Calculadora de Média: Escreva um programa que utiliza a classe Scanner para ler 3 
 * notas de um aluno. Calcule e exiba a média aritmética das notas. Em seguida, usando 
 * uma estrutura if-else, informe se o aluno foi “Aprovado” (média >= 7), “Recuperação” 
 * (média >= 5 e < 7) ou “Reprovado” (média < 5).
 * */

public class Exercicio01 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a nota 1: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Digite a nota 2: ");
        double nota2 = scanner.nextDouble();

        System.out.print("Digite a nota 3: ");
        double nota3 = scanner.nextDouble();

        double media = (nota1 + nota2 + nota3) / 3;

        System.out.printf("Média: %.2f%n", media);

        if (media >= 7) {
            System.out.println("Situação: Aprovado");
        } else if (media >= 5) {
            System.out.println("Situação: Recuperação");
        } else {
            System.out.println("Situação: Reprovado");
        }

        scanner.close();
    }
}
