package aula01.bloco7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* Sorteio de Ganhadores Únicos: Crie uma lista (ArrayList) com nomes de participantes, permitindo que alguns 
 * nomes se repitam. Escreva um método que realize um sorteio: ele deve primeiro garantir que cada participante 
 * seja considerado apenas uma vez (mesmo que seu nome apareça várias vezes) e depois sortear aleatoriamente 3 
 * nomes únicos para serem os ganhadores.
 * */

public class Exercicio02 {
	public static List<String> sortear(List<String> participantes, int qtdGanhadores) {
        // Garante unicidade eliminando repetições com HashSet
        List<String> unicos = new ArrayList<>(new HashSet<>(participantes));

        if (unicos.size() < qtdGanhadores) {
            throw new IllegalArgumentException(
                "Participantes únicos insuficientes. Necessário: " + qtdGanhadores +
                " | Disponível: " + unicos.size()
            );
        }

        // Embaralha e pega os primeiros N
        Collections.shuffle(unicos);
        return unicos.subList(0, qtdGanhadores);
    }

    public static void main(String[] args) {
        List<String> participantes = new ArrayList<>(Arrays.asList(
            "Alice", "Bruno", "Carlos", "Diana", "Eduardo",
            "Alice",  // duplicado
            "Bruno",  // duplicado
            "Fernanda", "Gabriel", "Helena",
            "Carlos"  // duplicado
        ));

        System.out.println("=== Sorteio de Ganhadores ===");
        System.out.println("Lista de participantes (" + participantes.size() + " inscrições): " + participantes);

        List<String> ganhadores = sortear(participantes, 3);

        System.out.println("\nOs 3 ganhadores únicos são:");
        for (int i = 0; i < ganhadores.size(); i++) {
            System.out.println("  " + (i + 1) + "º lugar: " + ganhadores.get(i));
        }
    }
}
