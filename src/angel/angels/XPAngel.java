package angel.angels;

import angel.Angel;
import angel.AngelType;
import constants.constants_for_angels.ConstantsForXPAngel;
import constants.constants_for_heroes.ConstantsForLevelUp;
import hero.Hero;
import hero.HeroStatus;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

import java.io.IOException;

public class XPAngel extends Angel {
    public XPAngel() {
        angelType = AngelType.XPAngel;
    }

    @Override
    public void influenceHero(Knight knight) throws IOException {
        if (knight.getStatus() == HeroStatus.dead) {
            return;
        }

        knight.setXp(knight.getXp() + ConstantsForXPAngel.INCREASE_XP_FOR_KNIGHT);

        setState(angelType + " helped Knight " + knight.getId() + "\n");

        computeLevel(knight);
    }

    @Override
    public void influenceHero(Pyromancer pyromancer) throws IOException {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            return;
        }

        pyromancer.setXp(pyromancer.getXp() + ConstantsForXPAngel.INCREASE_XP_FOR_PYROMANCER);

        setState(angelType + " helped Pyromancer " + pyromancer.getId() + "\n");

        computeLevel(pyromancer);
    }

    @Override
    public void influenceHero(Rogue rogue) throws IOException {
        if (rogue.getStatus() == HeroStatus.dead) {
            return;
        }

        rogue.setXp(rogue.getXp() + ConstantsForXPAngel.INCREASE_XP_FOR_ROGUE);

        setState(angelType + " helped Rogue " + rogue.getId() + "\n");

        computeLevel(rogue);
    }

    @Override
    public void influenceHero(Wizard wizard) throws IOException {
        if (wizard.getStatus() == HeroStatus.dead) {
            return;
        }

        wizard.setXp(wizard.getXp() + ConstantsForXPAngel.INCREASE_XP_FOR_WIZARD);

        setState(angelType + " helped Wizard " + wizard.getId() + "\n");

        computeLevel(wizard);
    }

    protected final void computeLevel(final Hero hero) throws IOException {
        final int oldLevel = hero.getLevel();
        final int level = (hero.getXp() - ConstantsForLevelUp.BASE_VALUE
                + ConstantsForLevelUp.VALUE_FOR_ONE_LEVEL_UP)
                / ConstantsForLevelUp.VALUE_FOR_ONE_LEVEL_UP;

        if (level > oldLevel) {
            hero.setLevel(level);
        }

        for (int i = oldLevel + 1; i <= level; i++) {
            setState(hero.getHeroFullType() + " " + hero.getId() + " reached level "
                    + i + "\n");
        }
    }
}
