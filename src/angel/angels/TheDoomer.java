package angel.angels;

import angel.Angel;
import angel.AngelType;
import hero.HeroStatus;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

import java.io.IOException;

public class TheDoomer extends Angel {
    public TheDoomer() {
        angelType = AngelType.TheDoomer;
    }

    @Override
    public void influenceHero(Knight knight) throws IOException {
        if (knight.getStatus().equals(HeroStatus.dead))
            return;

        knight.setHp(0);
        setState(angelType + " hit Knight " + knight.getId() + "\n");
        setState("Player Knight " + knight.getId() + " was killed by an angel\n");
    }

    @Override
    public void influenceHero(Pyromancer pyromancer) throws IOException {
        if (pyromancer.getStatus().equals(HeroStatus.dead))
            return;

        pyromancer.setHp(0);
        setState(angelType + " hit Pyromancer " + pyromancer.getId() + "\n");
        setState("Player Pyromancer " + pyromancer.getId() + " was killed by an angel\n");

    }

    @Override
    public void influenceHero(Rogue rogue) throws IOException {
        if (rogue.getStatus().equals(HeroStatus.dead))
            return;

        rogue.setHp(0);
        setState(angelType + " hit Rogue " + rogue.getId() + "\n");
        setState("Player Rogue " + rogue.getId() + " was killed by an angel\n");

    }

    @Override
    public void influenceHero(Wizard wizard) throws IOException {
        if (wizard.getStatus().equals(HeroStatus.dead))
            return;

        wizard.setHp(0);
        setState(angelType + " hit Wizard " + wizard.getId() + "\n");
        setState("Player Wizard " + wizard.getId() + " was killed by an angel\n");
    }
}
