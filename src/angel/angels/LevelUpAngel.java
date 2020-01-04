package angel.angels;

import abilities.Ability;
import angel.Angel;
import angel.AngelType;
import constants.constants_for_angels.ConstantsForLevelUpAngel;
import constants.constants_for_heroes.ConstantsForLevelUp;
import hero.Hero;
import hero.HeroStatus;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

import java.io.IOException;

public class LevelUpAngel extends Angel {
    public LevelUpAngel() {
        angelType = AngelType.LevelUpAngel;
    }

    @Override
    public final void influenceHero(final Knight knight) throws IOException {
        if (knight.getStatus() == HeroStatus.dead) {
            return;
        }

        levelUp(knight);

        for (Ability ability : knight.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForLevelUpAngel.INCREASE_AMPLIFIER_FOR_KNIGHT);
        }

        setMessage(angelType + " helped Knight " + knight.getId() + "\n");
        setMessage("Knight " + knight.getId() + " reached level " + knight.getLevel() + "\n");
    }

    @Override
    public final void influenceHero(final Pyromancer pyromancer) throws IOException {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            return;
        }

        levelUp(pyromancer);

        for (Ability ability : pyromancer.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForLevelUpAngel.INCREASE_AMPLIFIER_FOR_PYROMANCER);
        }

        setMessage(angelType + " helped Pyromancer " + pyromancer.getId() + "\n");
        setMessage("Pyromancer " + pyromancer.getId() + " reached level "
                + pyromancer.getLevel() + "\n");
    }

    @Override
    public final void influenceHero(final Rogue rogue) throws IOException {
        if (rogue.getStatus() == HeroStatus.dead) {
            return;
        }

        levelUp(rogue);

        for (Ability ability : rogue.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForLevelUpAngel.INCREASE_AMPLIFIER_FOR_ROGUE);
        }

        setMessage(angelType + " helped Rogue " + rogue.getId() + "\n");
        setMessage("Rogue " + rogue.getId() + " reached level " + rogue.getLevel() + "\n");
    }

    @Override
    public final void influenceHero(final Wizard wizard) throws IOException {
        if (wizard.getStatus() == HeroStatus.dead) {
            return;
        }

        levelUp(wizard);

        for (Ability ability : wizard.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForLevelUpAngel.INCREASE_AMPLIFIER_FOR_WIZARD);
        }

        setMessage(angelType + " helped Wizard " + wizard.getId() + "\n");
        setMessage("Wizard " + wizard.getId() + " reached level " + wizard.getLevel() + "\n");
    }

    protected final void levelUp(final Hero hero) {
        int newLevel = hero.getLevel() + 1;
        hero.setXp(ConstantsForLevelUp.BASE_VALUE
                + (newLevel - 1) * ConstantsForLevelUp.VALUE_FOR_ONE_LEVEL_UP);
        hero.setLevel(newLevel);

        hero.newHp();
    }
}
