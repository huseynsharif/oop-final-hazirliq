package strategy;

public interface PayStrategy {

    void collectPaymentsDetails();
    boolean pay(int amount);

}
