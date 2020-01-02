package abilities.rogue_abilities;

import abilities.Ability;
import common.Position;
import constants.constants_for_heroes.ConstantsForRogue;
import hero.Hero;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;
import map.GameMap;
import map.LocationType;

public class Backstab implements Ability {
    protected float knightAmplifier;
    protected float pyromancerAmplifier;
    protected float rogueAmplifier;
    protected float wizardAmplifier;

    public Backstab() {
        this.knightAmplifier = ConstantsForRogue.BackstabConstants.KNIGHT_AMPLIFIER;
        this.pyromancerAmplifier = ConstantsForRogue.BackstabConstants.PYROMANCER_AMPLIFIER;
        this.rogueAmplifier = ConstantsForRogue.BackstabConstants.ROGUE_AMPLIFIER;
        this.wizardAmplifier = ConstantsForRogue.BackstabConstants.WIZARD_AMPLIFIER;
    }

    @Override
    public final int applyAbility(final Knight knight, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(knight, attacker);

        return Math.round(damage * knightAmplifier);
    }

    @Override
    public final int applyAbility(final Pyromancer pyromancer, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(pyromancer, attacker);

        return Math.round(damage * pyromancerAmplifier);
    }

    @Override
    public final int applyAbility(final Rogue rogue, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(rogue, attacker);

        return Math.round(damage * rogueAmplifier);
    }

    @Override
    public final int applyAbility(final Wizard wizard, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(wizard, attacker);

        return Math.round(damage * wizardAmplifier);
    }

    @Override
    public final int getTotalDamageForWizard(final Hero wizard, final Hero otherHero) {
        return getDamageWithoutRaceModifier(wizard, otherHero);
    }

    @Override
    public void increaseAmplifiersForStrategy() {
        knightAmplifier += ConstantsForRogue.OFFENSE_INCREASE_RACE_AMPLIFIER;
        pyromancerAmplifier += ConstantsForRogue.OFFENSE_INCREASE_RACE_AMPLIFIER;
        rogueAmplifier += ConstantsForRogue.OFFENSE_INCREASE_RACE_AMPLIFIER;
        wizardAmplifier += ConstantsForRogue.OFFENSE_INCREASE_RACE_AMPLIFIER;
    }

    @Override
    public void decreaseAmplifiersForStrategy() {
        knightAmplifier -= ConstantsForRogue.DEFENSE_DECREASE_RACE_AMPLIFIER;
        pyromancerAmplifier -= ConstantsForRogue.DEFENSE_DECREASE_RACE_AMPLIFIER;
        rogueAmplifier -= ConstantsForRogue.DEFENSE_DECREASE_RACE_AMPLIFIER;
        wizardAmplifier -= ConstantsForRogue.DEFENSE_DECREASE_RACE_AMPLIFIER;
    }

    @Override
    public void modifyAmplifiers(float percent) {
        knightAmplifier += percent;
        pyromancerAmplifier += percent;
        rogueAmplifier += percent;
        wizardAmplifier += percent;
    }

    protected final int getDamageWithoutRaceModifier(final Hero attacked, final Hero attacker) {
        float damage = ConstantsForRogue.BackstabConstants.BASE_DAMAGE
                + ConstantsForRogue.BackstabConstants.DAMAGE_PER_LEVEL * attacker.getLevel();

        final LocationType currentLocationType = getHeroLocation(attacked);

        if (currentLocationType == ConstantsForRogue.BackstabConstants.LOCATION_TYPE) {
            if (attacker.getFightNumber()
                    % ConstantsForRogue.BackstabConstants.HIT_NUMBER_FOR_CRITICAL == 0) {
                damage *= ConstantsForRogue.BackstabConstants.CRITICAL_AMPLIFIER;
            }
            damage *= ConstantsForRogue.BackstabConstants.LOCATION_AMPLIFIER;
        }

        return Math.round(damage);
    }

    protected final LocationType getHeroLocation(final Hero hero) {
        final Position position = hero.getPosition();
        final GameMap map = GameMap.getInstance();

        return map.getLocationsType(position.getLine(), position.getColumn());
    }
}
