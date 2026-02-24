package aula01.vcriquinho;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstrata base para clientes da VcRiquinho.
 * Todo cliente possui nome, e-mail e pelo menos uma conta.
 */
public abstract class Cliente {
    private static int contadorId = 1;

    private int id;
    private String nome;
    private String email;
    private List<Conta> contas;

    public Cliente(String nome, String email) {
        this.id     = contadorId++;
        this.nome   = nome;
        this.email  = email;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public boolean removerConta(int idConta) {
        if (contas.size() <= 1) {
            System.out.println("Erro: o cliente deve ter pelo menos uma conta.");
            return false;
        }
        return contas.removeIf(c -> c.getId() == idConta);
    }

    public Conta buscarConta(int idConta) {
        return contas.stream().filter(c -> c.getId() == idConta).findFirst().orElse(null);
    }

    public abstract String getDocumento(); // CPF ou CNPJ
    public abstract String getTipoCliente();

    // Getters e Setters
    public int getId()              { return id; }
    public String getNome()         { return nome; }
    public String getEmail()        { return email; }
    public List<Conta> getContas()  { return contas; }

    public void setNome(String nome)    { this.nome = nome; }
    public void setEmail(String email)  { this.email = email; }

    public void exibirDetalhes() {
        System.out.printf("  [%s ID:%d] Nome: %-25s | %s | Email: %s%n",
                getTipoCliente(), id, nome, getDocumento(), email);
        for (Conta c : contas) {
            System.out.println("    " + c);
        }
    }

    @Override
    public String toString() {
        return String.format("[%s ID:%d] %s | %s | Contas: %d", getTipoCliente(), id, nome, getDocumento(), contas.size());
    }
}

// ─── Pessoa Física ────────────────────────────────────────────────────────────
class ClientePF extends Cliente {
    private String cpf;

    public ClientePF(String nome, String cpf, String email) {
        super(nome, email);
        this.cpf = cpf;
    }

    @Override public String getDocumento()    { return "CPF: " + cpf; }
    @Override public String getTipoCliente()  { return "PF"; }

    public String getCpf()              { return cpf; }
    public void setCpf(String cpf)      { this.cpf = cpf; }
}

// ─── Pessoa Jurídica ─────────────────────────────────────────────────────────
class ClientePJ extends Cliente {
    private String cnpj;

    public ClientePJ(String nome, String cnpj, String email) {
        super(nome, email);
        this.cnpj = cnpj;
    }

    @Override public String getDocumento()    { return "CNPJ: " + cnpj; }
    @Override public String getTipoCliente()  { return "PJ"; }

    public String getCnpj()             { return cnpj; }
    public void setCnpj(String cnpj)    { this.cnpj = cnpj; }
}