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
    public final void influenceHero(final Knight knight) throws IOException {
        if (knight.getStatus() == HeroStatus.dead) {
            return;
        }

        knight.addHp(ConstantsForLifeGiver.INCREASE_HP_FOR_KNIGHT);

        setMessage(angelType + " helped Knight " + knight.getId() + "\n");
    }

    @Override
    public final void influenceHero(final Pyromancer pyromancer) throws IOException {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            return;
        }

        pyromancer.addHp(ConstantsForLifeGiver.INCREASE_HP_FOR_PYROMANCER);

        setMessage(angelType + " helped Pyromancer " + pyromancer.getId() + "\n");
    }

    @Override
    public final void influenceHero(final Rogue rogue) throws IOException {
        if (rogue.getStatus() == HeroStatus.dead) {
            return;
        }

        rogue.addHp(ConstantsForLifeGiver.INCREASE_HP_FOR_ROGUE);

        setMessage(angelType + " helped Rogue " + rogue.getId() + "\n");
    }

    @Override
    public final void influenceHero(final Wizard wizard) throws IOException {
        if (wizard.getStatus() == HeroStatus.dead) {
            return;
        }

        wizard.addHp(ConstantsForLifeGiver.INCREASE_HP_FOR_WIZARD);

        setMessage(angelType + " helped Wizard " + wizard.getId() + "\n");
    }
}
