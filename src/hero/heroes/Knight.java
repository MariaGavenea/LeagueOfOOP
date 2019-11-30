package hero.heroes;

import constants.ConstantsForKnight;
import hero.Hero;
import hero.HeroType;

public class Knight extends Hero {
    public Knight() {
        hp = ConstantsForKnight.INITIAL_HP;
        heroType = HeroType.K;
    }

    @Override
    public final void newHp() {
        hp = ConstantsForKnight.INITIAL_HP + level * ConstantsForKnight.HP_ADDED_PER_LEVEL;
    }
}
