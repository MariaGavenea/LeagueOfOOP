package hero.heroes;

import abilities.Ability;
import abilities.knight_abilities.KnightAbilities;
import angel.Angel;
import angel.VisitedByAngel;
import constants.constants_for_heroes.ConstantsForKnight;
import hero.*;

import java.io.IOException;

public class Knight extends Hero implements MortalHero, VisitedByAngel {
    public Knight() {
        hp = ConstantsForKnight.INITIAL_HP;
        heroType = HeroType.K;
        heroFullType = HeroFullType.Knight;

        abilities = new KnightAbilities();
    }

    @Override
    public final void newHp() {
        hp = getMaxHp();
    }

    @Override
    public final void increaseHpForStrategies() {
        hp += hp / ConstantsForKnight.HP_DEFENSE_DIVISOR;
    }

    @Override
    public final void decreaseHpForStrategies() {
        hp -= hp / ConstantsForKnight.HP_OFFENSE_DIVISOR;
        if (hp <= 0) {
            status = HeroStatus.dead;
        }
    }

    @Override
    public final boolean checkDefenseStrategy() {
        int maxLevelHp = getMaxHp();
        return hp < maxLevelHp / ConstantsForKnight.HP_LOWER_LIMIT_STRATEGY_DIVISOR;
    }

    @Override
    public final boolean checkOffenseStrategy() {
        int maxLevelHp = getMaxHp();
        return maxLevelHp / ConstantsForKnight.HP_LOWER_LIMIT_STRATEGY_DIVISOR < hp
                && hp < maxLevelHp / ConstantsForKnight.HP_UPPER_LIMIT_STRATEGY_DIVISOR;
    }

    @Override
    public final int getMaxHp() {
        return ConstantsForKnight.INITIAL_HP + level * ConstantsForKnight.HP_ADDED_PER_LEVEL;
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
