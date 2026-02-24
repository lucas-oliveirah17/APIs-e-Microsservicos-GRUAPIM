package aula01.vcriquinho;

/**
 * Classe principal para testar o protótipo do sistema VcRiquinho.
 * Demonstra: CRUD de clientes e produtos, tipos de conta, simulações.
 */
public class MainVcRiquinho {
    public static void main(String[] args) {

        // ── Repositórios ──────────────────────────────────────────────────────
        ClienteRepositorio clienteRepo  = new ClienteRepositorio();
        ProdutoRepositorio produtoRepo  = new ProdutoRepositorio();
        SimulacaoService   simulacao    = new SimulacaoService();

        // ── CRUD de Produtos ──────────────────────────────────────────────────
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║         CRUD DE PRODUTOS FINANCEIROS         ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        ProdutoRendaFixa   cdb     = new ProdutoRendaFixa("CDB 120%", "CDB atrelado ao CDI", 0.012, 90);
        ProdutoRendaFixa   lci     = new ProdutoRendaFixa("LCI Premium", "Letra de Crédito Imobiliário", 0.010, 60);
        ProdutoRendaVariavel fundo = new ProdutoRendaVariavel("Fundo Multimercado A", "Fundo com histórico sólido", 0.018);
        ProdutoRendaVariavel acao  = new ProdutoRendaVariavel("Ações IBOV", "Carteira indexada ao Ibovespa", 0.022);

        produtoRepo.adicionar(cdb);
        produtoRepo.adicionar(lci);
        produtoRepo.adicionar(fundo);
        produtoRepo.adicionar(acao);

        System.out.println();
        produtoRepo.listar();

        // Update de produto
        System.out.println("\n--- Atualizando produto ID 1 ---");
        produtoRepo.atualizar(1, "CDB 130%", "CDB aprimorado", 0.013);

        // Remove de produto
        System.out.println("\n--- Removendo produto ID 4 ---");
        produtoRepo.remover(4);
        produtoRepo.listar();

        // ── CRUD de Clientes ──────────────────────────────────────────────────
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║            CRUD DE CLIENTES                  ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        // Cliente PF com ContaCDI
        ContaCDI contaCdiAna = new ContaCDI(50000.00);

        ClientePF ana = new ClientePF("Ana Souza", "123.456.789-00", "ana@email.com");
        ana.adicionarConta(contaCdiAna);
        clienteRepo.adicionar(ana);

        // Cliente PJ com ContaCorrente + Investimento Automático
        ContaCorrente ccEmpresa    = new ContaCorrente(200000.00);
        ContaInvestimentoAutomatico invEmpresa = new ContaInvestimentoAutomatico(500000.00, true);
        invEmpresa.adicionarProduto(cdb);
        invEmpresa.adicionarProduto(fundo);

        ClientePJ empresa = new ClientePJ("Tech Corp Ltda", "12.345.678/0001-90", "contato@techcorp.com");
        empresa.adicionarConta(ccEmpresa);
        empresa.adicionarConta(invEmpresa);
        clienteRepo.adicionar(empresa);

        // Cliente PF com Investimento Automático (PF)
        ContaInvestimentoAutomatico invCarlos = new ContaInvestimentoAutomatico(30000.00, false);
        invCarlos.adicionarProduto(lci);  // em carência para períodos < 60 dias
        invCarlos.adicionarProduto(fundo);

        ClientePF carlos = new ClientePF("Carlos Lima", "987.654.321-00", "carlos@email.com");
        carlos.adicionarConta(invCarlos);
        clienteRepo.adicionar(carlos);

        System.out.println();
        clienteRepo.listarComDetalhes();

        // Update de cliente
        System.out.println("\n--- Atualizando cliente ID 1 ---");
        clienteRepo.atualizar(1, "Ana Souza Silva", "anasilva@email.com");

        // ── Simulações de Rendimento ──────────────────────────────────────────
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║          SIMULAÇÕES DE RENDIMENTO            ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        // Ana — CDI — 30 dias
        simulacao.simular(ana, 30);

        // Empresa — Corrente + Investimento PJ — 90 dias
        simulacao.simular(empresa, 90);

        // Carlos — Investimento PF — 30 dias (LCI em carência!)
        System.out.println("\n[Simulação de 30 dias para Carlos — LCI estará em carência]");
        simulacao.simular(carlos, 30);

        // Carlos — 90 dias (LCI fora da carência)
        System.out.println("\n[Simulação de 90 dias para Carlos — LCI fora de carência]");
        simulacao.simular(carlos, 90);

        // ── Período inválido ──────────────────────────────────────────────────
        System.out.println("\n--- Testando período inválido ---");
        simulacao.simular(ana, 45);

        // ── Remoção de cliente ────────────────────────────────────────────────
        System.out.println("\n--- Removendo cliente ID 3 ---");
        clienteRepo.remover(3);
        clienteRepo.listarComDetalhes();
    }
}