package aula01.vcriquinho;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstrata base para todos os tipos de conta da VcRiquinho.
 */
public abstract class Conta {
    private static int contadorId = 1;

    private int id;
    private double saldo;

    public Conta(double saldoInicial) {
        this.id    = contadorId++;
        this.saldo = saldoInicial;
    }

    public int getId()      { return id; }
    public double getSaldo(){ return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public void depositar(double valor) {
        if (valor > 0) saldo += valor;
    }

    /** Retorna o rendimento bruto para o período. */
    public abstract double calcularRendimento(int dias);

    /** Retorna a taxa de serviço cobrada sobre o rendimento. */
    public abstract double calcularTaxaServico(int dias);

    /** Descrição do tipo de conta. */
    public abstract String getTipoConta();

    public void exibirResumo(int dias) {
        double rendimento    = calcularRendimento(dias);
        double taxa          = calcularTaxaServico(dias);
        System.out.printf("  Conta [ID:%d] %-30s | Saldo: R$ %8.2f | Rendimento (%d dias): R$ %7.2f | Taxa serviço: R$ %6.2f%n",
                id, getTipoConta(), saldo, dias, rendimento, taxa);
    }

    @Override
    public String toString() {
        return String.format("[Conta ID:%d] %s | Saldo: R$ %.2f", id, getTipoConta(), saldo);
    }
}

// ─── Conta Corrente ───────────────────────────────────────────────────────────
class ContaCorrente extends Conta {
    public ContaCorrente(double saldoInicial) { super(saldoInicial); }

    @Override public double calcularRendimento(int dias)    { return 0; } // não rende
    @Override public double calcularTaxaServico(int dias)   { return 0; } // sem rendimento, sem taxa
    @Override public String getTipoConta()                  { return "Conta Corrente"; }
}

// ─── Conta CDI ────────────────────────────────────────────────────────────────
class ContaCDI extends Conta {
    private static final double CDI_ANUAL    = 0.1065; // CDI referência ~ 10.65% a.a.
    private static final double TAXA_SERVICO = 0.0007; // 0.07% sobre os ganhos

    public ContaCDI(double saldoInicial) { super(saldoInicial); }

    @Override
    public double calcularRendimento(int dias) {
        // rende 1/30 do CDI mensal por dia
        double cdiMensal  = CDI_ANUAL / 12.0;
        double cdiDiario  = cdiMensal / 30.0;
        return getSaldo() * cdiDiario * dias;
    }

    @Override
    public double calcularTaxaServico(int dias) {
        return calcularRendimento(dias) * TAXA_SERVICO;
    }

    @Override public String getTipoConta() { return "Conta CDI"; }
}

// ─── Conta Investimento Automático ───────────────────────────────────────────
class ContaInvestimentoAutomatico extends Conta {
    private List<ProdutoFinanceiro> produtos;
    private boolean pessoaJuridica;

    private static final double TAXA_PF = 0.001;  // 0.1%
    private static final double TAXA_PJ = 0.0015; // 0.15%

    public ContaInvestimentoAutomatico(double saldoInicial, boolean pessoaJuridica) {
        super(saldoInicial);
        this.pessoaJuridica = pessoaJuridica;
        this.produtos       = new ArrayList<>();
    }

    public void adicionarProduto(ProdutoFinanceiro p) { produtos.add(p); }
    public List<ProdutoFinanceiro> getProdutos()      { return produtos; }

    @Override
    public double calcularRendimento(int dias) {
        double totalRendimento = 0;
        for (ProdutoFinanceiro p : produtos) {
            double rend = p.calcularRendimento(dias);
            // Se for renda fixa em carência, informa e ignora
            if (p instanceof ProdutoRendaFixa) {
                ProdutoRendaFixa rf = (ProdutoRendaFixa) p;
                if (rf.estaEmCarencia(dias)) {
                    System.out.printf("    ⚠ Produto '%s' está em carência (%d dias < %d dias). Não considerado.%n",
                            p.getNome(), dias, rf.getCarenciaDias());
                    continue;
                }
            }
            totalRendimento += getSaldo() * rend;
        }
        return totalRendimento;
    }

    @Override
    public double calcularTaxaServico(int dias) {
        double taxa = pessoaJuridica ? TAXA_PJ : TAXA_PF;
        return calcularRendimento(dias) * taxa;
    }

    @Override
    public String getTipoConta() {
        return "Investimento Automático (" + (pessoaJuridica ? "PJ" : "PF") + ")";
    }
}