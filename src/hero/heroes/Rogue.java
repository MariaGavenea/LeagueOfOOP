package hero.heroes;

import abilities.Ability;
import abilities.rogue_abilities.RogueAbilities;
import constants.ConstantsForKnight;
import constants.ConstantsForRogue;
import hero.Hero;
import hero.HeroType;
import hero.MortalHero;

public class Rogue extends Hero implements MortalHero {

    public Rogue() {
        hp = ConstantsForRogue.INITIAL_HP;
        heroType = HeroType.R;

        abilities = new RogueAbilities();
    }

    @Override
    public final void newHp() {
        hp = ConstantsForRogue.INITIAL_HP + level * ConstantsForRogue.HP_ADDED_PER_LEVEL;
    }

    @Override
    public void increaseHp() {
        hp += hp / ConstantsForRogue.HP_DEFENSE_DIVISOR;
    }

    @Override
    public void decreaseHp() {
        hp -= hp / ConstantsForRogue.HP_OFFENSE_DIVISOR;
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
    public final int getDamagedBy(final Ability attackerAbility, final Hero attacker) {
        return attackerAbility.applyAbility(this, attacker);
    }
}
