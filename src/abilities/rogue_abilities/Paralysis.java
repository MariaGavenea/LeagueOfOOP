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

public class Paralysis implements Ability {
    protected float knightAmplifier;
    protected float pyromancerAmplifier;
    protected float rogueAmplifier;
    protected float wizardAmplifier;

    public Paralysis() {
        this.knightAmplifier = ConstantsForRogue.ParalysisConstants.KNIGHT_AMPLIFIER;
        this.pyromancerAmplifier = ConstantsForRogue.ParalysisConstants.PYROMANCER_AMPLIFIER;
        this.rogueAmplifier = ConstantsForRogue.ParalysisConstants.ROGUE_AMPLIFIER;
        this.wizardAmplifier = ConstantsForRogue.ParalysisConstants.WIZARD_AMPLIFIER;
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
        float damage = ConstantsForRogue.ParalysisConstants.BASE_DAMAGE
                + ConstantsForRogue.ParalysisConstants.DAMAGE_PER_LEVEL * attacker.getLevel();

        final LocationType currentLocationType = getHeroLocation(attacked);


        if (currentLocationType == ConstantsForRogue.ParalysisConstants.LOCATION_TYPE) {
            damage *= ConstantsForRogue.ParalysisConstants.LOCATION_AMPLIFIER;
        }

        return Math.round(damage);
    }

    // functions for overtime effect
    protected final void resetOvertimeEffects(final Hero attacked, final Hero attacker,
                                              final float heroAmplifier) {
        applyDamageOvertime(attacked, attacker, heroAmplifier);
    }

    protected final void applyDamageOvertime(final Hero attacked, final Hero attacker,
                                             final float heroAmplifier) {
        final int damageWithoutHeroAmplifier = getDamageWithoutRaceModifier(attacked, attacker);
        final int finalDamage = Math.round(Math.round(damageWithoutHeroAmplifier) * heroAmplifier);

        final LocationType currentLocationType = getHeroLocation(attacked);
        int numOfRoundsOvertime = ConstantsForRogue.ParalysisConstants.NUM_OF_ROUNDS_OVERTIME;

        if (currentLocationType == ConstantsForRogue.ParalysisConstants.LOCATION_TYPE) {
            numOfRoundsOvertime =
                    ConstantsForRogue.ParalysisConstants.NUM_OF_ROUNDS_OVERTIME_IF_ON_WOODS;
        }

        attacked.setDamageAndNumOfRounds(finalDamage, numOfRoundsOvertime);
        attacked.setNumOfRoundsCantMove(numOfRoundsOvertime);
    }

    protected final LocationType getHeroLocation(final Hero hero) {
        final Position position = hero.getPosition();
        final GameMap map = GameMap.getInstance();

        return map.getLocationsType(position.getLine(), position.getColumn());
    }
}
