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
    public final void influenceHero(final Knight knight) throws IOException {
        if (knight.getStatus().equals(HeroStatus.dead)) {
            return;
        }

        knight.setHp(0);
        setMessage(angelType + " hit Knight " + knight.getId() + "\n");
        setMessage("Player Knight " + knight.getId() + " was killed by an angel\n");
    }

    @Override
    public final void influenceHero(final Pyromancer pyromancer) throws IOException {
        if (pyromancer.getStatus().equals(HeroStatus.dead)) {
            return;
        }

        pyromancer.setHp(0);
        setMessage(angelType + " hit Pyromancer " + pyromancer.getId() + "\n");
        setMessage("Player Pyromancer " + pyromancer.getId() + " was killed by an angel\n");

    }

    @Override
    public final void influenceHero(final Rogue rogue) throws IOException {
        if (rogue.getStatus().equals(HeroStatus.dead)) {
            return;
        }

        rogue.setHp(0);
        setMessage(angelType + " hit Rogue " + rogue.getId() + "\n");
        setMessage("Player Rogue " + rogue.getId() + " was killed by an angel\n");

    }

    @Override
    public final void influenceHero(final Wizard wizard) throws IOException {
        if (wizard.getStatus().equals(HeroStatus.dead)) {
            return;
        }

        wizard.setHp(0);
        setMessage(angelType + " hit Wizard " + wizard.getId() + "\n");
        setMessage("Player Wizard " + wizard.getId() + " was killed by an angel\n");
    }
}
