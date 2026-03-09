package aula02.academia.dev.model;

/**
 * Interface de plano de assinatura.
 * Uso de polimorfismo: BasicPlan e PremiumPlan implementam contratos distintos.
 */
public interface SubscriptionPlan {
	int getMaxCourses();
    String getPlanName();
}
