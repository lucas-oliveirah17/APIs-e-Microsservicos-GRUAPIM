package aula01.lanchonete;

import java.util.Scanner;

/**
 * Utilitário para leitura segura de entradas do usuário via Scanner.
 * Centraliza o tratamento de NumberFormatException em um único lugar.
 */
public class EntradaUtil {

    private EntradaUtil() {}

    public static int lerInt(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Usando 0.");
            return 0;
        }
    }

    public static double lerDouble(Scanner sc) {
        try {
            return Double.parseDouble(sc.nextLine().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Usando 0.");
            return 0;
        }
    }

    public static String lerString(Scanner sc) {
        return sc.nextLine().trim();
    }
}
