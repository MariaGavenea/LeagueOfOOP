package great_magician;

import java.io.FileWriter;
import java.io.IOException;

public class GreatMagician extends Observer {
    FileWriter fw;

    public GreatMagician(Subject subject, FileWriter fw) {
        this.subject = subject;
        this.subject.attach(this);
        this.fw = fw;
    }


    @Override
    public void update(String message) throws IOException {
        fw.write(message);
    }
}
