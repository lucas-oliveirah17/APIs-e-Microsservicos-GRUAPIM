package aula01.bloco2.exercicio03;

public class Carro extends Veiculo {
	private int numeroDePortas;

    public Carro(String marca, String modelo, int numeroDePortas) {
        super(marca, modelo);
        this.numeroDePortas = numeroDePortas;
    }

    @Override
    public String toString() {
        return "[Carro] " + super.toString() + " | Portas: " + numeroDePortas;
    }
}
