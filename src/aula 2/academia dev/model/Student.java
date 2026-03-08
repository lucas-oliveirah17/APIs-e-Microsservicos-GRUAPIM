package br.com.academiadev.model;

public class Student extends User {

    private SubscriptionPlan plan;

    public Student(String name, String email, SubscriptionPlan plan) {
        super(name, email);
        this.plan = plan;
    }

    public SubscriptionPlan getPlan() { return plan; }
    public void setPlan(SubscriptionPlan plan) { this.plan = plan; }

    @Override
    public String toString() {
        return name + " <" + email + "> [" + plan.getPlanName() + "]";
    }
}
