package aula01.vcriquinho;

import java.util.Scanner;

/**
 * Ponto de entrada do sistema VcRiquinho.
 * Contém apenas o loop principal e a lógica de controle de fluxo.
 * Exibição de menus → MenuVcRiquinho | Leitura segura → EntradaUtil
 */
public class MainVcRiquinho {

    static ClienteRepositorio clienteRepo = new ClienteRepositorio();
    static ProdutoRepositorio  produtoRepo = new ProdutoRepositorio();
    static SimulacaoService    simulacao   = new SimulacaoService();

    public static void main(String[] args) {
        Scanner sc         = new Scanner(System.in);
        MenuVcRiquinho menu = new MenuVcRiquinho(sc);
        int opcao;

        do {
            menu.exibirMenuPrincipal();
            opcao = menu.lerOpcaoMenu();

            switch (opcao) {
                case 1  -> cadastrarClientePF(menu);
                case 2  -> cadastrarClientePJ(menu);
                case 3  -> clienteRepo.listarComDetalhes();
                case 4  -> atualizarCliente(menu);
                case 5  -> removerCliente(menu);
                case 6  -> adicionarContaACliente(menu);
                case 7  -> cadastrarRendaFixa(menu);
                case 8  -> cadastrarRendaVariavel(menu);
                case 9  -> produtoRepo.listar();
                case 10 -> atualizarProduto(menu);
                case 11 -> removerProduto(menu);
                case 12 -> simularRendimento(menu);
                case 0  -> menu.mensagemEncerrar();
                default -> menu.mensagemOpcaoInvalida();
            }
        } while (opcao != 0);

        sc.close();
    }

    // ── Clientes ───────────────────────────────────────────────────────────

    static void cadastrarClientePF(MenuVcRiquinho menu) {
        ClientePF cli = new ClientePF(menu.lerNome(), menu.lerCpf(), menu.lerEmail());
        adicionarPrimeiraContaObrigatoria(menu, cli);
        clienteRepo.adicionar(cli);
    }

    static void cadastrarClientePJ(MenuVcRiquinho menu) {
        ClientePJ cli = new ClientePJ(menu.lerNomeRazao(), menu.lerCnpj(), menu.lerEmail());
        adicionarPrimeiraContaObrigatoria(menu, cli);
        clienteRepo.adicionar(cli);
    }

    static void adicionarPrimeiraContaObrigatoria(MenuVcRiquinho menu, Cliente cli) {
        menu.mensagemPrimeiraConta();
        Conta c = criarConta(menu, cli instanceof ClientePJ);
        if (c != null) cli.adicionarConta(c);
    }

    static void adicionarContaACliente(MenuVcRiquinho menu) {
        clienteRepo.listarComDetalhes();
        Cliente cli = clienteRepo.buscarPorId(menu.lerIdCliente());
        if (cli == null) { menu.mensagemClienteNaoEncontrado(); return; }
        Conta c = criarConta(menu, cli instanceof ClientePJ);
        if (c != null) { cli.adicionarConta(c); menu.mensagemContaAdicionada(); }
    }

    static Conta criarConta(MenuVcRiquinho menu, boolean isPJ) {
        menu.exibirMenuTipoConta();
        int tipo   = menu.lerTipoConta();
        double saldo = menu.lerSaldoInicial();

        return switch (tipo) {
            case 1 -> new ContaCorrente(saldo);
            case 2 -> new ContaCDI(saldo);
            case 3 -> {
                ContaInvestimentoAutomatico cia = new ContaInvestimentoAutomatico(saldo, isPJ);
                if (menu.lerVincularProdutos()) vincularProdutos(menu, cia);
                yield cia;
            }
            default -> { menu.mensagemContaInvalida(); yield null; }
        };
    }

    static void vincularProdutos(MenuVcRiquinho menu, ContaInvestimentoAutomatico cia) {
        produtoRepo.listar();
        String[] ids = menu.lerIdsProdutos().split(",");
        for (String idStr : ids) {
            try {
                ProdutoFinanceiro p = produtoRepo.buscarPorId(Integer.parseInt(idStr.trim()));
                if (p != null) { cia.adicionarProduto(p); System.out.println("  Produto vinculado: " + p.getNome()); }
                else System.out.println("  Produto ID " + idStr.trim() + " não encontrado.");
            } catch (NumberFormatException e) {
                System.out.println("  ID inválido: " + idStr);
            }
        }
    }

    static void atualizarCliente(MenuVcRiquinho menu) {
        clienteRepo.listarComDetalhes();
        clienteRepo.atualizar(menu.lerIdClienteAtualizar(), menu.lerNovoNome(), menu.lerNovoEmail());
    }

    static void removerCliente(MenuVcRiquinho menu) {
        clienteRepo.listarComDetalhes();
        clienteRepo.remover(menu.lerIdClienteRemover());
    }

    // ── Produtos ───────────────────────────────────────────────────────────

    static void cadastrarRendaFixa(MenuVcRiquinho menu) {
        produtoRepo.adicionar(new ProdutoRendaFixa(
            menu.lerNomeProduto(), menu.lerDescricao(),
            menu.lerRendimentoMensal(), menu.lerCarencia()
        ));
    }

    static void cadastrarRendaVariavel(MenuVcRiquinho menu) {
        produtoRepo.adicionar(new ProdutoRendaVariavel(
            menu.lerNomeProduto(), menu.lerDescricao(), menu.lerRendimentoVariavel()
        ));
    }

    static void atualizarProduto(MenuVcRiquinho menu) {
        produtoRepo.listar();
        produtoRepo.atualizar(
            menu.lerIdProdutoAtualizar(),
            menu.lerNovaNomeProduto(), menu.lerNovaDescricao(), menu.lerNovoRendimento()
        );
    }

    static void removerProduto(MenuVcRiquinho menu) {
        produtoRepo.listar();
        produtoRepo.remover(menu.lerIdProdutoRemover());
    }

    // ── Simulação ──────────────────────────────────────────────────────────

    static void simularRendimento(MenuVcRiquinho menu) {
        clienteRepo.listarComDetalhes();
        Cliente cli = clienteRepo.buscarPorId(menu.lerIdClienteSimular());
        if (cli == null) { menu.mensagemClienteNaoEncontrado(); return; }
        simulacao.simular(cli, menu.lerPeriodoSimulacao());
    }
}
