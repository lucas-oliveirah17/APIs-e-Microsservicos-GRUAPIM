package aula01.bloco6;

import java.util.LinkedList;
import java.util.Queue;

/* Fila de Impressão (Queue): Simule uma fila de impressão. Crie uma Queue (usando LinkedList como implementação) 
 * e adicione 5 documentos (Strings com nomes como “Documento1.pdf”, “Foto.png”, etc.). Em seguida, processe a 
 * fila, “imprimindo” (removendo) cada documento e exibindo seu nome na ordem em que entraram.
 * */

public class Exercicio01 {
	public static void main(String[] args) {
        Queue<String> filaImpressao = new LinkedList<>();

        // Adiciona documentos na fila
        filaImpressao.offer("Documento1.pdf");
        filaImpressao.offer("Foto.png");
        filaImpressao.offer("Relatorio.docx");
        filaImpressao.offer("Planilha.xlsx");
        filaImpressao.offer("Apresentacao.pptx");

        System.out.println("=== Fila de Impressão ===");
        System.out.println("Documentos na fila: " + filaImpressao);
        System.out.println("\nIniciando impressão...\n");

        int ordem = 1;
        while (!filaImpressao.isEmpty()) {
            String documento = filaImpressao.poll(); // remove o primeiro da fila
            System.out.println("[" + ordem++ + "] Imprimindo: " + documento);
        }

        System.out.println("\nTodos os documentos foram impressos!");
        System.out.println("Fila vazia: " + filaImpressao.isEmpty());
    }
}
