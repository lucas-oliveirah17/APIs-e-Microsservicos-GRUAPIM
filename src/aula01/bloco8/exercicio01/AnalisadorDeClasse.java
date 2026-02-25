package aula01.bloco8.exercicio01;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class AnalisadorDeClasse {
	public static void inspecionar(Object obj) {
		if (obj == null) {
            System.out.println("Erro: O objeto fornecido é nulo.");
            return;
        }
		
        Class<?> classe = obj.getClass();

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║        INSPETOR DE CLASSE - Reflection   ║");
        System.out.println("╚══════════════════════════════════════════╝");

        // 1. Nome completo da classe
        System.out.println("\nClasse: " + classe.getName());

        // 2. Atributos (incluindo privados)
        System.out.println("\nAtributos (getDeclaredFields):");
        Field[] campos = classe.getDeclaredFields();
        for (Field campo : campos) {
            String modificador = Modifier.toString(campo.getModifiers());
            String modFormatado = modificador.isEmpty() ? "[default]" : "[" + modificador + "]";
            System.out.println("   " + modFormatado + " " + campo.getType().getSimpleName() + " " + campo.getName());
        }

        // 3. Métodos (incluindo privados)
        System.out.println("\nMétodos (getDeclaredMethods):");
        Method[] metodos = classe.getDeclaredMethods();
        for (Method metodo : metodos) {
        	String modificador = Modifier.toString(metodo.getModifiers());
            String modFormatado = modificador.isEmpty() ? "[default]" : "[" + modificador + "]";
            
            StringBuilder parametros = new StringBuilder();
            Parameter[] params = metodo.getParameters();
            for (int i = 0; i < params.length; i++) {
                parametros.append(params[i].getType().getSimpleName());
                if (i < params.length - 1) {
                    parametros.append(", ");
                }
            }

            System.out.println("   " + modFormatado + " " + metodo.getReturnType().getSimpleName() + " " + metodo.getName() + "(" + parametros + ")");
        }

        System.out.println("\n═══════════════════════════════════════════");
    }
}
