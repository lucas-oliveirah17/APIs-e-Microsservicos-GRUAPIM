package aula01.vcriquinho;

import java.util.Scanner;

/**
 * Responsável por exibir todos os menus e coletar entradas do usuário
 * no sistema VcRiquinho. Não contém lógica de negócio.
 */
public class MenuVcRiquinho {

    private Scanner sc;

    public MenuVcRiquinho(Scanner sc) {
        this.sc = sc;
    }

    // ── Menus principais ───────────────────────────────────────────────────

    public void exibirMenuPrincipal() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║     VCRIQUINHO — SISTEMA DE GESTÃO       ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  CLIENTES                                ║");
        System.out.println("║   1. Cadastrar cliente PF                ║");
        System.out.println("║   2. Cadastrar cliente PJ                ║");
        System.out.println("║   3. Listar clientes                     ║");
        System.out.println("║   4. Atualizar cliente                   ║");
        System.out.println("║   5. Remover cliente                     ║");
        System.out.println("║   6. Adicionar conta a cliente           ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  PRODUTOS                                ║");
        System.out.println("║   7. Cadastrar produto Renda Fixa        ║");
        System.out.println("║   8. Cadastrar produto Renda Variável    ║");
        System.out.println("║   9. Listar produtos                     ║");
        System.out.println("║  10. Atualizar produto                   ║");
        System.out.println("║  11. Remover produto                     ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  SIMULAÇÃO                               ║");
        System.out.println("║  12. Simular rendimento de cliente       ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║   0. Sair                                ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.print("Opção: ");
    }

    public void exibirMenuTipoConta() {
        System.out.println("Tipo de conta:");
        System.out.println("  1. Conta Corrente");
        System.out.println("  2. Conta CDI");
        System.out.println("  3. Conta Investimento Automático");
        System.out.print("Tipo: ");
    }

    // ── Coleta — Cliente ───────────────────────────────────────────────────

    public String lerNome()          { System.out.print("Nome: ");              return EntradaUtil.lerString(sc); }
    public String lerNomeRazao()     { System.out.print("Nome/Razão Social: "); return EntradaUtil.lerString(sc); }
    public String lerCpf()           { System.out.print("CPF: ");               return EntradaUtil.lerString(sc); }
    public String lerCnpj()          { System.out.print("CNPJ: ");              return EntradaUtil.lerString(sc); }
    public String lerEmail()         { System.out.print("E-mail: ");            return EntradaUtil.lerString(sc); }
    public String lerNovoNome()      { System.out.print("Novo nome: ");         return EntradaUtil.lerString(sc); }
    public String lerNovoEmail()     { System.out.print("Novo e-mail: ");       return EntradaUtil.lerString(sc); }

    public int lerIdCliente()        { System.out.print("ID do cliente: ");                 return EntradaUtil.lerInt(sc); }
    public int lerIdClienteAtualizar(){ System.out.print("ID do cliente a atualizar: ");    return EntradaUtil.lerInt(sc); }
    public int lerIdClienteRemover() { System.out.print("ID do cliente a remover: ");       return EntradaUtil.lerInt(sc); }
    public int lerIdClienteSimular() { System.out.print("ID do cliente para simular: ");    return EntradaUtil.lerInt(sc); }

    // ── Coleta — Conta ─────────────────────────────────────────────────────

    public int lerTipoConta()        { return EntradaUtil.lerInt(sc); }

    public double lerSaldoInicial() {
        System.out.print("Saldo inicial: R$ ");
        return EntradaUtil.lerDouble(sc);
    }

    public boolean lerVincularProdutos() {
        System.out.print("Deseja vincular produtos a esta conta? (s/n): ");
        return EntradaUtil.lerString(sc).equalsIgnoreCase("s");
    }

    public String lerIdsProdutos() {
        System.out.print("IDs dos produtos separados por vírgula (ex: 1,3): ");
        return EntradaUtil.lerString(sc);
    }

    // ── Coleta — Produto ───────────────────────────────────────────────────

    public String lerNomeProduto()        { System.out.print("Nome: ");                                  return EntradaUtil.lerString(sc); }
    public String lerDescricao()          { System.out.print("Descrição: ");                             return EntradaUtil.lerString(sc); }
    public String lerNovaDescricao()      { System.out.print("Nova descrição: ");                        return EntradaUtil.lerString(sc); }
    public String lerNovaNomeProduto()    { System.out.print("Novo nome: ");                             return EntradaUtil.lerString(sc); }

    public double lerRendimentoMensal() {
        System.out.print("Rendimento mensal % (ex: 1.2): ");
        return EntradaUtil.lerDouble(sc) / 100.0;
    }

    public double lerRendimentoVariavel() {
        System.out.print("Rendimento mensal esperado % (ex: 2.0): ");
        return EntradaUtil.lerDouble(sc) / 100.0;
    }

    public double lerNovoRendimento() {
        System.out.print("Novo rendimento mensal % (ex: 1.5): ");
        return EntradaUtil.lerDouble(sc) / 100.0;
    }

    public int lerCarencia()              { System.out.print("Carência em dias: ");       return EntradaUtil.lerInt(sc); }
    public int lerIdProdutoAtualizar()    { System.out.print("ID do produto a atualizar: "); return EntradaUtil.lerInt(sc); }
    public int lerIdProdutoRemover()      { System.out.print("ID do produto a remover: ");   return EntradaUtil.lerInt(sc); }

    // ── Coleta — Simulação ─────────────────────────────────────────────────

    public int lerPeriodoSimulacao() {
        System.out.println("Período (30 / 60 / 90 / 180 dias): ");
        return EntradaUtil.lerInt(sc);
    }

    // ── Geral ──────────────────────────────────────────────────────────────

    public int lerOpcaoMenu()            { return EntradaUtil.lerInt(sc); }

    // ── Mensagens de feedback ──────────────────────────────────────────────

    public void mensagemClienteNaoEncontrado() { System.out.println("Cliente não encontrado."); }
    public void mensagemContaInvalida()        { System.out.println("Tipo de conta inválido."); }
    public void mensagemContaAdicionada()      { System.out.println("Conta adicionada com sucesso."); }
    public void mensagemPrimeiraConta()        { System.out.println("Adicione a primeira conta obrigatória:"); }
    public void mensagemEncerrar()             { System.out.println("Encerrando VcRiquinho. Até logo!"); }
    public void mensagemOpcaoInvalida()        { System.out.println("Opção inválida."); }
}
