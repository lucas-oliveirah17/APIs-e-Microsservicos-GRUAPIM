package aula01.bloco8.exercicio02;

/* Modificador de Atributos Privados
 * 
 * A aula demonstra como a reflexão pode quebrar o encapsulamento para modificar atributos privados, uma técnica 
 * essencial para frameworks de injeção de dependência e ORM.
 * 
 * Objetivo: Crie uma classe Configuracao com um atributo private String urlConexao = "localhost:5432";. Em outra 
 * classe, crie um método main que, sem usar getters ou setters, utilize reflection para alterar o valor deste 
 * atributo privado para "db.producao.com:5432". Ao final, imprima o valor para confirmar a alteração.
 *
 * Dicas:
 * Crie uma instância de Configuracao.
 * Obtenha o Field (campo) correspondente a urlConexao usando getDeclaredField("urlConexao").
 * Torne o campo acessível com field.setAccessible(true).
 * Altere seu valor usando field.set(objetoInstanciado, "novoValor").
 * Para verificar, use field.get(objetoInstanciado) para ler o novo valor e imprimi-lo.
 * */

import java.lang.reflect.Field;

public class MainB8E2 {
	public static void main(String[] args) throws Exception {
        Configuracao config = new Configuracao();

        // Obtém o campo privado pelo nome
        Field campo = Configuracao.class.getDeclaredField("urlConexao");

        // Torna o campo acessível (quebra o encapsulamento via reflection)
        campo.setAccessible(true);

        // Lê o valor original
        System.out.println("=== Modificador de Atributos Privados ===");
        System.out.println("Valor ANTES da alteração : " + campo.get(config));

        // Altera o valor sem usar setter
        campo.set(config, "db.producao.com:5432");

        // Confirma a alteração
        System.out.println("Valor DEPOIS da alteração: " + campo.get(config));

        // Demonstrando com outro campo para reforçar o conceito
        Field campoUsuario = Configuracao.class.getDeclaredField("usuario");
        campoUsuario.setAccessible(true);
        System.out.println("\nUsuário original : " + campoUsuario.get(config));
        campoUsuario.set(config, "root");
        System.out.println("Usuário alterado : " + campoUsuario.get(config));

        System.out.println("\nAtenção: quebrar encapsulamento com reflection deve ser");
        System.out.println("   usado apenas em contextos como frameworks, ORMs e testes.");
    }

}
