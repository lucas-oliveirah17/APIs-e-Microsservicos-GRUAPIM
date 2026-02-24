package aula01.vcriquinho;

/**
 * Classe abstrata base para todos os produtos de investimento da VcRiquinho.
 */
public abstract class ProdutoFinanceiro implements Rentavel {
    private static int contadorId = 1;

    private int id;
    private String nome;
    private String descricao;
    private double rendimentoMensal; // percentual, ex: 0.012 = 1.2% ao mês

    public ProdutoFinanceiro(String nome, String descricao, double rendimentoMensal) {
        this.id               = contadorId++;
        this.nome             = nome;
        this.descricao        = descricao;
        this.rendimentoMensal = rendimentoMensal;
    }

    // Getters e Setters
    public int getId()                          { return id; }
    public String getNome()                     { return nome; }
    public String getDescricao()                { return descricao; }
    public double getRendimentoMensal()         { return rendimentoMensal; }

    public void setNome(String nome)                         { this.nome = nome; }
    public void setDescricao(String descricao)               { this.descricao = descricao; }
    public void setRendimentoMensal(double rendimentoMensal) { this.rendimentoMensal = rendimentoMensal; }

    @Override
    public String toString() {
        return String.format("[ID:%d] %s — %s | Rend. mensal: %.2f%%", id, nome, descricao, rendimentoMensal * 100);
    }
}

// ─── Renda Fixa ──────────────────────────────────────────────────────────────
class ProdutoRendaFixa extends ProdutoFinanceiro {
    private int carenciaDias; // período mínimo antes de poder retirar

    public ProdutoRendaFixa(String nome, String descricao, double rendimentoMensal, int carenciaDias) {
        super(nome, descricao, rendimentoMensal);
        this.carenciaDias = carenciaDias;
    }

    public int getCarenciaDias() { return carenciaDias; }
    public void setCarenciaDias(int carenciaDias) { this.carenciaDias = carenciaDias; }

    /**
     * Calcula rendimento proporcional ao período.
     * Retorna 0 se o período estiver dentro da carência (produto bloqueado).
     */
    @Override
    public double calcularRendimento(int dias) {
        if (dias < carenciaDias) return 0; // dentro da carência — não considerado
        double rendimentoDiario = getRendimentoMensal() / 30.0;
        return rendimentoDiario * dias;
    }

    public boolean estaEmCarencia(int dias) { return dias < carenciaDias; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Carência: %d dias [RENDA FIXA]", carenciaDias);
    }
}

// ─── Renda Variável ───────────────────────────────────────────────────────────
class ProdutoRendaVariavel extends ProdutoFinanceiro {
    // rendimentoMensal aqui representa o rendimento esperado baseado no histórico

    public ProdutoRendaVariavel(String nome, String descricao, double rendimentoMensalEsperado) {
        super(nome, descricao, rendimentoMensalEsperado);
    }

    @Override
    public double calcularRendimento(int dias) {
        double rendimentoDiario = getRendimentoMensal() / 30.0;
        return rendimentoDiario * dias;
    }

    @Override
    public String toString() {
        return super.toString() + " [RENDA VARIÁVEL]";
    }
}