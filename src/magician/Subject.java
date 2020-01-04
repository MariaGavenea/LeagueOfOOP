package magician;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private String message;

    public final String getMessage() {
        return message;
    }

    public final void setMessage(final String message) throws IOException {
        this.message = message;
        notifyAllObservers();
    }

    public final void attach(final Observer observer) {
        observers.add(observer);
    }

    public final void notifyAllObservers() throws IOException {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
