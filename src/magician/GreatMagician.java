package magician;

import java.io.FileWriter;
import java.io.IOException;

public class GreatMagician extends Observer {
    private FileWriter fw;

    public GreatMagician(final Subject subject, final FileWriter fw) {
        this.subject = subject;
        this.subject.attach(this);
        this.fw = fw;
    }


    @Override
    public final void update(final StringBuilder message) throws IOException {
        fw.write(message.toString());
    }
}
