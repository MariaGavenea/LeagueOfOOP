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

public class LevelUpAngel extends Angel {
    public LevelUpAngel() {
        angelType = AngelType.LevelUpAngel;
    }

    @Override
    public void influenceHero(Knight knight) {
        if (knight.getStatus() == HeroStatus.dead) {
            return;
        }

        levelUp(knight);

        for (Ability ability : knight.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForLevelUpAngel.INCREASE_AMPLIFIER_FOR_KNIGHT);
        }
    }

    @Override
    public void influenceHero(Pyromancer pyromancer) {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            return;
        }

        levelUp(pyromancer);

        for (Ability ability : pyromancer.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForLevelUpAngel.INCREASE_AMPLIFIER_FOR_PYROMANCER);
        }
    }

    @Override
    public void influenceHero(Rogue rogue) {
        if (rogue.getStatus() == HeroStatus.dead) {
            return;
        }

        levelUp(rogue);

        for (Ability ability : rogue.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForLevelUpAngel.INCREASE_AMPLIFIER_FOR_ROGUE);
        }
    }

    @Override
    public void influenceHero(Wizard wizard) {
        if (wizard.getStatus() == HeroStatus.dead) {
            return;
        }

        levelUp(wizard);

        for (Ability ability : wizard.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForLevelUpAngel.INCREASE_AMPLIFIER_FOR_WIZARD);
        }
    }

    protected void levelUp(Hero hero) {
        int newLevel = hero.getLevel() + 1;
        hero.setXp(ConstantsForLevelUp.BASE_VALUE +
                (newLevel - 1) * ConstantsForLevelUp.VALUE_FOR_ONE_LEVEL_UP);
        hero.setLevel(newLevel);
    }
}
