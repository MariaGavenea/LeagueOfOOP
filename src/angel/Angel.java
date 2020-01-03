package angel;

import common.Position;
import great_magician.Subject;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

import java.io.IOException;

public abstract class Angel extends Subject {
    protected Position position;
    protected AngelType angelType;

    public abstract void influenceHero(Knight knight) throws IOException;

    public abstract void influenceHero(Pyromancer pyromancer) throws IOException;

    public abstract void influenceHero(Rogue rogue) throws IOException;

    public abstract void influenceHero(Wizard wizard) throws IOException;

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public AngelType getAngelType() {
        return angelType;
    }
}
