package aula01.lanchonete;

import java.util.Scanner;

/**
 * Responsável por exibir todos os menus e coletar entradas do usuário
 * no sistema da lanchonete. Não contém lógica de negócio.
 */
public class MenuLanchonete {

    private Scanner sc;

    public MenuLanchonete(Scanner sc) {
        this.sc = sc;
    }

    public void exibirMenuPrincipal() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║     QUASE TRÊS LANCHES — SISTEMA         ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  1. Ver cardápio                         ║");
        System.out.println("║  2. Novo pedido                          ║");
        System.out.println("║  3. Adicionar item ao pedido             ║");
        System.out.println("║  4. Remover item do pedido               ║");
        System.out.println("║  5. Ver itens do pedido atual            ║");
        System.out.println("║  6. Gerar nota fiscal                    ║");
        System.out.println("║  7. Calcular troco                       ║");
        System.out.println("║  0. Sair                                 ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.print("Opção: ");
    }

    public void exibirCardapio(Prato[] cardapio) {
        System.out.println("\n══════════════ CARDÁPIO ══════════════");
        for (int i = 0; i < cardapio.length; i++) {
            System.out.printf("  [%d] %s%n", i + 1, cardapio[i]);
        }
    }

    public void exibirItensPedido(Pedido pedido) {
        System.out.println("\n── Itens do pedido de \"" + pedido.getNomeCliente() + "\" ──");
        if (pedido.getItensConsumidos().isEmpty()) {
            System.out.println("  (vazio)");
            return;
        }
        for (int i = 0; i < pedido.getItensConsumidos().size(); i++) {
            Prato p = pedido.getItensConsumidos().get(i);
            System.out.printf("  [%d] %-40s R$ %.2f%n", i + 1, p.descricaoDetalhada(), p.getPrecoVenda());
        }
        System.out.printf("  Subtotal: R$ %.2f%n", pedido.calcularSubtotal());
    }

    // ── Coleta de dados ────────────────────────────────────────────────────

    public String lerNomeCliente() {
        System.out.print("\nNome do cliente: ");
        return sc.nextLine();
    }

    public double lerTaxaServico() {
        System.out.print("Taxa de serviço em % (ex: 10 para 10%): ");
        return EntradaUtil.lerDouble(sc) / 100.0;
    }

    public int lerOpcaoMenu() {
        return EntradaUtil.lerInt(sc);
    }

    public int lerIndiceCardapio() {
        System.out.print("Número do item no cardápio: ");
        return EntradaUtil.lerInt(sc) - 1;
    }

    public int lerIndiceRemocao() {
        System.out.print("Número do item a remover: ");
        return EntradaUtil.lerInt(sc) - 1;
    }

    public double lerValorRecebido() {
        System.out.print("Valor recebido: R$ ");
        return EntradaUtil.lerDouble(sc);
    }

    // ── Mensagens de feedback ──────────────────────────────────────────────

    public void mensagemPedidoInexistente()  { System.out.println("Crie um pedido primeiro (opção 2)."); }
    public void mensagemPedidoVazio()        { System.out.println("Pedido vazio ou inexistente."); }
    public void mensagemItemInvalido()       { System.out.println("Item inválido."); }
    public void mensagemEncerrar()           { System.out.println("Encerrando sistema. Até logo!"); }
    public void mensagemOpcaoInvalida()      { System.out.println("Opção inválida."); }
}
