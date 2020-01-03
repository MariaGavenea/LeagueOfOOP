package great_magician;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private String message;

    public String getState() {
        return message;
    }

    public void setState(String state) throws IOException {
        this.message = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() throws IOException {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
