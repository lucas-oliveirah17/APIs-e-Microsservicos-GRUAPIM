package aula01.bloco2.exercicio01;

public class MainB2E1 {
    public static void main(String[] args) {
        Carro carro1 = new Carro("Toyota", "Corolla", 2022);
        Carro carro2 = new Carro("Honda", "Civic", 2020);

        carro1.exibirInfo();
        System.out.println();
        carro2.exibirInfo();
    }
}
