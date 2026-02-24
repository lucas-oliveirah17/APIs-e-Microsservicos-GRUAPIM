package aula01.bloco2.exercicio02;

public class MainB2E2 {
	 public static void main(String[] args) {
        // Uso normal
        Circulo c = new Circulo(5.0);
        System.out.printf("Raio  : %.2f%n", c.getRaio());
        System.out.printf("Área  : %.4f%n", c.calcularArea());

        System.out.println();

        // Testando a validação
        try {
            c.setRaio(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }

        try {
        	@SuppressWarnings("unused")
            Circulo invalido = new Circulo(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
    }
}
