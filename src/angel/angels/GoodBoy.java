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

import java.io.IOException;

public class GoodBoy extends Angel {
    public GoodBoy() {
        angelType = AngelType.GoodBoy;
    }

    @Override
    public final void influenceHero(final Knight knight) throws IOException {
        if (knight.getStatus() == HeroStatus.dead) {
            return;
        }

        knight.addHp(ConstantsForGoodBoy.INCREASE_HP_FOR_KNIGHT);

        for (Ability ability : knight.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForGoodBoy.INCREASE_AMPLIFIER_FOR_KNIGHT);
        }

        setMessage(angelType + " helped Knight " + knight.getId() + "\n");
    }

    @Override
    public final void influenceHero(final Pyromancer pyromancer) throws IOException {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            return;
        }

        pyromancer.addHp(ConstantsForGoodBoy.INCREASE_HP_FOR_PYROMANCER);

        for (Ability ability : pyromancer.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForGoodBoy.INCREASE_AMPLIFIER_FOR_PYROMANCER);
        }

        setMessage(angelType + " helped Pyromancer " + pyromancer.getId() + "\n");
    }

    @Override
    public final void influenceHero(final Rogue rogue) throws IOException {
        if (rogue.getStatus() == HeroStatus.dead) {
            return;
        }

        rogue.addHp(ConstantsForGoodBoy.INCREASE_HP_FOR_ROGUE);

        for (Ability ability : rogue.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForGoodBoy.INCREASE_AMPLIFIER_FOR_ROGUE);
        }

        setMessage(angelType + " helped Rogue " + rogue.getId() + "\n");
    }

    @Override
    public final void influenceHero(final Wizard wizard) throws IOException {
        if (wizard.getStatus() == HeroStatus.dead) {
            return;
        }

        wizard.addHp(ConstantsForGoodBoy.INCREASE_HP_FOR_WIZARD);

        for (Ability ability : wizard.getAbilities().getListOfAbilities()) {
            ability.modifyAmplifiers(ConstantsForGoodBoy.INCREASE_AMPLIFIER_FOR_WIZARD);
        }

        setMessage(angelType + " helped Wizard " + wizard.getId() + "\n");
    }
}
