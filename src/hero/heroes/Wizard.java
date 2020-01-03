package hero.heroes;

import abilities.Ability;
import abilities.wizard_abilities.WizardAbilities;
import angel.Angel;
import angel.VisitedByAngel;
import constants.constants_for_heroes.ConstantsForKnight;
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
        hp = ConstantsForWizard.INITIAL_HP + level * ConstantsForWizard.HP_ADDED_PER_LEVEL;
    }

    @Override
    public void increaseHpForStrategies() {
        hp += hp / ConstantsForWizard.HP_DEFENSE_DIVISOR;
    }

    @Override
    public void decreaseHpForStrategies() {
        hp -= hp / ConstantsForWizard.HP_OFFENSE_DIVISOR;
        if (hp <= 0) {
            status = HeroStatus.dead;
        }
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

    @Override
    public void acceptVisit(Angel angel) throws IOException {
        angel.influenceHero(this);
    }
}
