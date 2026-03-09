package aula01.vcriquinho;

/**
 * Serviço responsável por calcular e exibir simulações de rendimento
 * para todos os tipos de conta de um cliente, dado um período em dias.
 */
public class SimulacaoService {

    private static final int[] PERIODOS_VALIDOS = {30, 60, 90, 180};

    public void simular(Cliente cliente, int dias) {
        // Valida período
        boolean periodoValido = false;
        for (int p : PERIODOS_VALIDOS) { if (dias == p) { periodoValido = true; break; } }
        if (!periodoValido) {
            System.out.println("Período inválido. Use: 30, 60, 90 ou 180 dias.");
            return;
        }

        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║              SIMULAÇÃO DE RENDIMENTOS — VcRiquinho          ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println("Cliente : " + cliente.getNome() + " (" + cliente.getTipoCliente() + ")");
        System.out.println("Período : " + dias + " dias");
        System.out.println("─────────────────────────────────────────────────────────────");

        double totalRendimentos  = 0;
        double totalTaxaServico  = 0;

        for (Conta conta : cliente.getContas()) {
            double rendimento = conta.calcularRendimento(dias);
            double taxa       = conta.calcularTaxaServico(dias);

            System.out.printf("  Conta [ID:%d] %-35s | Saldo: R$ %8.2f%n",
                    conta.getId(), conta.getTipoConta(), conta.getSaldo());
            System.out.printf("    Rendimento bruto : R$ %.2f%n", rendimento);
            System.out.printf("    Taxa de serviço  : R$ %.2f%n", taxa);
            System.out.printf("    Rendimento líquido: R$ %.2f%n", rendimento - taxa);
            System.out.println("    ·····");

            totalRendimentos += rendimento;
            totalTaxaServico += taxa;
        }

        System.out.println("─────────────────────────────────────────────────────────────");
        System.out.printf("  TOTAL Rendimento bruto  : R$ %.2f%n", totalRendimentos);
        System.out.printf("  TOTAL Taxa de serviço   : R$ %.2f%n", totalTaxaServico);
        System.out.printf("  TOTAL Rendimento líquido: R$ %.2f%n", totalRendimentos - totalTaxaServico);
        System.out.println("══════════════════════════════════════════════════════════════");
    }
}
