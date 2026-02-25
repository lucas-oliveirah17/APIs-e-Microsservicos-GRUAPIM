package aula01.bloco7.exercicio05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Agrupando Alunos por Nota: Tendo uma List<Aluno> (onde Aluno tem nome e nota), crie um Map<String, List<Aluno>> 
 * que agrupe os alunos por faixa de nota: “Aprovados” (nota >= 7), “Recuperação” (nota >= 5 e < 7) e “Reprovados” 
 * (nota < 5).
 * */

public class MainB7E5 {
	public static Map<String, List<Aluno>> agruparPorFaixa(List<Aluno> alunos) {
        Map<String, List<Aluno>> grupos = new HashMap<>();
        grupos.put("Aprovados",    new ArrayList<>());
        grupos.put("Recuperação",  new ArrayList<>());
        grupos.put("Reprovados",   new ArrayList<>());

        for (Aluno aluno : alunos) {
            if (aluno.getNota() >= 7) {
                grupos.get("Aprovados").add(aluno);
            } else if (aluno.getNota() >= 5) {
                grupos.get("Recuperação").add(aluno);
            } else {
                grupos.get("Reprovados").add(aluno);
            }
        }

        return grupos;
    }

    public static void main(String[] args) {
        List<Aluno> turma = new ArrayList<>();
        turma.add(new Aluno("Alice",    9.0));
        turma.add(new Aluno("Bruno",    4.5));
        turma.add(new Aluno("Carla",    7.0));
        turma.add(new Aluno("Diego",    5.5));
        turma.add(new Aluno("Elisa",    8.5));
        turma.add(new Aluno("Fabio",    3.0));
        turma.add(new Aluno("Gabriela", 6.0));
        turma.add(new Aluno("Henrique", 7.8));
        turma.add(new Aluno("Isabela",  4.9));
        turma.add(new Aluno("João",     5.0));

        Map<String, List<Aluno>> resultado = agruparPorFaixa(turma);

        String[] ordem = {"Aprovados", "Recuperação", "Reprovados"};

        System.out.println("=== Resultado da Turma ===");
        for (String faixa : ordem) {
            List<Aluno> grupo = resultado.get(faixa);
            System.out.println("\n" + faixa + " (" + grupo.size() + "):");
            if (grupo.isEmpty()) {
                System.out.println("  Nenhum aluno nesta faixa.");
            } else {
                for (Aluno a : grupo) {
                    System.out.println("  • " + a);
                }
            }
        }
    }
}
