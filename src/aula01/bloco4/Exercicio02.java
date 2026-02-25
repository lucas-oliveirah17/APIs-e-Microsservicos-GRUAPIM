package aula01.bloco4;

import java.util.HashSet;

/* Unicidade de E-mails (HashSet): Crie um HashSet para armazenar endereços de e-mail (Strings). 
 * Tente adicionar alguns e-mails, incluindo um que seja duplicado. Imprima o tamanho do Set para 
 * confirmar que o e-mail duplicado não foi adicionado.
 * */

public class Exercicio02 {
	public static void main(String[] args) {
        HashSet<String> emails = new HashSet<>();

        emails.add("alice@email.com");
        emails.add("bob@email.com");
        emails.add("carol@email.com");
        emails.add("bob@email.com");      // duplicado
        emails.add("diana@email.com");
        emails.add("alice@email.com");    // duplicado

        System.out.println("E-mails cadastrados: " + emails);
        System.out.println("\nTotal de e-mails tentados: 6");
        System.out.println("Total armazenado no Set  : " + emails.size());
        System.out.println("\nOs e-mails duplicados foram ignorados automaticamente.");
    }
}
