package strategy;

public class Order {

    private int totalCost;
    private boolean isClosed = false;


    public void processOrder(PayStrategy strategy){
        strategy.collectPaymentsDetails();
    }


    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }
}
