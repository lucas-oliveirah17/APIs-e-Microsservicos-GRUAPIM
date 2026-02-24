package aula01.lanchonete;

import java.time.LocalDate;

/**
 * Representa um salgadinho do cardápio.
 * Herda de Prato e adiciona: tipo (frito/assado), massa e recheio.
 */
public class Salgadinho extends Prato {
    private String tipo;    // "frito" ou "assado"
    private String massa;   // ex: "massa folhada", "massa de pastel", "massa de coxinha"
    private String recheio; // ex: "frango", "carne", "queijo"

    public Salgadinho(double precoVenda, LocalDate dataValidade, double peso,
                      String tipo, String massa, String recheio) {
        super(precoVenda, dataValidade, peso);
        if (!tipo.equalsIgnoreCase("frito") && !tipo.equalsIgnoreCase("assado")) {
            throw new IllegalArgumentException("Tipo deve ser 'frito' ou 'assado'. Recebido: " + tipo);
        }
        this.tipo    = tipo;
        this.massa   = massa;
        this.recheio = recheio;
    }

    @Override
    public String descricaoDetalhada() {
        return String.format("Salgadinho | Tipo: %s | Massa: %s | Recheio: %s", tipo, massa, recheio);
    }

    // Getters e Setters
    public String getTipo()    { return tipo; }
    public String getMassa()   { return massa; }
    public String getRecheio() { return recheio; }

    public void setTipo(String tipo)       { this.tipo = tipo; }
    public void setMassa(String massa)     { this.massa = massa; }
    public void setRecheio(String recheio) { this.recheio = recheio; }
}