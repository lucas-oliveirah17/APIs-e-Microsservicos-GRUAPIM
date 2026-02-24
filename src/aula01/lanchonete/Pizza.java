package aula01.lanchonete;

import java.time.LocalDate;

/**
 * Representa uma pizza do cardápio.
 * Herda de Prato e adiciona: recheio, borda e molho.
 */
public class Pizza extends Prato {
    private String recheio;
    private String borda;   // ex: "simples", "recheada com catupiry", "recheada com cheddar"
    private String molho;   // ex: "tomate", "branco", "barbecue"

    public Pizza(double precoVenda, LocalDate dataValidade, double peso,
                 String recheio, String borda, String molho) {
        super(precoVenda, dataValidade, peso);
        this.recheio = recheio;
        this.borda   = borda;
        this.molho   = molho;
    }

    @Override
    public String descricaoDetalhada() {
        return String.format("Pizza | Recheio: %s | Borda: %s | Molho: %s", recheio, borda, molho);
    }

    // Getters e Setters
    public String getRecheio() { return recheio; }
    public String getBorda()   { return borda; }
    public String getMolho()   { return molho; }

    public void setRecheio(String recheio) { this.recheio = recheio; }
    public void setBorda(String borda)     { this.borda = borda; }
    public void setMolho(String molho)     { this.molho = molho; }
}