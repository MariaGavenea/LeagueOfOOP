package hero.heroes;

import abilities.Ability;
import abilities.pyromancer_abilities.PyromancerAbilities;
import angel.Angel;
import angel.VisitedByAngel;
import constants.constants_for_heroes.ConstantsForKnight;
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
        hp = ConstantsForPyromancer.INITIAL_HP + level * ConstantsForPyromancer.HP_ADDED_PER_LEVEL;
    }

    @Override
    public void increaseHpForStrategies() {
        hp += hp / ConstantsForPyromancer.HP_DEFENSE_DIVISOR;
    }

    @Override
    public void decreaseHpForStrategies() {
        hp -= hp / ConstantsForPyromancer.HP_OFFENSE_DIVISOR;
        if (hp <= 0) {
            status = HeroStatus.dead;
        }
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

    @Override
    public void acceptVisit(Angel angel) throws IOException {
        angel.influenceHero(this);
    }
}
