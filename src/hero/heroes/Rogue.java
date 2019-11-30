package hero.heroes;

import abilities.Ability;
import abilities.rogue_abilities.RogueAbilities;
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
    public final int getDamagedBy(final Ability attackerAbility, final Hero attacker) {
        return attackerAbility.applyAbility(this, attacker);
    }
}
