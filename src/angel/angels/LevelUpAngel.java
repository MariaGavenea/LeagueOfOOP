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
    public void influenceHero(Knight knight) throws IOException {
        if (knight.getStatus() == HeroStatus.dead) {
            return;
        }

        levelUp(knight);

        for (Ability ability : knight.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForLevelUpAngel.INCREASE_AMPLIFIER_FOR_KNIGHT);
        }

        setState(angelType + " helped Knight " + knight.getId() + "\n");
        setState("Knight " + knight.getId() + " reached level " + knight.getLevel() + "\n");
    }

    @Override
    public void influenceHero(Pyromancer pyromancer) throws IOException {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            return;
        }

        levelUp(pyromancer);

        for (Ability ability : pyromancer.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForLevelUpAngel.INCREASE_AMPLIFIER_FOR_PYROMANCER);
        }

        setState(angelType + " helped Pyromancer " + pyromancer.getId() + "\n");
        setState("Pyromancer " + pyromancer.getId() + " reached level "
                + pyromancer.getLevel() + "\n");
    }

    @Override
    public void influenceHero(Rogue rogue) throws IOException {
        if (rogue.getStatus() == HeroStatus.dead) {
            return;
        }

        levelUp(rogue);

        for (Ability ability : rogue.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForLevelUpAngel.INCREASE_AMPLIFIER_FOR_ROGUE);
        }

        setState(angelType + " helped Rogue " + rogue.getId() + "\n");
        setState("Rogue " + rogue.getId() + " reached level " + rogue.getLevel() + "\n");
    }

    @Override
    public void influenceHero(Wizard wizard) throws IOException {
        if (wizard.getStatus() == HeroStatus.dead) {
            return;
        }

        levelUp(wizard);

        for (Ability ability : wizard.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForLevelUpAngel.INCREASE_AMPLIFIER_FOR_WIZARD);
        }

        setState(angelType + " helped Wizard " + wizard.getId() + "\n");
        setState("Wizard " + wizard.getId() + " reached level " + wizard.getLevel() + "\n");
    }

    protected void levelUp(Hero hero) {
        int newLevel = hero.getLevel() + 1;
        hero.setXp(ConstantsForLevelUp.BASE_VALUE +
                (newLevel - 1) * ConstantsForLevelUp.VALUE_FOR_ONE_LEVEL_UP);
        hero.setLevel(newLevel);

        hero.newHp();
    }
}
