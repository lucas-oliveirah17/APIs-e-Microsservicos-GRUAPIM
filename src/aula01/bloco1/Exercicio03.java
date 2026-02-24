package aula01.bloco1;

import java.util.Random;
import java.util.Scanner;

/* Adivinhe o Número: Gere um número aleatório entre 1 e 100. Peça ao 
 * usuário para adivinhar o número. Use um laço while para continuar 
 * pedindo um número até que o usuário acerte. A cada tentativa, dê uma dica 
 * se o palpite foi “muito alto” ou “muito baixo”. No final, informe o número de 
 * tentativas.
 * */

public class Exercicio03 {
	public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int numeroSecreto = random.nextInt(100) + 1;
        int tentativas = 0;
        int palpite = 0;

        System.out.println("Adivinhe o número entre 1 e 100!");

        while (palpite != numeroSecreto) {
            System.out.print("Seu palpite: ");
            palpite = scanner.nextInt();
            tentativas++;

            if (palpite < numeroSecreto) {
                System.out.println("Muito baixo! Tente novamente.");
            } else if (palpite > numeroSecreto) {
                System.out.println("Muito alto! Tente novamente.");
            }
        }

        System.out.println("Parabéns! Você acertou o número " + numeroSecreto + " em " + tentativas + " tentativa(s).");

        scanner.close();
    }
}
