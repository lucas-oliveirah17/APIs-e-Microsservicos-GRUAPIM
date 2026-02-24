package aula01.vcriquinho;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositório genérico em memória para CRUD de clientes.
 */
public class ClienteRepositorio {
    private List<Cliente> clientes = new ArrayList<>();

    // CREATE
    public void adicionar(Cliente cliente) {
        if (cliente.getContas().isEmpty()) {
            throw new IllegalArgumentException("Cliente deve ter pelo menos uma conta cadastrada.");
        }
        clientes.add(cliente);
        System.out.println("Cliente adicionado: " + cliente);
    }

    // READ — todos
    public List<Cliente> listarTodos() { return new ArrayList<>(clientes); }

    // READ — por ID
    public Cliente buscarPorId(int id) {
        return clientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // UPDATE — atualiza nome e e-mail
    public boolean atualizar(int id, String novoNome, String novoEmail) {
        Cliente c = buscarPorId(id);
        if (c == null) { System.out.println("Cliente ID " + id + " não encontrado."); return false; }
        c.setNome(novoNome);
        c.setEmail(novoEmail);
        System.out.println("Cliente atualizado: " + c);
        return true;
    }

    // DELETE
    public boolean remover(int id) {
        boolean removido = clientes.removeIf(c -> c.getId() == id);
        if (removido) System.out.println("Cliente ID " + id + " removido.");
        else System.out.println("Cliente ID " + id + " não encontrado.");
        return removido;
    }

    public void listarComDetalhes() {
        if (clientes.isEmpty()) { System.out.println("Nenhum cliente cadastrado."); return; }
        System.out.println("=== Clientes Cadastrados ===");
        for (Cliente c : clientes) c.exibirDetalhes();
    }
}

// ─── Repositório de Produtos ──────────────────────────────────────────────────
class ProdutoRepositorio {
    private List<ProdutoFinanceiro> produtos = new ArrayList<>();

    public void adicionar(ProdutoFinanceiro produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado: " + produto);
    }

    public List<ProdutoFinanceiro> listarTodos() { return new ArrayList<>(produtos); }

    public ProdutoFinanceiro buscarPorId(int id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public boolean atualizar(int id, String novoNome, String novaDescricao, double novoRendimento) {
        ProdutoFinanceiro p = buscarPorId(id);
        if (p == null) { System.out.println("Produto ID " + id + " não encontrado."); return false; }
        p.setNome(novoNome);
        p.setDescricao(novaDescricao);
        p.setRendimentoMensal(novoRendimento);
        System.out.println("Produto atualizado: " + p);
        return true;
    }

    public boolean remover(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) System.out.println("Produto ID " + id + " removido.");
        else System.out.println("Produto ID " + id + " não encontrado.");
        return removido;
    }

    public void listar() {
        if (produtos.isEmpty()) { System.out.println("Nenhum produto cadastrado."); return; }
        System.out.println("=== Produtos de Investimento ===");
        produtos.forEach(p -> System.out.println("  " + p));
    }
}