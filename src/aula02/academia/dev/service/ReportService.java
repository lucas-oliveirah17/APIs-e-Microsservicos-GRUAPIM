package aula02.academia.dev.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import aula02.academia.dev.model.Course;
import aula02.academia.dev.model.CourseStatus;
import aula02.academia.dev.model.DifficultyLevel;
import aula02.academia.dev.model.Enrollment;
import aula02.academia.dev.model.Student;
import aula02.academia.dev.repository.Database;

/**
 * Serviço de relatórios — todos implementados com Stream API e Lambdas.
 */
public class ReportService {
	/**
     * RF5.1 — Cursos por nível de dificuldade, ordenados alfabeticamente.
     */
    public static List<Course> coursesByDifficulty(DifficultyLevel level) {
        return Database.courses.values().stream()
                .filter(c -> c.getDifficultyLevel() == level)
                .sorted(Comparator.comparing(Course::getTitle))
                .collect(Collectors.toList());
    }

    /**
     * RF5.2 — Instrutores únicos de cursos ACTIVE (usando Set).
     */
    public static Set<String> activeInstructors() {
        return Database.courses.values().stream()
                .filter(c -> c.getStatus() == CourseStatus.ACTIVE)
                .map(Course::getInstructorName)
                .collect(Collectors.toCollection(TreeSet::new)); // TreeSet = Set ordenado
    }

    /**
     * RF5.3 — Alunos agrupados por plano de assinatura.
     */
    public static Map<String, List<Student>> studentsByPlan() {
        return Database.users.values().stream()
                .filter(u -> u instanceof Student)
                .map(u -> (Student) u)
                .collect(Collectors.groupingBy(s -> s.getPlan().getPlanName()));
    }

    /**
     * RF5.4 — Média geral de progresso de todas as matrículas.
     */
    public static double averageProgress() {
        return Database.enrollments.stream()
                .mapToDouble(Enrollment::getProgress)
                .average()
                .orElse(0.0);
    }

    /**
     * RF5.5 — Aluno com maior número de matrículas ativas. Retorna Optional<Student>.
     */
    public static Optional<Student> topStudentByEnrollments() {
        return Database.enrollments.stream()
                .collect(Collectors.groupingBy(Enrollment::getStudent, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}
