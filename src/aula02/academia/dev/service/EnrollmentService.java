package aula02.academia.dev.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import aula02.academia.dev.exception.EnrollmentException;
import aula02.academia.dev.model.Course;
import aula02.academia.dev.model.CourseStatus;
import aula02.academia.dev.model.Enrollment;
import aula02.academia.dev.model.Student;
import aula02.academia.dev.repository.Database;

/**
 * Serviço de matrículas — centraliza toda a lógica de negócio de Enrollment.
 * Princípio de Responsabilidade Única: separado da camada de UI.
 */
public class EnrollmentService {
	/**
     * Matricula um aluno em um curso respeitando todas as regras de negócio.
     */
    public static void enroll(Student student, Course course) throws EnrollmentException {
        if (course.getStatus() == CourseStatus.INACTIVE)
            throw new EnrollmentException("Curso '" + course.getTitle() + "' está INATIVO e não aceita matrículas.");

        boolean jaMatriculado = Database.enrollments.stream()
                .anyMatch(e -> e.getStudent().equals(student) && e.getCourse().equals(course));
        if (jaMatriculado)
            throw new EnrollmentException("Você já está matriculado em '" + course.getTitle() + "'.");

        long ativos = Database.enrollments.stream()
                .filter(e -> e.getStudent().equals(student))
                .count();
        if (ativos >= student.getPlan().getMaxCourses())
            throw new EnrollmentException("Limite do plano " + student.getPlan().getPlanName()
                    + " atingido (" + student.getPlan().getMaxCourses() + " cursos).");

        Database.enrollments.add(new Enrollment(student, course));
    }

    /**
     * Cancela a matrícula de um aluno em um curso.
     */
    public static void cancel(Student student, Course course) throws EnrollmentException {
        Optional<Enrollment> enrollment = Database.enrollments.stream()
                .filter(e -> e.getStudent().equals(student) && e.getCourse().equals(course))
                .findFirst();

        if (enrollment.isEmpty())
            throw new EnrollmentException("Você não está matriculado em '" + course.getTitle() + "'.");

        Database.enrollments.remove(enrollment.get());
    }

    /**
     * Atualiza o progresso de um aluno em um curso.
     */
    public static void updateProgress(Student student, Course course, double progress) throws EnrollmentException {
        Optional<Enrollment> enrollment = Database.enrollments.stream()
                .filter(e -> e.getStudent().equals(student) && e.getCourse().equals(course))
                .findFirst();

        if (enrollment.isEmpty()) {
            throw new EnrollmentException("Matrícula não encontrada.");
        }
        
        enrollment.get().setProgress(progress);
    }

    /**
     * Retorna todas as matrículas de um aluno.
     */
    public static List<Enrollment> getEnrollmentsOf(Student student) {
        return Database.enrollments.stream()
                .filter(e -> e.getStudent().equals(student))
                .collect(Collectors.toList());
    }
}
