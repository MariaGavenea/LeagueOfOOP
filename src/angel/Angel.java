package angel;

import common.Position;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

public abstract class Angel {
    protected Position position;
    protected AngelType angelType;

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract void influenceHero(Knight knight);

    public abstract void influenceHero(Pyromancer pyromancer);

    public abstract void influenceHero(Rogue rogue);

    public abstract void influenceHero(Wizard wizard);
}
