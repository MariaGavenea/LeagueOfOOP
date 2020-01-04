package angel.angels;

import angel.Angel;
import angel.AngelType;
import constants.constants_for_angels.ConstantsForDarkAngel;
import hero.HeroStatus;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

import java.io.IOException;

public class DarkAngel extends Angel {
    public DarkAngel() {
        angelType = AngelType.DarkAngel;
    }

    @Override
    public void influenceHero(Knight knight) throws IOException {
        if (knight.getStatus() == HeroStatus.dead) {
            return;
        }

        knight.addHp(ConstantsForDarkAngel.DECREASE_HP_FOR_KNIGHT);

        setState(angelType + " hit Knight " + knight.getId() + "\n");

        if (knight.getStatus().equals(HeroStatus.dead)) {
            setState("Player Knight " + knight.getId() + " was killed by an angel\n");
        }
    }

    @Override
    public void influenceHero(Pyromancer pyromancer) throws IOException {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            return;
        }

        pyromancer.addHp(ConstantsForDarkAngel.DECREASE_HP_FOR_PYROMANCER);

        setState(angelType + " hit Pyromancer " + pyromancer.getId() + "\n");

        if (pyromancer.getStatus().equals(HeroStatus.dead)) {
            setState("Player Pyromancer " + pyromancer.getId() + " was killed by an angel\n");
        }
    }

    @Override
    public void influenceHero(Rogue rogue) throws IOException {
        if (rogue.getStatus() == HeroStatus.dead) {
            return;
        }

        rogue.addHp(ConstantsForDarkAngel.DECREASE_HP_FOR_ROGUE);

        setState(angelType + " hit Rogue " + rogue.getId() + "\n");

        if (rogue.getStatus().equals(HeroStatus.dead)) {
            setState("Player Rogue " + rogue.getId() + " was killed by an angel\n");
        }
    }

    @Override
    public void influenceHero(Wizard wizard) throws IOException {
        if (wizard.getStatus() == HeroStatus.dead) {
            return;
        }

        wizard.addHp(ConstantsForDarkAngel.DECREASE_HP_FOR_WIZARD);

        setState(angelType + " hit Wizard " + wizard.getId() + "\n");

        if (wizard.getStatus().equals(HeroStatus.dead)) {
            setState("Player Wizard " + wizard.getId() + " was killed by an angel\n");
        }
    }
}
