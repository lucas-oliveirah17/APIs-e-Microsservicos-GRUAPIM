package aula01.lanchonete;

import java.util.ArrayList;

/**
 * Representa um pedido da lanchonete.
 * Agrega uma lista polimórfica de Prato (Pizza, Lanche ou Salgadinho).
 */
public class Pedido {
    private String nomeCliente;
    private ArrayList<Prato> itensConsumidos;
    private double taxaServico; // percentual, ex: 0.10 = 10%

    public Pedido(String nomeCliente, double taxaServico) {
        this.nomeCliente      = nomeCliente;
        this.taxaServico      = taxaServico;
        this.itensConsumidos  = new ArrayList<>();
    }

    public void adicionarItem(Prato prato) {
        itensConsumidos.add(prato);
    }

    public void removerItem(int indice) {
        if (indice >= 0 && indice < itensConsumidos.size()) {
            itensConsumidos.remove(indice);
        } else {
            System.out.println("Índice inválido para remoção.");
        }
    }

    /** Soma o preço de todos os itens (sem taxa). */
    public double calcularSubtotal() {
        double subtotal = 0;
        for (Prato p : itensConsumidos) {
            subtotal += p.getPrecoVenda();
        }
        return subtotal;
    }

    /** Retorna o valor total com a taxa de serviço aplicada. */
    public double calcularTotal() {
        double subtotal = calcularSubtotal();
        return subtotal + (subtotal * taxaServico);
    }

    /** Exibe a nota fiscal completa na tela. */
    public void mostrarFatura() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║          NOTA FISCAL - Quase Três Lanches            ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("──────────────────────────────────────────────────────");
        System.out.printf("%-3s %-45s %s%n", "Nº", "Item", "Preço");
        System.out.println("──────────────────────────────────────────────────────");
        for (int i = 0; i < itensConsumidos.size(); i++) {
            Prato p = itensConsumidos.get(i);
            System.out.printf("%-3d %-45s R$ %6.2f%n", (i + 1), p.descricaoDetalhada(), p.getPrecoVenda());
        }
        System.out.println("──────────────────────────────────────────────────────");
        System.out.printf("Subtotal                                      R$ %6.2f%n", calcularSubtotal());
        System.out.printf("Taxa de serviço (%.0f%%)                         R$ %6.2f%n",
                taxaServico * 100, calcularSubtotal() * taxaServico);
        System.out.printf("TOTAL                                         R$ %6.2f%n", calcularTotal());
        System.out.println("══════════════════════════════════════════════════════");
    }

    /** Calcula e exibe o troco dado o valor recebido em dinheiro. */
    public void calcularTroco(double valorRecebido) {
        double total = calcularTotal();
        if (valorRecebido < total) {
            System.out.printf("Valor insuficiente! Faltam R$ %.2f.%n", total - valorRecebido);
        } else {
            System.out.printf("Valor recebido: R$ %.2f | Total: R$ %.2f | Troco: R$ %.2f%n",
                    valorRecebido, total, valorRecebido - total);
        }
    }

    // Getters
    public String getNomeCliente()              { return nomeCliente; }
    public ArrayList<Prato> getItensConsumidos(){ return itensConsumidos; }
    public double getTaxaServico()              { return taxaServico; }
}