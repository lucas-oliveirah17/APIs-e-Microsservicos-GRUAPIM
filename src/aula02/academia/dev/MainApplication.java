package aula02.academia.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import aula02.academia.dev.exception.EnrollmentException;
import aula02.academia.dev.model.Admin;
import aula02.academia.dev.model.BasicPlan;
import aula02.academia.dev.model.Course;
import aula02.academia.dev.model.CourseStatus;
import aula02.academia.dev.model.DifficultyLevel;
import aula02.academia.dev.model.Enrollment;
import aula02.academia.dev.model.PremiumPlan;
import aula02.academia.dev.model.Student;
import aula02.academia.dev.model.SupportTicket;
import aula02.academia.dev.model.User;
import aula02.academia.dev.repository.Database;
import aula02.academia.dev.service.EnrollmentService;
import aula02.academia.dev.service.ReportService;
import aula02.academia.dev.util.GenericCsvExporter;

public class MainApplication {
	private static final Scanner sc = new Scanner(System.in);
    private static User currentUser;

    // ─────────────────────────────────────────────────────────────────────────
    // ENTRY POINT
    // ─────────────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        Database.init();
        printBanner();
        login();

        while (true) {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("  Logado como: " + currentUser.getName()
                    + " [" + (currentUser instanceof Admin ? "ADMIN" : "ALUNO") + "]");
            System.out.println("══════════════════════════════════════════");
            if (currentUser instanceof Admin) {
                adminMenu();
            } else {
                studentMenu();
            }
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // LOGIN
    // ─────────────────────────────────────────────────────────────────────────
    private static void login() {
        while (currentUser == null) {
            System.out.print("\nInforme seu e-mail para login: ");
            String email = sc.nextLine().trim();
            currentUser = Database.users.get(email);
            if (currentUser == null) {
                System.out.println("  ✗ Usuário não encontrado. Tente novamente.");
                System.out.println("  Dica — usuários disponíveis: " + Database.users.keySet());
            } else {
                System.out.println("  ✓ Bem-vindo(a), " + currentUser.getName() + "!");
            }
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // MENU ADMIN
    // ─────────────────────────────────────────────────────────────────────────
    private static void adminMenu() {
        System.out.println("\n  1. Gerenciar Status de Curso");
        System.out.println("  2. Alterar Plano de Aluno");
        System.out.println("  3. Atender Ticket de Suporte");
        System.out.println("  4. Relatórios e Análises");
        System.out.println("  5. Exportar Dados em CSV");
        System.out.println("  6. Consultar Catálogo de Cursos");
        System.out.println("  7. Abrir Ticket de Suporte");
        System.out.println("  0. Sair");
        System.out.print("  Opção: ");

        switch (readInt()) {
            case 1 -> gerenciarStatusCurso();
            case 2 -> alterarPlanoAluno();
            case 3 -> atenderTicket();
            case 4 -> menuRelatorios();
            case 5 -> exportarCSV();
            case 6 -> listarCursosAtivos();
            case 7 -> abrirTicket();
            case 0 -> sair();
            default -> System.out.println("  Opção inválida.");
        }
    }

    private static void gerenciarStatusCurso() {
        System.out.println("\n  --- Cursos ---");
        Database.courses.values().forEach(c ->
                System.out.println("  - " + c.getTitle() + " [" + c.getStatus() + "]"));
        System.out.print("  Título do curso para alternar status: ");
        String titulo = sc.nextLine().trim();
        Course curso = Database.courses.get(titulo);
        if (curso == null) { System.out.println("  ✗ Curso não encontrado."); return; }
        CourseStatus novoStatus = curso.getStatus() == CourseStatus.ACTIVE
                ? CourseStatus.INACTIVE : CourseStatus.ACTIVE;
        curso.setStatus(novoStatus);
        System.out.println("  ✓ Status atualizado para: " + novoStatus);
    }

    private static void alterarPlanoAluno() {
        List<Student> alunos = Database.users.values().stream()
                .filter(u -> u instanceof Student).map(u -> (Student) u)
                .collect(Collectors.toList());
        if (alunos.isEmpty()) { System.out.println("  Nenhum aluno cadastrado."); return; }

        System.out.println("\n  --- Alunos ---");
        alunos.forEach(a -> System.out.println("  - " + a.getEmail() + " → " + a.getPlan().getPlanName()));
        System.out.print("  E-mail do aluno: ");
        String email = sc.nextLine().trim();
        User u = Database.users.get(email);
        if (!(u instanceof Student)) { System.out.println("  ✗ Aluno não encontrado."); return; }
        Student aluno = (Student) u;

        System.out.println("  Planos disponíveis: 1. BASIC  2. PREMIUM");
        System.out.print("  Escolha: ");
        int opcao = readInt();
        if (opcao == 1) {
            aluno.setPlan(new BasicPlan());
            System.out.println("  ✓ Plano alterado para BASIC.");
        } else if (opcao == 2) {
            aluno.setPlan(new PremiumPlan());
            System.out.println("  ✓ Plano alterado para PREMIUM.");
        } else {
            System.out.println("  Opção inválida.");
        }
    }

    private static void atenderTicket() {
        SupportTicket ticket = Database.ticketQueue.poll();
        if (ticket == null) {
            System.out.println("  ✓ Fila de suporte vazia — nenhum ticket pendente.");
        } else {
            System.out.println("\n  ════ PROCESSANDO TICKET ════");
            System.out.println("  " + ticket);
            System.out.println("  ✓ Ticket atendido e removido da fila.");
            System.out.println("  Tickets restantes na fila: " + Database.ticketQueue.size());
        }
    }

    private static void menuRelatorios() {
        System.out.println("\n  --- Relatórios ---");
        System.out.println("  1. Cursos por Nível de Dificuldade");
        System.out.println("  2. Instrutores Únicos (cursos ATIVOS)");
        System.out.println("  3. Alunos por Plano de Assinatura");
        System.out.println("  4. Média Geral de Progresso");
        System.out.println("  5. Aluno com Mais Matrículas");
        System.out.println("  6. Todos os Relatórios");
        System.out.print("  Opção: ");

        switch (readInt()) {
            case 1 -> relatorioCursosPorNivel();
            case 2 -> relatorioInstrutoresUnicos();
            case 3 -> relatorioAlunosPorPlano();
            case 4 -> relatorioMediaProgresso();
            case 5 -> relatorioTopAluno();
            case 6 -> { relatorioCursosPorNivel(); relatorioInstrutoresUnicos();
                        relatorioAlunosPorPlano(); relatorioMediaProgresso(); relatorioTopAluno(); }
            default -> System.out.println("  Opção inválida.");
        }
    }

    private static void relatorioCursosPorNivel() {
        System.out.println("\n  === Cursos por Nível ===");
        for (DifficultyLevel nivel : DifficultyLevel.values()) {
            System.out.println("  [" + nivel + "]");
            List<Course> lista = ReportService.coursesByDifficulty(nivel);
            if (lista.isEmpty()) System.out.println("    (nenhum)");
            else lista.forEach(c -> System.out.println("    • " + c.getTitle()));
        }
    }

    private static void relatorioInstrutoresUnicos() {
        Set<String> instrutores = ReportService.activeInstructors();
        System.out.println("\n  === Instrutores Únicos (cursos ATIVOS) ===");
        instrutores.forEach(i -> System.out.println("  • " + i));
    }

    private static void relatorioAlunosPorPlano() {
        System.out.println("\n  === Alunos por Plano ===");
        ReportService.studentsByPlan().forEach((plano, alunos) -> {
            System.out.println("  [" + plano + "]");
            alunos.forEach(a -> System.out.println("    • " + a.getName() + " <" + a.getEmail() + ">"));
        });
    }

    private static void relatorioMediaProgresso() {
        double media = ReportService.averageProgress();
        System.out.printf("%n  === Média Geral de Progresso ===%n  %.1f%%%n", media);
    }

    private static void relatorioTopAluno() {
        System.out.println("\n  === Aluno com Mais Matrículas ===");
        ReportService.topStudentByEnrollments().ifPresentOrElse(
            s -> System.out.println("  " + s.getName() + " <" + s.getEmail() + ">"),
            ()  -> System.out.println("  (nenhum aluno matriculado)")
        );
    }

    private static void exportarCSV() {
        System.out.println("\n  Exportar: 1. Cursos   2. Alunos");
        System.out.print("  Opção: ");
        int tipo = readInt();

        if (tipo == 1) {
            System.out.println("  Campos disponíveis: title, description, instructorName, durationInHours, difficultyLevel, status");
            System.out.print("  Informe os campos separados por vírgula: ");
            List<String> campos = Arrays.asList(sc.nextLine().split(","));
            String csv = GenericCsvExporter.export(new ArrayList<>(Database.courses.values()), campos);
            System.out.println("\n" + csv);
        } else if (tipo == 2) {
            List<Student> alunos = Database.users.values().stream()
                    .filter(u -> u instanceof Student).map(u -> (Student) u)
                    .collect(Collectors.toList());
            System.out.println("  Campos disponíveis: name, email");
            System.out.print("  Informe os campos separados por vírgula: ");
            List<String> campos = Arrays.asList(sc.nextLine().split(","));
            System.out.println("\n" + GenericCsvExporter.export(alunos, campos));
        } else {
            System.out.println("  Opção inválida.");
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // MENU ALUNO
    // ─────────────────────────────────────────────────────────────────────────
    private static void studentMenu() {
        System.out.println("\n  1. Matricular-se em Curso");
        System.out.println("  2. Consultar Minhas Matrículas");
        System.out.println("  3. Atualizar Progresso em Curso");
        System.out.println("  4. Cancelar Matrícula");
        System.out.println("  5. Consultar Catálogo de Cursos");
        System.out.println("  6. Abrir Ticket de Suporte");
        System.out.println("  0. Sair");
        System.out.print("  Opção: ");

        Student aluno = (Student) currentUser;
        switch (readInt()) {
            case 1 -> matricular(aluno);
            case 2 -> consultarMatriculas(aluno);
            case 3 -> atualizarProgresso(aluno);
            case 4 -> cancelarMatricula(aluno);
            case 5 -> listarCursosAtivos();
            case 6 -> abrirTicket();
            case 0 -> sair();
            default -> System.out.println("  Opção inválida.");
        }
    }

    private static void matricular(Student aluno) {
        listarCursosAtivos();
        System.out.print("  Título do curso para matrícula: ");
        String titulo = sc.nextLine().trim();
        Course curso = Database.courses.get(titulo);
        if (curso == null) { System.out.println("  ✗ Curso não encontrado."); return; }
        try {
            EnrollmentService.enroll(aluno, curso);
            System.out.println("  ✓ Matriculado com sucesso em '" + curso.getTitle() + "'!");
        } catch (EnrollmentException e) {
            System.out.println("  ✗ Erro: " + e.getMessage());
        }
    }

    private static void consultarMatriculas(Student aluno) {
        List<Enrollment> lista = EnrollmentService.getEnrollmentsOf(aluno);
        System.out.println("\n  === Suas Matrículas ===");
        if (lista.isEmpty()) {
            System.out.println("  (nenhuma matrícula ativa)");
        } else {
            lista.forEach(e -> System.out.printf("  • %-25s %.0f%%%n",
                    e.getCourse().getTitle(), e.getProgress()));
        }
    }

    private static void atualizarProgresso(Student aluno) {
        consultarMatriculas(aluno);
        System.out.print("  Título do curso: ");
        Course curso = Database.courses.get(sc.nextLine().trim());
        if (curso == null) { System.out.println("  ✗ Curso não encontrado."); return; }
        System.out.print("  Novo progresso (0-100): ");
        try {
            double prog = Double.parseDouble(sc.nextLine().trim());
            EnrollmentService.updateProgress(aluno, curso, prog);
            System.out.println("  ✓ Progresso atualizado para " + prog + "%!");
        } catch (EnrollmentException | IllegalArgumentException e) {
            System.out.println("  ✗ Erro: " + e.getMessage());
        }
    }

    private static void cancelarMatricula(Student aluno) {
        consultarMatriculas(aluno);
        System.out.print("  Título do curso para cancelar: ");
        Course curso = Database.courses.get(sc.nextLine().trim());
        if (curso == null) { System.out.println("  ✗ Curso não encontrado."); return; }
        try {
            EnrollmentService.cancel(aluno, curso);
            System.out.println("  ✓ Matrícula em '" + curso.getTitle() + "' cancelada.");
        } catch (EnrollmentException e) {
            System.out.println("  ✗ Erro: " + e.getMessage());
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // OPERAÇÕES GERAIS
    // ─────────────────────────────────────────────────────────────────────────
    private static void listarCursosAtivos() {
        System.out.println("\n  === Cursos Disponíveis ===");
        Database.courses.values().stream()
                .filter(c -> c.getStatus() == CourseStatus.ACTIVE)
                .forEach(c -> System.out.printf("  • %-25s | %-14s | %dh | %s%n",
                        c.getTitle(), c.getDifficultyLevel(), c.getDurationInHours(), c.getInstructorName()));
    }

    private static void abrirTicket() {
        System.out.print("  Título do ticket: ");
        String titulo = sc.nextLine().trim();
        System.out.print("  Mensagem: ");
        String msg = sc.nextLine().trim();
        Database.ticketQueue.add(new SupportTicket(titulo, msg, currentUser));
        System.out.println("  ✓ Ticket enviado! Posição na fila: " + Database.ticketQueue.size());
    }

    // ─────────────────────────────────────────────────────────────────────────
    // UTILITÁRIOS
    // ─────────────────────────────────────────────────────────────────────────
    private static int readInt() {
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { return -1; }
    }

    private static void sair() {
        System.out.println("\n  Até logo, " + currentUser.getName() + "! 👋");
        System.exit(0);
    }

    private static void printBanner() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       BEM-VINDO À ACADEMIDEV         ║");
        System.out.println("║    Plataforma de Cursos Online       ║");
        System.out.println("╚══════════════════════════════════════╝");
    }
}
