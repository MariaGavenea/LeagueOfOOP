package hero.heroes;

import abilities.Ability;
import abilities.pyromancer_abilities.PyromancerAbilities;
import constants.ConstantsForKnight;
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
    public void increaseHp() {
        hp += hp / ConstantsForPyromancer.HP_DEFENSE_DIVISOR;
    }

    @Override
    public void decreaseHp() {
        hp -= hp / ConstantsForPyromancer.HP_OFFENSE_DIVISOR;
    }

    @Override
    public boolean checkDefenseStrategy() {
        int maxLevelHp = ConstantsForKnight.INITIAL_HP +
                level * ConstantsForKnight.HP_ADDED_PER_LEVEL;
        return hp < maxLevelHp / 4;
    }

    @Override
    public boolean checkOffenseStrategy() {
        int maxLevelHp = ConstantsForKnight.INITIAL_HP +
                level * ConstantsForKnight.HP_ADDED_PER_LEVEL;
        return maxLevelHp / 4 < hp && hp < maxLevelHp / 3;
    }

    @Override
    public final int getDamagedBy(final Ability attackerAbility, final Hero attacker) {
        return attackerAbility.applyAbility(this, attacker);
    }
}
