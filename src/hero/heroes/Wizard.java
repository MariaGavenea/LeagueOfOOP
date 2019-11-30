package hero.heroes;

import abilities.Ability;
import abilities.wizard_abilities.WizardAbilities;
import constants.ConstantsForWizard;
import hero.Hero;
import hero.HeroType;
import hero.MortalHero;

public class Wizard extends Hero implements MortalHero {

    public Wizard() {
        hp = ConstantsForWizard.INITIAL_HP;
        heroType = HeroType.W;

        abilities = new WizardAbilities();
    }

    @Override
    public final void newHp() {
        hp = ConstantsForWizard.INITIAL_HP + level * ConstantsForWizard.HP_ADDED_PER_LEVEL;
    }

    @Override
    public final int getDamagedBy(final Ability attackerAbility, final Hero attacker) {
        return attackerAbility.applyAbility(this, attacker);
    }
}
