package hero.heroes;

import constants.ConstantsForPyromancer;
import hero.Hero;
import hero.HeroType;

public class Pyromancer extends Hero {

    public Pyromancer() {
        hp = ConstantsForPyromancer.INITIAL_HP;
        heroType = HeroType.P;
    }

    @Override
    public final void newHp() {
        hp = ConstantsForPyromancer.INITIAL_HP + level * ConstantsForPyromancer.HP_ADDED_PER_LEVEL;
    }
}