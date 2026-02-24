package aula01.bloco2.exercicio03;

public class Moto extends Veiculo {
	private int cilindradas;

    public Moto(String marca, String modelo, int cilindradas) {
        super(marca, modelo);
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        return "[Moto] " + super.toString() + " | Cilindradas: " + cilindradas + "cc";
    }
}
