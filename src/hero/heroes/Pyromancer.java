package hero.heroes;

import abilities.Ability;
import abilities.pyromancer_abilities.PyromancerAbilities;
import angel.Angel;
import angel.VisitedByAngel;
import constants.constants_for_heroes.ConstantsForPyromancer;
import hero.*;

import java.io.IOException;

public class Pyromancer extends Hero implements MortalHero, VisitedByAngel {

    public Pyromancer() {
        hp = ConstantsForPyromancer.INITIAL_HP;
        heroType = HeroType.P;
        heroFullType = HeroFullType.Pyromancer;

        abilities = new PyromancerAbilities();
    }

    @Override
    public final void newHp() {
        hp = getMaxHp();
    }

    @Override
    public final void increaseHpForStrategies() {
        hp += hp / ConstantsForPyromancer.HP_DEFENSE_DIVISOR;
    }

    @Override
    public final void decreaseHpForStrategies() {
        hp -= hp / ConstantsForPyromancer.HP_OFFENSE_DIVISOR;
        if (hp <= 0) {
            status = HeroStatus.dead;
        }
    }

    @Override
    public final boolean checkDefenseStrategy() {
        int maxLevelHp = getMaxHp();
        return hp < maxLevelHp / ConstantsForPyromancer.HP_LOWER_LIMIT_STRATEGY_DIVISOR;
    }

    @Override
    public final boolean checkOffenseStrategy() {
        int maxLevelHp = getMaxHp();
        return maxLevelHp / ConstantsForPyromancer.HP_LOWER_LIMIT_STRATEGY_DIVISOR < hp
                && hp < maxLevelHp / ConstantsForPyromancer.HP_UPPER_LIMIT_STRATEGY_DIVISOR;
    }

    @Override
    public final int getMaxHp() {
        return ConstantsForPyromancer.INITIAL_HP + level
                * ConstantsForPyromancer.HP_ADDED_PER_LEVEL;
    }

    @Override
    public final int getDamagedBy(final Ability attackerAbility, final Hero attacker) {
        return attackerAbility.applyAbility(this, attacker);
    }

    @Override
    public final void acceptVisit(final Angel angel) throws IOException {
        angel.influenceHero(this);
    }
}
