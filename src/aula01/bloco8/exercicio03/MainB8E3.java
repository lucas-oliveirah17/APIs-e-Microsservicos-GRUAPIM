package aula01.bloco8.exercicio03;

/* Framework de Testes Simulado com Anotações
 * Este exercício simula como frameworks (JUnit, TestNG) usam reflection para encontrar e executar métodos de 
 * teste automaticamente.
 * 
 * Objetivo: Desenvolver um pequeno executor de testes que executa métodos marcados com uma anotação personalizada.
 * 
 * 1. Crie uma anotação:
 * 
 * 2. Crie uma classe com métodos de “teste”:
 * 
 * 3. Crie a classe ExecutorDeTestes:
 * - Ela deve ter um método public static void executarTestes(Object obj).
 * - Dentro deste método, use reflection para obter todos os métodos da classe do objeto recebido.
 * - Itere sobre os métodos e verifique, para cada um, se ele possui a anotação @Teste usando 
 * method.isAnnotationPresent(Teste.class).
 * - Se um método tiver a anotação, invoque-o dinamicamente usando method.invoke(obj).
 * */

public class MainB8E3 {
	public static void main(String[] args) {
        MinhaClasseDeTeste instancia = new MinhaClasseDeTeste();
        ExecutorDeTestes.executarTestes(instancia);
    }
}
