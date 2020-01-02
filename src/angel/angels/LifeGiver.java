package angel.angels;

import angel.Angel;
import angel.AngelType;
import constants.constants_for_angels.ConstantsForLifeGiver;
import hero.HeroStatus;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

public class LifeGiver extends Angel {
    public LifeGiver() {
        angelType = AngelType.LifeGiver;
    }

    @Override
    public void influenceHero(Knight knight) {
        if (knight.getStatus() == HeroStatus.dead) {
            return;
        }

        knight.addHp(ConstantsForLifeGiver.INCREASE_HP_FOR_KNIGHT);
    }

    @Override
    public void influenceHero(Pyromancer pyromancer) {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            return;
        }

        pyromancer.addHp(ConstantsForLifeGiver.INCREASE_HP_FOR_PYROMANCER);
    }

    @Override
    public void influenceHero(Rogue rogue) {
        if (rogue.getStatus() == HeroStatus.dead) {
            return;
        }

        rogue.addHp(ConstantsForLifeGiver.INCREASE_HP_FOR_ROGUE);
    }

    @Override
    public void influenceHero(Wizard wizard) {
        if (wizard.getStatus() == HeroStatus.dead) {
            return;
        }

        wizard.addHp(ConstantsForLifeGiver.INCREASE_HP_FOR_WIZARD);
    }
}
