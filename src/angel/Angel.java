package angel;

import common.Position;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;
import magician.Subject;

import java.io.IOException;

public abstract class Angel extends Subject {
    protected Position position;
    protected AngelType angelType;

    public abstract void influenceHero(Knight knight) throws IOException;

    public abstract void influenceHero(Pyromancer pyromancer) throws IOException;

    public abstract void influenceHero(Rogue rogue) throws IOException;

    public abstract void influenceHero(Wizard wizard) throws IOException;

    public final Position getPosition() {
        return position;
    }

    public final void setPosition(final Position position) {
        this.position = position;
    }

    public final AngelType getAngelType() {
        return angelType;
    }
}
