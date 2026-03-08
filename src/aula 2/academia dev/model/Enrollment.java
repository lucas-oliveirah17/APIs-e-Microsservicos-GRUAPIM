package br.com.academiadev.model;

public class Enrollment {

    private Student student;
    private Course course;
    private double progress;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.progress = 0.0;
    }

    public Student getStudent() { return student; }
    public Course getCourse()   { return course; }
    public double getProgress() { return progress; }

    public void setProgress(double progress) {
        if (progress < 0 || progress > 100)
            throw new IllegalArgumentException("Progresso deve estar entre 0 e 100.");
        this.progress = progress;
    }

    @Override
    public String toString() {
        return String.format("%s → %.0f%%", course.getTitle(), progress);
    }
}
