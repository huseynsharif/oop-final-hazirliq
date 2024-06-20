package observer;

public class Thermometer extends Observable {
    private int minValue;
    private int maxValue;
    private int currentValue;

    public Thermometer(int minValue, int maxValue, int currentValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.currentValue = currentValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
        System.out.println("Current value: " + currentValue);
        checkTemp();
    }

    private void checkTemp() {
        if (currentValue>maxValue || currentValue<minValue){
            notifyAllObservers();
        }
    }
}
