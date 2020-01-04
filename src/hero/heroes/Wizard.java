package hero.heroes;

import abilities.Ability;
import abilities.wizard_abilities.WizardAbilities;
import angel.Angel;
import angel.VisitedByAngel;
import constants.constants_for_heroes.ConstantsForWizard;
import hero.*;

import java.io.IOException;

public class Wizard extends Hero implements MortalHero, VisitedByAngel {

    public Wizard() {
        hp = ConstantsForWizard.INITIAL_HP;
        heroType = HeroType.W;
        heroFullType = HeroFullType.Wizard;

        abilities = new WizardAbilities();
    }

    @Override
    public final void newHp() {
        hp = getMaxHp();
    }

    @Override
    public final void increaseHpForStrategies() {
        hp += hp / ConstantsForWizard.HP_DEFENSE_DIVISOR;
    }

    @Override
    public final void decreaseHpForStrategies() {
        hp -= hp / ConstantsForWizard.HP_OFFENSE_DIVISOR;
        if (hp <= 0) {
            status = HeroStatus.dead;
        }
    }

    @Override
    public final boolean checkDefenseStrategy() {
        int maxLevelHp = getMaxHp();
        return hp < maxLevelHp / ConstantsForWizard.HP_LOWER_LIMIT_STRATEGY_DIVISOR;
    }

    @Override
    public final boolean checkOffenseStrategy() {
        int maxLevelHp = getMaxHp();
        return maxLevelHp / ConstantsForWizard.HP_LOWER_LIMIT_STRATEGY_DIVISOR < hp
                && hp < maxLevelHp / ConstantsForWizard.HP_UPPER_LIMIT_STRATEGY_DIVISOR;
    }

    @Override
    public final int getMaxHp() {
        return ConstantsForWizard.INITIAL_HP + level * ConstantsForWizard.HP_ADDED_PER_LEVEL;
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
