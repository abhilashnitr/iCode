package main.FAANG.DesignPatterns.Behavioral.Strategy;

/**
 * Common interface for all strategies.
 */
public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
