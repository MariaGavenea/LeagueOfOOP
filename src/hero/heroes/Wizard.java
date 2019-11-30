package hero.heroes;

import constants.ConstantsForWizard;
import hero.Hero;
import hero.HeroType;

public class Wizard extends Hero {

    public Wizard() {
        hp = ConstantsForWizard.INITIAL_HP;
        heroType = HeroType.W;

    }

    @Override
    public final void newHp() {
        hp = ConstantsForWizard.INITIAL_HP + level * ConstantsForWizard.HP_ADDED_PER_LEVEL;
    }
}
