package observer;

public class Main {

    public static void main(String[] args) {
        Thermometer thermometer = new Thermometer(10, 20, 10);

        Parent father = new Parent("Father");
        Parent mother = new Parent("Mother");
        thermometer.addObserver(father);
        thermometer.addObserver(mother);
        for (int i = thermometer.getCurrentValue();i<=25;i++){
            thermometer.setCurrentValue(i);
        }

        for (int i = thermometer.getCurrentValue();i>=5;i--){
            thermometer.setCurrentValue(i);
        }


    }

}
