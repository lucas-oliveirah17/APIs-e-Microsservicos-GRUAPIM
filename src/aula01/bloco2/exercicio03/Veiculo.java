package aula01.bloco2.exercicio03;

public abstract class Veiculo {
	protected String marca;
    protected String modelo;

    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + " | Modelo: " + modelo;
    }
}
