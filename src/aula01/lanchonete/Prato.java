package aula01.lanchonete;

import java.time.LocalDate;

/**
 * Classe abstrata base para todos os itens do cardápio.
 * Define os atributos comuns exigidos pelo cliente: preço, data de validade e peso.
 */
public abstract class Prato {
    private double precoVenda;
    private LocalDate dataValidade;
    private double peso; // em gramas

    public Prato(double precoVenda, LocalDate dataValidade, double peso) {
        this.precoVenda  = precoVenda;
        this.dataValidade = dataValidade;
        this.peso         = peso;
    }

    // Método abstrato: cada subclasse define como exibe seus detalhes específicos
    public abstract String descricaoDetalhada();

    // Getters
    public double getPrecoVenda()       { return precoVenda; }
    public LocalDate getDataValidade()  { return dataValidade; }
    public double getPeso()             { return peso; }

    // Setters
    public void setPrecoVenda(double precoVenda)           { this.precoVenda = precoVenda; }
    public void setDataValidade(LocalDate dataValidade)    { this.dataValidade = dataValidade; }
    public void setPeso(double peso)                       { this.peso = peso; }

    @Override
    public String toString() {
        return String.format("%-35s | R$ %6.2f | Val: %s | %g g",
                descricaoDetalhada(), precoVenda, dataValidade, peso);
    }
}