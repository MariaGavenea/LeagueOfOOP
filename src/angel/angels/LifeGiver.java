package angel.angels;

import angel.Angel;
import angel.AngelType;
import constants.constants_for_angels.ConstantsForLifeGiver;
import hero.HeroStatus;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

import java.io.IOException;

public class LifeGiver extends Angel {
    public LifeGiver() {
        angelType = AngelType.LifeGiver;
    }

    @Override
    public void influenceHero(Knight knight) throws IOException {
        if (knight.getStatus() == HeroStatus.dead) {
            return;
        }

        knight.addHp(ConstantsForLifeGiver.INCREASE_HP_FOR_KNIGHT);

        setState(angelType + " helped Knight " + knight.getId() + "\n");
    }

    @Override
    public void influenceHero(Pyromancer pyromancer) throws IOException {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            return;
        }

        pyromancer.addHp(ConstantsForLifeGiver.INCREASE_HP_FOR_PYROMANCER);

        setState(angelType + " helped Pyromancer " + pyromancer.getId() + "\n");
    }

    @Override
    public void influenceHero(Rogue rogue) throws IOException {
        if (rogue.getStatus() == HeroStatus.dead) {
            return;
        }

        rogue.addHp(ConstantsForLifeGiver.INCREASE_HP_FOR_ROGUE);

        setState(angelType + " helped Rogue " + rogue.getId() + "\n");
    }

    @Override
    public void influenceHero(Wizard wizard) throws IOException {
        if (wizard.getStatus() == HeroStatus.dead) {
            return;
        }

        wizard.addHp(ConstantsForLifeGiver.INCREASE_HP_FOR_WIZARD);

        setState(angelType + " helped Wizard " + wizard.getId() + "\n");
    }
}
