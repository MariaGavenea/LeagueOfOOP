package great_magician;

import java.io.IOException;

public abstract class Observer {
    protected Subject subject;

    public abstract void update(final String message) throws IOException;
}
