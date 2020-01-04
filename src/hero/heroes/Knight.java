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
        hp = ConstantsForKnight.INITIAL_HP + level * ConstantsForKnight.HP_ADDED_PER_LEVEL;
    }

    @Override
    public void increaseHpForStrategies() {
        hp += hp / ConstantsForKnight.HP_DEFENSE_DIVISOR;
    }

    @Override
    public void decreaseHpForStrategies() {
        hp -= hp / ConstantsForKnight.HP_OFFENSE_DIVISOR;
        if (hp <= 0) {
            status = HeroStatus.dead;
        }
    }

    @Override
    public boolean checkDefenseStrategy() {
        int maxLevelHp = ConstantsForKnight.INITIAL_HP +
                level * ConstantsForKnight.HP_ADDED_PER_LEVEL;
        return hp < maxLevelHp / 3;
    }

    @Override
    public boolean checkOffenseStrategy() {
        int maxLevelHp = ConstantsForKnight.INITIAL_HP +
                level * ConstantsForKnight.HP_ADDED_PER_LEVEL;
        return maxLevelHp / 3 < hp && hp < maxLevelHp / 2;
    }

    @Override
    public int getMaxHp() {
        return ConstantsForKnight.INITIAL_HP + level * ConstantsForKnight.HP_ADDED_PER_LEVEL;
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
