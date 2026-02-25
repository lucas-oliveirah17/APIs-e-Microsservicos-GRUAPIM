package aula01.bloco8.exercicio03;

import java.lang.reflect.Method;

public class ExecutorDeTestes {
	public static void executarTestes(Object obj) {
        Class<?> classe = obj.getClass();
        Method[] metodos = classe.getDeclaredMethods();

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║       EXECUTOR DE TESTES - Reflection    ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println("Classe: " + classe.getSimpleName());
        System.out.println("Total de métodos encontrados: " + metodos.length);
        System.out.println("─────────────────────────────────────────");

        int executados = 0;
        int ignorados  = 0;

        for (Method metodo : metodos) {
            if (metodo.isAnnotationPresent(Teste.class)) {
                System.out.println("\nExecutando: " + metodo.getName() + "()");
                try {
                    metodo.invoke(obj);
                    executados++;
                } catch (Exception e) {
                    System.out.println("ERRO ao executar " + metodo.getName() + ": " + e.getCause().getMessage());
                    executados++;
                }
            } else {
                System.out.println("\nIgnorado (sem @Teste): " + metodo.getName() + "()");
                ignorados++;
            }
        }

        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("Testes executados: " + executados);
        System.out.println("Métodos ignorados: " + ignorados);
    }
}
