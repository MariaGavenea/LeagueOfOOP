package abilities.knight_abilities;

import abilities.Ability;
import common.Position;
import constants.constants_for_heroes.ConstantsForKnight;
import hero.Hero;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;
import map.GameMap;
import map.LocationType;

public class Slam implements Ability {
    protected float knightAmplifier;
    protected float pyromancerAmplifier;
    protected float rogueAmplifier;
    protected float wizardAmplifier;

    public Slam() {
        this.knightAmplifier = ConstantsForKnight.SlamConstants.KNIGHT_AMPLIFIER;
        this.pyromancerAmplifier = ConstantsForKnight.SlamConstants.PYROMANCER_AMPLIFIER;
        this.rogueAmplifier = ConstantsForKnight.SlamConstants.ROGUE_AMPLIFIER;
        this.wizardAmplifier = ConstantsForKnight.SlamConstants.WIZARD_AMPLIFIER;
    }

    @Override
    public final int applyAbility(final Knight knight, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(knight);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(knight, attacker);

        return Math.round(damage * knightAmplifier);
    }

    @Override
    public final int applyAbility(final Pyromancer pyromancer, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(pyromancer);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(pyromancer, attacker);

        return Math.round(damage * pyromancerAmplifier);
    }

    @Override
    public final int applyAbility(final Rogue rogue, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(rogue);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(rogue, attacker);

        return Math.round(damage * rogueAmplifier);
    }

    @Override
    public final int applyAbility(final Wizard wizard, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(wizard);

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
        knightAmplifier += ConstantsForKnight.OFFENSE_INCREASE_RACE_AMPLIFIER;
        pyromancerAmplifier += ConstantsForKnight.OFFENSE_INCREASE_RACE_AMPLIFIER;
        rogueAmplifier += ConstantsForKnight.OFFENSE_INCREASE_RACE_AMPLIFIER;
        wizardAmplifier += ConstantsForKnight.OFFENSE_INCREASE_RACE_AMPLIFIER;
    }

    @Override
    public void decreaseAmplifiersForStrategy() {
        knightAmplifier -= ConstantsForKnight.DEFENSE_DECREASE_RACE_AMPLIFIER;
        pyromancerAmplifier -= ConstantsForKnight.DEFENSE_DECREASE_RACE_AMPLIFIER;
        rogueAmplifier -= ConstantsForKnight.DEFENSE_DECREASE_RACE_AMPLIFIER;
        wizardAmplifier -= ConstantsForKnight.DEFENSE_DECREASE_RACE_AMPLIFIER;
    }

    @Override
    public void modifyAmplifiers(float percent) {
        knightAmplifier += percent;
        pyromancerAmplifier += percent;
        rogueAmplifier += percent;
        wizardAmplifier += percent;
    }

    protected final int getDamageWithoutRaceModifier(final Hero attacked, final Hero attacker) {
        int damage = ConstantsForKnight.SlamConstants.BASE_DAMAGE
                + ConstantsForKnight.SlamConstants.DAMAGE_PER_LEVEL * attacker.getLevel();

        final LocationType currentLocationType = getHeroLocation(attacked);

        if (currentLocationType == ConstantsForKnight.SlamConstants.LOCATION_TYPE) {
            damage = Math.round(damage * ConstantsForKnight.SlamConstants.LOCATION_AMPLIFIER);
        }

        return damage;
    }

    protected final LocationType getHeroLocation(final Hero hero) {
        final Position position = hero.getPosition();
        final GameMap map = GameMap.getInstance();

        return map.getLocationsType(position.getLine(), position.getColumn());
    }

    protected final void resetOvertimeEffects(final Hero hero) {
        hero.setDamageAndNumOfRounds(0, 0);

        hero.setNumOfRoundsCantMove(ConstantsForKnight.SlamConstants.NUM_OF_ROUNDS_OVERTIME);
    }
}
