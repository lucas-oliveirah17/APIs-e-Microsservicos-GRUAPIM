package aula02.academia.dev.model;

public class BasicPlan implements SubscriptionPlan {
	private static final int MAX_COURSES = 3;

    @Override
    public int getMaxCourses() {
        return MAX_COURSES;
    }

    @Override
    public String getPlanName() {
        return "BASIC";
    }

    @Override
    public String toString() {
        return "BasicPlan (máx. " + MAX_COURSES + " cursos)";
    }
}
