package hero.heroes;

import abilities.Ability;
import abilities.pyromancer_abilities.PyromancerAbilities;
import constants.ConstantsForPyromancer;
import hero.Hero;
import hero.HeroType;
import hero.MortalHero;

public class Pyromancer extends Hero implements MortalHero {

    public Pyromancer() {
        hp = ConstantsForPyromancer.INITIAL_HP;
        heroType = HeroType.P;

        abilities = new PyromancerAbilities();
    }

    @Override
    public final void newHp() {
        hp = ConstantsForPyromancer.INITIAL_HP + level * ConstantsForPyromancer.HP_ADDED_PER_LEVEL;
    }

    @Override
    public final int getDamagedBy(final Ability attackerAbility, final Hero attacker) {
        return attackerAbility.applyAbility(this, attacker);
    }
}
