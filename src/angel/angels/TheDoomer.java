package angel.angels;

import angel.Angel;
import angel.AngelType;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

public class TheDoomer extends Angel {
    public TheDoomer() {
        angelType = AngelType.TheDoomer;
    }

    @Override
    public void influenceHero(Knight knight) {
        knight.setHp(0);
    }

    @Override
    public void influenceHero(Pyromancer pyromancer) {
        pyromancer.setHp(0);
    }

    @Override
    public void influenceHero(Rogue rogue) {
        rogue.setHp(0);
    }

    @Override
    public void influenceHero(Wizard wizard) {
        wizard.setHp(0);
    }
}
