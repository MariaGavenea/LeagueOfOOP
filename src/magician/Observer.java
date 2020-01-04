package magician;

import java.io.IOException;

public abstract class Observer {
    protected Subject subject;

    public abstract void update(String message) throws IOException;
}
