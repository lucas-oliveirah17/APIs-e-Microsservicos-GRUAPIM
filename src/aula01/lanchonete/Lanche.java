package aula01.lanchonete;

import java.time.LocalDate;

/**
 * Representa um lanche do cardápio.
 * Herda de Prato e adiciona: tipo de pão, recheio e molho (todos obrigatórios).
 */
public class Lanche extends Prato {
    private String tipoPao;  // ex: "brioche", "integral", "francês"
    private String recheio;  // ex: "frango", "carne", "vegetariano"
    private String molho;    // ex: "maionese", "mostarda", "ketchup"

    public Lanche(double precoVenda, LocalDate dataValidade, double peso,
                  String tipoPao, String recheio, String molho) {
        super(precoVenda, dataValidade, peso);
        this.tipoPao = tipoPao;
        this.recheio = recheio;
        this.molho   = molho;
    }

    @Override
    public String descricaoDetalhada() {
        return String.format("Lanche | Pão: %s | Recheio: %s | Molho: %s", tipoPao, recheio, molho);
    }

    // Getters e Setters
    public String getTipoPao()  { return tipoPao; }
    public String getRecheio()  { return recheio; }
    public String getMolho()    { return molho; }

    public void setTipoPao(String tipoPao) { this.tipoPao = tipoPao; }
    public void setRecheio(String recheio) { this.recheio = recheio; }
    public void setMolho(String molho)     { this.molho = molho; }
}