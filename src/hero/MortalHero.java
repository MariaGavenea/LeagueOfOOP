package hero;

import abilities.Ability;

public interface MortalHero {
    int getDamagedBy(Ability attackerAbility, Hero attacker);
}