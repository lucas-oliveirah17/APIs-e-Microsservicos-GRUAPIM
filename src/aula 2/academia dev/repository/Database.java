package br.com.academiadev.repository;

import br.com.academiadev.model.*;
import java.util.*;

public class Database {

    public static final Map<String, Course>       courses     = new LinkedHashMap<>();
    public static final Map<String, User>         users       = new LinkedHashMap<>();
    public static final List<Enrollment>          enrollments = new ArrayList<>();
    public static final Queue<SupportTicket>      ticketQueue = new LinkedList<>();

    public static void init() {
        // --- Usuários ---
        users.put("admin@dev.com",   new Admin("Chefe Admin",      "admin@dev.com"));
        users.put("aluno1@dev.com",  new Student("Ana Basic",      "aluno1@dev.com", new BasicPlan()));
        users.put("aluno2@dev.com",  new Student("Bruno Premium",  "aluno2@dev.com", new PremiumPlan()));
        users.put("aluno3@dev.com",  new Student("Carlos Basic",   "aluno3@dev.com", new BasicPlan()));

        // --- Cursos ---
        courses.put("Java 101",       new Course("Java 101",       "Fundamentos de Java",           "Nélio Alves",     40,  DifficultyLevel.BEGINNER,     CourseStatus.ACTIVE));
        courses.put("Spring Expert",  new Course("Spring Expert",  "Spring Boot do zero ao deploy", "Giuliana Silva",  60,  DifficultyLevel.ADVANCED,     CourseStatus.ACTIVE));
        courses.put("Python Básico",  new Course("Python Básico",  "Introdução ao Python",          "Nélio Alves",     30,  DifficultyLevel.BEGINNER,     CourseStatus.ACTIVE));
        courses.put("React Native",   new Course("React Native",   "Apps mobile com React Native",  "Fernanda Costa",  50,  DifficultyLevel.INTERMEDIATE, CourseStatus.ACTIVE));
        courses.put("SQL Avançado",   new Course("SQL Avançado",   "Queries complexas e tuning",    "Giuliana Silva",  35,  DifficultyLevel.ADVANCED,     CourseStatus.INACTIVE));
        courses.put("Algoritmos",     new Course("Algoritmos",     "Estruturas de dados e busca",   "Rafael Matos",    45,  DifficultyLevel.INTERMEDIATE, CourseStatus.ACTIVE));

        // --- Matrículas iniciais de exemplo ---
        Student ana    = (Student) users.get("aluno1@dev.com");
        Student bruno  = (Student) users.get("aluno2@dev.com");

        Enrollment e1 = new Enrollment(ana,   courses.get("Java 101"));      e1.setProgress(75); enrollments.add(e1);
        Enrollment e2 = new Enrollment(ana,   courses.get("Python Básico")); e2.setProgress(30); enrollments.add(e2);
        Enrollment e3 = new Enrollment(bruno, courses.get("Spring Expert")); e3.setProgress(50); enrollments.add(e3);
        Enrollment e4 = new Enrollment(bruno, courses.get("Algoritmos"));    e4.setProgress(10); enrollments.add(e4);
    }
}
