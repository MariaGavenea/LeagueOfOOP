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
    public final void influenceHero(final Knight knight) throws IOException {
        if (knight.getStatus() == HeroStatus.dead) {
            return;
        }

        knight.setXp(knight.getXp() + ConstantsForXPAngel.INCREASE_XP_FOR_KNIGHT);

        setMessage(angelType + " helped Knight " + knight.getId() + "\n");

        computeLevel(knight);
    }

    @Override
    public final void influenceHero(final Pyromancer pyromancer) throws IOException {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            return;
        }

        pyromancer.setXp(pyromancer.getXp() + ConstantsForXPAngel.INCREASE_XP_FOR_PYROMANCER);

        setMessage(angelType + " helped Pyromancer " + pyromancer.getId() + "\n");

        computeLevel(pyromancer);
    }

    @Override
    public final void influenceHero(final Rogue rogue) throws IOException {
        if (rogue.getStatus() == HeroStatus.dead) {
            return;
        }

        rogue.setXp(rogue.getXp() + ConstantsForXPAngel.INCREASE_XP_FOR_ROGUE);

        setMessage(angelType + " helped Rogue " + rogue.getId() + "\n");

        computeLevel(rogue);
    }

    @Override
    public final void influenceHero(final Wizard wizard) throws IOException {
        if (wizard.getStatus() == HeroStatus.dead) {
            return;
        }

        wizard.setXp(wizard.getXp() + ConstantsForXPAngel.INCREASE_XP_FOR_WIZARD);

        setMessage(angelType + " helped Wizard " + wizard.getId() + "\n");

        computeLevel(wizard);
    }

    protected final void computeLevel(final Hero hero) throws IOException {
        final int oldLevel = hero.getLevel();
        final int level = (hero.getXp() - ConstantsForLevelUp.BASE_VALUE
                + ConstantsForLevelUp.VALUE_FOR_ONE_LEVEL_UP)
                / ConstantsForLevelUp.VALUE_FOR_ONE_LEVEL_UP;

        if (level > oldLevel) {
            hero.setLevel(level);
            hero.newHp();
        }

        for (int i = oldLevel + 1; i <= level; i++) {
            setMessage(hero.getHeroFullType() + " " + hero.getId() + " reached level "
                    + i + "\n");
        }
    }
}
