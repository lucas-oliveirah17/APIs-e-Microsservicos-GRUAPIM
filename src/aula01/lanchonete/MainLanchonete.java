package aula01.lanchonete;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Ponto de entrada do sistema da Lanchonete.
 * Contém apenas o loop principal e a lógica de controle de fluxo.
 * Exibição de menus → MenuLanchonete | Leitura segura → EntradaUtil
 */
public class MainLanchonete {

    static final Prato[] CARDAPIO = {
        new Pizza(49.90,  LocalDate.of(2026,12,31), 800, "Frango c/ catupiry", "recheada c/ catupiry", "tomate"),
        new Pizza(55.00,  LocalDate.of(2026,12,31), 850, "Calabresa",          "simples",              "tomate"),
        new Lanche(28.50, LocalDate.of(2026,12,31), 350, "brioche",  "carne artesanal",  "maionese defumada"),
        new Lanche(24.00, LocalDate.of(2026,12,31), 300, "integral", "frango grelhado",  "mostarda mel"),
        new Salgadinho(7.00, LocalDate.of(2026,8,15), 100, "frito",  "massa de coxinha", "frango"),
        new Salgadinho(5.50, LocalDate.of(2026,8,15),  80, "assado", "massa folhada",    "queijo")
    };

    public static void main(String[] args) {
        Scanner sc     = new Scanner(System.in);
        MenuLanchonete menu = new MenuLanchonete(sc);
        Pedido pedidoAtual  = null;
        int opcao;

        do {
            menu.exibirMenuPrincipal();
            opcao = menu.lerOpcaoMenu();

            switch (opcao) {
                case 1 -> menu.exibirCardapio(CARDAPIO);
                case 2 -> pedidoAtual = novoPedido(menu);
                case 3 -> adicionarItem(menu, pedidoAtual);
                case 4 -> removerItem(menu, pedidoAtual);
                case 5 -> listarItens(menu, pedidoAtual);
                case 6 -> gerarNota(menu, pedidoAtual);
                case 7 -> calcularTroco(menu, pedidoAtual);
                case 0 -> menu.mensagemEncerrar();
                default -> menu.mensagemOpcaoInvalida();
            }
        } while (opcao != 0);

        sc.close();
    }

    // ── Ações do sistema ───────────────────────────────────────────────────

    static Pedido novoPedido(MenuLanchonete menu) {
        String nome  = menu.lerNomeCliente();
        double taxa  = menu.lerTaxaServico();
        Pedido p     = new Pedido(nome, taxa);
        System.out.printf("Pedido criado para \"%s\" com taxa de %.0f%%.%n", nome, taxa * 100);
        return p;
    }

    static void adicionarItem(MenuLanchonete menu, Pedido pedido) {
        if (pedido == null) { menu.mensagemPedidoInexistente(); return; }
        menu.exibirCardapio(CARDAPIO);
        int idx = menu.lerIndiceCardapio();
        if (idx < 0 || idx >= CARDAPIO.length) { menu.mensagemItemInvalido(); return; }
        pedido.adicionarItem(CARDAPIO[idx]);
        System.out.println("Item adicionado: " + CARDAPIO[idx].descricaoDetalhada());
    }

    static void removerItem(MenuLanchonete menu, Pedido pedido) {
        if (pedido == null || pedido.getItensConsumidos().isEmpty()) { menu.mensagemPedidoVazio(); return; }
        menu.exibirItensPedido(pedido);
        int idx = menu.lerIndiceRemocao();
        pedido.removerItem(idx);
        System.out.println("Item removido.");
    }

    static void listarItens(MenuLanchonete menu, Pedido pedido) {
        if (pedido == null) { menu.mensagemPedidoInexistente(); return; }
        menu.exibirItensPedido(pedido);
    }

    static void gerarNota(MenuLanchonete menu, Pedido pedido) {
        if (pedido == null || pedido.getItensConsumidos().isEmpty()) { menu.mensagemPedidoVazio(); return; }
        pedido.mostrarFatura();
    }

    static void calcularTroco(MenuLanchonete menu, Pedido pedido) {
        if (pedido == null || pedido.getItensConsumidos().isEmpty()) { menu.mensagemPedidoVazio(); return; }
        System.out.printf("Total do pedido: R$ %.2f%n", pedido.calcularTotal());
        double recebido = menu.lerValorRecebido();
        pedido.calcularTroco(recebido);
    }
}
