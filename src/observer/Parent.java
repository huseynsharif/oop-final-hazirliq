package observer;

public class Parent implements Observer {

    private final String name;

    public Parent(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable observable) {

        Thermometer thermometer = (Thermometer) observable;

        System.out.println(name + ": Temperature is " + thermometer.getCurrentValue());
    }
}
