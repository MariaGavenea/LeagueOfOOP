package hero.heroes;

import abilities.Ability;
import abilities.knight_abilities.KnightAbilities;
import constants.ConstantsForKnight;
import hero.Hero;
import hero.HeroType;
import hero.MortalHero;

public class Knight extends Hero implements MortalHero {
    public Knight() {
        hp = ConstantsForKnight.INITIAL_HP;
        heroType = HeroType.K;

        abilities = new KnightAbilities();
    }

    @Override
    public final void newHp() {
        hp = ConstantsForKnight.INITIAL_HP + level * ConstantsForKnight.HP_ADDED_PER_LEVEL;
    }

    @Override
    public final int getDamagedBy(final Ability attackerAbility, final Hero attacker) {
        return attackerAbility.applyAbility(this, attacker);
    }
}
