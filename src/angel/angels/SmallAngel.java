package angel.angels;

import abilities.Ability;
import angel.Angel;
import angel.AngelType;
import constants.constants_for_angels.ConstantsForSmallAngel;
import hero.HeroStatus;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

public class SmallAngel extends Angel {
    public SmallAngel() {
        angelType = AngelType.SmallAngel;
    }

    @Override
    public void influenceHero(Knight knight) {
        if (knight.getStatus() == HeroStatus.dead) {
            return;
        }

        knight.addHp(ConstantsForSmallAngel.INCREASE_HP_FOR_KNIGHT);
        for (Ability ability : knight.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForSmallAngel.INCREASE_AMPLIFIER_FOR_KNIGHT);
        }
    }

    @Override
    public void influenceHero(Pyromancer pyromancer) {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            return;
        }

        pyromancer.addHp(ConstantsForSmallAngel.INCREASE_HP_FOR_PYROMANCER);
        for (Ability ability : pyromancer.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForSmallAngel.INCREASE_AMPLIFIER_FOR_PYROMANCER);
        }
    }

    @Override
    public void influenceHero(Rogue rogue) {
        if (rogue.getStatus() == HeroStatus.dead) {
            return;
        }

        rogue.addHp(ConstantsForSmallAngel.INCREASE_HP_FOR_ROGUE);
        for (Ability ability : rogue.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForSmallAngel.INCREASE_AMPLIFIER_FOR_ROGUE);
        }
    }

    @Override
    public void influenceHero(Wizard wizard) {
        if (wizard.getStatus() == HeroStatus.dead) {
            return;
        }

        wizard.addHp(ConstantsForSmallAngel.INCREASE_HP_FOR_WIZARD);
        for (Ability ability : wizard.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForSmallAngel.INCREASE_AMPLIFIER_FOR_WIZARD);
        }
    }
}
