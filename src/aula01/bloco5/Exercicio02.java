package aula01.bloco5;

import java.util.HashMap;
import java.util.Map;

/* Contador de Frequência de Palavras: Crie uma String contendo um parágrafo de texto. Use um 
 * HashMap<String, Integer> para contar a frequência de cada palavra no texto. Ao final, itere sobre 
 * o mapa e exiba cada palavra e sua contagem.
 * */

public class Exercicio02 {
	public static void main(String[] args) {
        String texto = "o rato roeu a roupa do rei de roma a rainha reclamou e o rei ficou com raiva do rato";

        // Remove pontuação e converte para minúsculas
        String[] palavras = texto.toLowerCase().replaceAll("[^a-záéíóúãõâêîôûç ]", "").split("\\s+");

        HashMap<String, Integer> frequencia = new HashMap<>();

        for (String palavra : palavras) {
            frequencia.put(palavra, frequencia.getOrDefault(palavra, 0) + 1);
        }

        System.out.println("Texto analisado:");
        System.out.println("\"" + texto + "\"");
        System.out.println("\n--- Frequência de cada palavra ---");

        for (Map.Entry<String, Integer> entrada : frequencia.entrySet()) {
            System.out.printf("%-15s : %d vez(es)%n", entrada.getKey(), entrada.getValue());
        }
    }
}
