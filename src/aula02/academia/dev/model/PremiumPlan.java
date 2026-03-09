package aula02.academia.dev.model;

public class PremiumPlan implements SubscriptionPlan {
	@Override
    public int getMaxCourses() {
        return Integer.MAX_VALUE;
    }

    @Override
    public String getPlanName() {
        return "PREMIUM";
    }

    @Override
    public String toString() {
        return "PremiumPlan (cursos ilimitados)";
    }
}
