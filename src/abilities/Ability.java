package abilities;

import hero.Hero;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

public interface Ability {
    int applyAbility(Knight knight, Hero attacker);

    int applyAbility(Pyromancer pyromancer, Hero attacker);

    int applyAbility(Rogue rogue, Hero attacker);

    int applyAbility(Wizard wizard, Hero attacker);

    int getTotalDamageForWizard(Hero wizard, Hero otherHero);

    // alta interfata
    void increaseAmplifiers();

    void decreaseAmplifiers();

}
