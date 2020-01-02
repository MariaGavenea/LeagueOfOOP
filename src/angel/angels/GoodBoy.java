package angel.angels;

import abilities.Ability;
import angel.Angel;
import angel.AngelType;
import constants.constants_for_angels.ConstantsForGoodBoy;
import hero.HeroStatus;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

public class GoodBoy extends Angel {
    public GoodBoy() {
        angelType = AngelType.GoodBoy;
    }

    @Override
    public void influenceHero(Knight knight) {
        if (knight.getStatus() == HeroStatus.dead) {
            return;
        }

        knight.addHp(ConstantsForGoodBoy.INCREASE_HP_FOR_KNIGHT);
        for (Ability ability : knight.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForGoodBoy.INCREASE_AMPLIFIER_FOR_KNIGHT);
        }
    }

    @Override
    public void influenceHero(Pyromancer pyromancer) {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            return;
        }

        pyromancer.addHp(ConstantsForGoodBoy.INCREASE_HP_FOR_PYROMANCER);
        for (Ability ability : pyromancer.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForGoodBoy.INCREASE_AMPLIFIER_FOR_PYROMANCER);
        }
    }

    @Override
    public void influenceHero(Rogue rogue) {
        if (rogue.getStatus() == HeroStatus.dead) {
            return;
        }

        rogue.addHp(ConstantsForGoodBoy.INCREASE_HP_FOR_ROGUE);
        for (Ability ability : rogue.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForGoodBoy.INCREASE_AMPLIFIER_FOR_ROGUE);
        }
    }

    @Override
    public void influenceHero(Wizard wizard) {
        if (wizard.getStatus() == HeroStatus.dead) {
            return;
        }

        wizard.addHp(ConstantsForGoodBoy.INCREASE_HP_FOR_WIZARD);
        for (Ability ability : wizard.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForGoodBoy.INCREASE_AMPLIFIER_FOR_WIZARD);
        }
    }
}
