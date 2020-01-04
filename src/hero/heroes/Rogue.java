package hero.heroes;

import abilities.Ability;
import abilities.rogue_abilities.RogueAbilities;
import angel.Angel;
import angel.VisitedByAngel;
import constants.constants_for_heroes.ConstantsForRogue;
import hero.*;

import java.io.IOException;

public class Rogue extends Hero implements MortalHero, VisitedByAngel {

    public Rogue() {
        hp = ConstantsForRogue.INITIAL_HP;
        heroType = HeroType.R;
        heroFullType = HeroFullType.Rogue;

        abilities = new RogueAbilities();
    }

    @Override
    public final void newHp() {
        hp = getMaxHp();
    }

    @Override
    public final void increaseHpForStrategies() {
        hp += hp / ConstantsForRogue.HP_DEFENSE_DIVISOR;
    }

    @Override
    public final void decreaseHpForStrategies() {
        hp -= hp / ConstantsForRogue.HP_OFFENSE_DIVISOR;
        if (hp <= 0) {
            status = HeroStatus.dead;
        }
    }

    @Override
    public final boolean checkDefenseStrategy() {
        int maxLevelHp = getMaxHp();
        return hp < maxLevelHp / ConstantsForRogue.HP_LOWER_LIMIT_STRATEGY_DIVISOR;
    }

    @Override
    public final boolean checkOffenseStrategy() {
        int maxLevelHp = getMaxHp();
        return maxLevelHp / ConstantsForRogue.HP_LOWER_LIMIT_STRATEGY_DIVISOR < hp
                && hp < maxLevelHp / ConstantsForRogue.HP_UPPER_LIMIT_STRATEGY_DIVISOR;
    }

    @Override
    public final int getMaxHp() {
        return ConstantsForRogue.INITIAL_HP + level * ConstantsForRogue.HP_ADDED_PER_LEVEL;
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
