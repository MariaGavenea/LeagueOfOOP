package hero.heroes;

import abilities.Ability;
import abilities.wizard_abilities.WizardAbilities;
import constants.ConstantsForKnight;
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
    public void increaseHp() {
        hp += hp / ConstantsForWizard.HP_DEFENSE_DIVISOR;
    }

    @Override
    public void decreaseHp() {
        hp -= hp / ConstantsForWizard.HP_OFFENSE_DIVISOR;
    }

    @Override
    public boolean checkDefenseStrategy() {
        int maxLevelHp = ConstantsForKnight.INITIAL_HP +
                level * ConstantsForKnight.HP_ADDED_PER_LEVEL;
        return hp < maxLevelHp / 4;
    }

    @Override
    public boolean checkOffenseStrategy() {
        int maxLevelHp = ConstantsForKnight.INITIAL_HP +
                level * ConstantsForKnight.HP_ADDED_PER_LEVEL;
        return maxLevelHp / 4 < hp && hp < maxLevelHp / 2;
    }

    @Override
    public final int getDamagedBy(final Ability attackerAbility, final Hero attacker) {
        return attackerAbility.applyAbility(this, attacker);
    }
}
