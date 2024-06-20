package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

    private final List<Observer> observers;

    public Observable() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        } else if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    public void clearObservers() {
        observers.clear();
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
