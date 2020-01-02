package abilities.pyromancer_abilities;

import abilities.Ability;
import common.Position;
import constants.constants_for_heroes.ConstantsForPyromancer;
import hero.Hero;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;
import map.GameMap;
import map.LocationType;

public class Ignite implements Ability {
    protected float knightAmplifier;
    protected float pyromancerAmplifier;
    protected float rogueAmplifier;
    protected float wizardAmplifier;

    public Ignite() {
        this.knightAmplifier = ConstantsForPyromancer.IgniteConstants.KNIGHT_AMPLIFIER;
        this.pyromancerAmplifier = ConstantsForPyromancer.IgniteConstants.PYROMANCER_AMPLIFIER;
        this.rogueAmplifier = ConstantsForPyromancer.IgniteConstants.ROGUE_AMPLIFIER;
        this.wizardAmplifier = ConstantsForPyromancer.IgniteConstants.WIZARD_AMPLIFIER;
    }

    @Override
    public final int applyAbility(final Knight knight, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(knight, attacker, knightAmplifier);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(knight, attacker);

        return Math.round(damage * knightAmplifier);
    }

    @Override
    public final int applyAbility(final Pyromancer pyromancer, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(pyromancer, attacker, pyromancerAmplifier);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(pyromancer, attacker);

        return Math.round(damage * pyromancerAmplifier);
    }

    @Override
    public final int applyAbility(final Rogue rogue, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(rogue, attacker, rogueAmplifier);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(rogue, attacker);

        return Math.round(damage * rogueAmplifier);
    }

    @Override
    public final int applyAbility(final Wizard wizard, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(wizard, attacker, wizardAmplifier);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(wizard, attacker);

        return Math.round(damage * wizardAmplifier);
    }

    @Override
    public final int getTotalDamageForWizard(final Hero wizard, final Hero otherHero) {
        return getDamageWithoutRaceModifier(wizard, otherHero);
    }

    @Override
    public void increaseAmplifiersForStrategy() {
        knightAmplifier += ConstantsForPyromancer.OFFENSE_INCREASE_RACE_AMPLIFIER;
        pyromancerAmplifier += ConstantsForPyromancer.OFFENSE_INCREASE_RACE_AMPLIFIER;
        rogueAmplifier += ConstantsForPyromancer.OFFENSE_INCREASE_RACE_AMPLIFIER;
        wizardAmplifier += ConstantsForPyromancer.OFFENSE_INCREASE_RACE_AMPLIFIER;
    }

    @Override
    public void decreaseAmplifiersForStrategy() {
        knightAmplifier -= ConstantsForPyromancer.DEFENSE_DECREASE_RACE_AMPLIFIER;
        pyromancerAmplifier -= ConstantsForPyromancer.DEFENSE_DECREASE_RACE_AMPLIFIER;
        rogueAmplifier -= ConstantsForPyromancer.DEFENSE_DECREASE_RACE_AMPLIFIER;
        wizardAmplifier -= ConstantsForPyromancer.DEFENSE_DECREASE_RACE_AMPLIFIER;
    }

    @Override
    public void modifyAmplifiers(float percent) {
        knightAmplifier += percent;
        pyromancerAmplifier += percent;
        rogueAmplifier += percent;
        wizardAmplifier += percent;
    }

    protected final int getDamageWithoutRaceModifier(final Hero attacked, final Hero attacker) {
        float damage = ConstantsForPyromancer.IgniteConstants.BASE_DAMAGE
                + ConstantsForPyromancer.IgniteConstants.DAMAGE_PER_LEVEL * attacker.getLevel();

        final LocationType currentLocationType = getHeroLocation(attacked);

        if (currentLocationType == ConstantsForPyromancer.IgniteConstants.LOCATION_TYPE) {
            damage *= ConstantsForPyromancer.IgniteConstants.LOCATION_AMPLIFIER;
        }

        return Math.round(damage);
    }

    // functions for overtime effect
    protected final void resetOvertimeEffects(final Hero attacked, final Hero attacker,
                                              final float heroAmplifier) {
        applyDamageOvertime(attacked, attacker, heroAmplifier);

        attacked.setNumOfRoundsCantMove(0);
    }

    protected final void applyDamageOvertime(final Hero attacked, final Hero attacker,
                                             final float heroAmplifier) {
        float periodicDamage = ConstantsForPyromancer.IgniteConstants.DAMAGE_PER_ROUND
                + ConstantsForPyromancer.IgniteConstants.OVERTIME_DAMAGE_PER_LEVEL
                * attacker.getLevel();

        final LocationType currentLocationType = getHeroLocation(attacked);

        if (currentLocationType == ConstantsForPyromancer.IgniteConstants.LOCATION_TYPE) {
            periodicDamage *= ConstantsForPyromancer.IgniteConstants.LOCATION_AMPLIFIER;
        }

        final int finalPeriodicDamage = Math.round(Math.round(periodicDamage) * heroAmplifier);

        attacked.setDamageAndNumOfRounds(finalPeriodicDamage,
                ConstantsForPyromancer.IgniteConstants.NUM_OF_ROUNDS_OVERTIME);
    }

    protected final LocationType getHeroLocation(final Hero hero) {
        final Position position = hero.getPosition();
        final GameMap map = GameMap.getInstance();

        return map.getLocationsType(position.getLine(), position.getColumn());
    }
}
