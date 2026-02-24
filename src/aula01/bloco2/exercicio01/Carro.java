package aula01.bloco2.exercicio01;

/* Classe Carro: Crie uma classe Carro com os seguintes atributos privados: marca (String), 
 * modelo (String) e ano (int). Implemente um construtor para inicializar esses atributos e 
 * métodos públicos getters para cada um deles. Adicione um método exibirInfo() que imprime 
 * os detalhes do carro.
 * */

public class Carro {
    private String marca;
    private String modelo;
    private int ano;

    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }

    public void exibirInfo() {
        System.out.println("=== Informações do Carro ===");
        System.out.println("Marca : " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano   : " + ano);
    }
}
