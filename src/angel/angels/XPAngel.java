package angel.angels;

import angel.Angel;
import angel.AngelType;
import constants.constants_for_angels.ConstantsForXPAngel;
import hero.HeroStatus;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

public class XPAngel extends Angel {
    public XPAngel() {
        angelType = AngelType.XPAngel;
    }

    @Override
    public void influenceHero(Knight knight) {
        if (knight.getStatus() == HeroStatus.dead) {
            return;
        }

        knight.setXp(knight.getXp() + ConstantsForXPAngel.INCREASE_XP_FOR_KNIGHT);
    }

    @Override
    public void influenceHero(Pyromancer pyromancer) {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            return;
        }

        pyromancer.setXp(pyromancer.getXp() + ConstantsForXPAngel.INCREASE_XP_FOR_PYROMANCER);
    }

    @Override
    public void influenceHero(Rogue rogue) {
        if (rogue.getStatus() == HeroStatus.dead) {
            return;
        }

        rogue.setXp(rogue.getXp() + ConstantsForXPAngel.INCREASE_XP_FOR_ROGUE);
    }

    @Override
    public void influenceHero(Wizard wizard) {
        if (wizard.getStatus() == HeroStatus.dead) {
            return;
        }

        wizard.setXp(wizard.getXp() + ConstantsForXPAngel.INCREASE_XP_FOR_WIZARD);
    }
}
