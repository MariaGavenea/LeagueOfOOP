package hero.heroes;

import abilities.Ability;
import abilities.rogue_abilities.RogueAbilities;
import angel.Angel;
import angel.VisitedByAngel;
import constants.constants_for_heroes.ConstantsForKnight;
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
        hp = ConstantsForRogue.INITIAL_HP + level * ConstantsForRogue.HP_ADDED_PER_LEVEL;
    }

    @Override
    public void increaseHpForStrategies() {
        hp += hp / ConstantsForRogue.HP_DEFENSE_DIVISOR;
    }

    @Override
    public void decreaseHpForStrategies() {
        hp -= hp / ConstantsForRogue.HP_OFFENSE_DIVISOR;
        if (hp <= 0) {
            status = HeroStatus.dead;
        }
    }

    @Override
    public boolean checkDefenseStrategy() {
        int maxLevelHp = ConstantsForKnight.INITIAL_HP +
                level * ConstantsForKnight.HP_ADDED_PER_LEVEL;
        return hp < maxLevelHp / 7;
    }

    @Override
    public boolean checkOffenseStrategy() {
        int maxLevelHp = ConstantsForKnight.INITIAL_HP +
                level * ConstantsForKnight.HP_ADDED_PER_LEVEL;
        return maxLevelHp / 7 < hp && hp < maxLevelHp / 5;
    }

    @Override
    public int getMaxHp() {
        return ConstantsForRogue.INITIAL_HP + level * ConstantsForRogue.HP_ADDED_PER_LEVEL;
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
