package hero.heroes;

import constants.ConstantsForRogue;
import hero.Hero;
import hero.HeroType;

public class Rogue extends Hero {

    public Rogue() {
        hp = ConstantsForRogue.INITIAL_HP;
        heroType = HeroType.R;
    }

    @Override
    public final void newHp() {
        hp = ConstantsForRogue.INITIAL_HP + level * ConstantsForRogue.HP_ADDED_PER_LEVEL;
    }
}
