package aula01.lanchonete;

import java.time.LocalDate;

/**
 * Classe principal para testar o protótipo do sistema da lanchonete "Quase Três Lanches".
 * Demonstra herança, polimorfismo e as funcionalidades de Pedido.
 */
public class MainLanchonete {
    public static void main(String[] args) {

        // ── Criando itens do cardápio (polimorfismo: todos tratados como Prato) ──
        Pizza pizza = new Pizza(
                49.90,
                LocalDate.of(2025, 12, 31),
                800,
                "Frango com catupiry",
                "recheada com catupiry",
                "tomate"
        );

        Lanche lanche = new Lanche(
                28.50,
                LocalDate.of(2025, 12, 31),
                350,
                "brioche",
                "carne artesanal",
                "maionese defumada"
        );

        Salgadinho coxinha = new Salgadinho(
                7.00,
                LocalDate.of(2025, 8, 15),
                100,
                "frito",
                "massa de coxinha",
                "frango"
        );

        Salgadinho enroladinho = new Salgadinho(
                5.50,
                LocalDate.of(2025, 8, 15),
                80,
                "assado",
                "massa folhada",
                "queijo"
        );

        // ── Exibindo cardápio ──────────────────────────────────────────────────
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║              CARDÁPIO - Quase Três Lanches           ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        Prato[] cardapio = {pizza, lanche, coxinha, enroladinho};
        for (Prato p : cardapio) {
            System.out.println(p); // polimorfismo: chama toString() de cada subclasse via descricaoDetalhada()
        }

        // ── Criando pedido ─────────────────────────────────────────────────────
        System.out.println("\n=== Criando pedido para o cliente 'João Silva' ===");
        Pedido pedido = new Pedido("João Silva", 0.10); // 10% de taxa de serviço

        pedido.adicionarItem(pizza);
        pedido.adicionarItem(lanche);
        pedido.adicionarItem(coxinha);
        pedido.adicionarItem(coxinha);   // 2 coxinhas
        pedido.adicionarItem(enroladinho);

        // ── Nota fiscal ───────────────────────────────────────────────────────
        pedido.mostrarFatura();

        // ── Troco ─────────────────────────────────────────────────────────────
        System.out.println("\n=== Cálculo de Troco ===");
        pedido.calcularTroco(200.00);
        pedido.calcularTroco(50.00);  // valor insuficiente

        // ── Demonstrando validação de tipo de salgadinho ──────────────────────
        System.out.println("\n=== Testando validação de tipo de salgadinho ===");
        try {
        	@SuppressWarnings("unused")
            Salgadinho invalido = new Salgadinho(5.0, LocalDate.now(), 100, "grelhado", "massa", "queijo");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
    }
}