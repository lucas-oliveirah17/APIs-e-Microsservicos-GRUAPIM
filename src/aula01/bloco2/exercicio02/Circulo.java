package aula01.bloco2.exercicio02;

/* Classe Circulo com Encapsulamento: Crie uma classe Circulo com um atributo privado 
 * raio (double). Crie um construtor e os métodos getRaio e setRaio. No setRaio, adicione 
 * uma validação para garantir que o raio nunca seja um valor negativo ou zero (lance uma 
 * IllegalArgumentException se a condição não for atendida). Crie também um método 
 * calcularArea() que retorna a área do círculo (pi * raio^2).
 * */

public class Circulo {
	private double raio;

    public Circulo(double raio) {
        setRaio(raio);
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        if (raio <= 0) {
            throw new IllegalArgumentException(
        		"O raio deve ser um valor positivo e maior que zero. Valor recebido: " + raio);
        }
        this.raio = raio;
    }

    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}
