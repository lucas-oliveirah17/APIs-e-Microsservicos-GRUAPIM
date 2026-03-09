package aula02.exercicio01;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TesteProduto {
	public static void main(String[] args) {
        // Inicializando a lista com 8 produtos de categorias diferentes
        List<Produto> produtos = Arrays.asList(
                new Produto("Notebook", 4500.0, "Eletrônicos"),
                new Produto("Smartphone", 2500.0, "Eletrônicos"),
                new Produto("Clean Code", 120.0, "Livros"),
                new Produto("O Programador Pragmático", 150.0, "Livros"),
                new Produto("Smart TV", 3200.0, "Eletrônicos"),
                new Produto("Fone Bluetooth", 250.0, "Eletrônicos"),
                new Produto("Padrões de Projetos", 180.0, "Livros"),
                new Produto("Mouse sem fio", 90.0, "Eletrônicos")
        );

        /* a. Use forEach e uma estrutura if tradicional para imprimir o nome de todos os 
         * produtos da categoria “Eletrônicos”. Em seguida, refaça o mesmo exercício usando 
         * stream() e a operação filter().
         * */
        System.out.println("========= Letra A: Eletrônicos =========");
        System.out.println("-> Usando forEach com if tradicional:");
        produtos.forEach(p -> {
            if (p.getCategoria().equals("Eletrônicos")) {
                System.out.println(p.getNome());
            }
        });

        System.out.println("\n-> Usando Stream e filter:");
        produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .forEach(p -> System.out.println(p.getNome()));

        /* b. Crie uma nova lista contendo apenas os preços de todos os produtos cujo preço seja 
         * maior que 500.0. Use as operações filter() e map(). Imprima a lista de preços.
         * */
        System.out.println("\n========= Letra B: Preços > 500 =========");
        List<Double> precosMaiorQue500 = produtos.stream()
                .filter(p -> p.getPreco() > 500.0)
                .map(Produto::getPreco)
                .collect(Collectors.toList());
        System.out.println(precosMaiorQue500);

        /* c. Calcule o valor total do estoque de produtos da categoria “Livros”. Use filter() para 
         * selecionar os produtos da categoria correta e, em seguida, use mapToDouble() e sum() para 
         * calcular o total.
         * */
        System.out.println("\n========= Letra C: Total do Estoque de Livros =========");
        double totalLivros = produtos.stream()
                .filter(p -> p.getCategoria().equals("Livros"))
                .mapToDouble(Produto::getPreco)
                .sum();
        System.out.println("Valor total de Livros: R$ " + totalLivros);


        /* f. Crie um stream a partir da sua lista de produtos e use .map() para obter uma List<String> 
         * contendo apenas os nomes dos produtos. Primeiro, faça isso com uma expressão lambda 
         * (p -> p.getNome()) e depois refatore para usar uma referência de método (Produto::getNome).
         * */
        System.out.println("\n========= Letra F: Lista de Nomes com Map =========");
        // Usando Expressão Lambda (p -> p.getNome())
        List<String> nomesLambda = produtos.stream()
                .map(p -> p.getNome())
                .collect(Collectors.toList());
        System.out.println("Nomes (Lambda): " + nomesLambda);

        // Usando Referência de Método (Produto::getNome)
        List<String> nomesMethodRef = produtos.stream()
                .map(Produto::getNome)
                .collect(Collectors.toList());
        System.out.println("Nomes (Method Reference): " + nomesMethodRef);


        /* e. No seu método main, chame o buscarProdutoPorNome: Primeiro, com um nome de produto que existe. 
         * Use ifPresent() para imprimir os detalhes do produto; Depois, com um nome que não existe. Use 
         * orElseThrow() para lançar uma RuntimeException com a mensagem “Produto não encontrado!”.
         * */
        System.out.println("\n=== Letra E: Buscar Produtos (ifPresent e orElseThrow) ===");
        // 1. Buscando produto que existe
        System.out.print("Busca por 'Notebook': ");
        buscarProdutoPorNome(produtos, "Notebook")
                .ifPresent(p -> System.out.println("Detalhes: " + p));

        // 2. Buscando produto que NÃO existe (Isso vai quebrar a execução por lançar a RuntimeException)
        System.out.println("Busca por 'Geladeira': ");
        try {
            Produto naoEncontrado = buscarProdutoPorNome(produtos, "Geladeira")
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
        } catch (RuntimeException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }
    }
	
	/* d. Escreva um método buscarProdutoPorNome(List<Produto> produtos, String nome) que retorna um 
	 * Optional<Produto>. Use a Stream API (filter e findFirst).
	 * */
	public static Optional<Produto> buscarProdutoPorNome(List<Produto> produtos, String nome) {
        return produtos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}
