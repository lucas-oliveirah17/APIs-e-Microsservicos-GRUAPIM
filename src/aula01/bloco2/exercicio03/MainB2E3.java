package aula01.bloco2.exercicio03;

/* Herança de Veiculo: Crie uma classe Veiculo com atributos marca e modelo. Em seguida, 
 * crie duas subclasses: Carro (que adiciona numeroDePortas) e Moto (que adiciona cilindradas). 
 * Sobrescreva o método toString() em todas as classes para exibir suas informações de forma 
 * completa.
 * */

public class MainB2E3 {
	public static void main(String[] args) {
        Carro carro  = new Carro("Ford", "Ka", 4);
        Moto moto  = new Moto("Honda", "CB 500", 500);

        System.out.println(carro);
        System.out.println(moto);
    }
}
