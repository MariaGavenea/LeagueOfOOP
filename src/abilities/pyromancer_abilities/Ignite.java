package abilities.pyromancer_abilities;

import abilities.Ability;
import common.Position;
import hero.Hero;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;
import map.GameMap;
import map.LocationType;

public class Ignite implements Ability {

    @Override
    public final int applyAbility(final Knight knight, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(knight, attacker, IgniteConstants.KNIGHT_AMPLIFIER);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(knight, attacker);

        return Math.round(damage * IgniteConstants.KNIGHT_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Pyromancer pyromancer, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(pyromancer, attacker, IgniteConstants.PYROMANCER_AMPLIFIER);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(pyromancer, attacker);

        return Math.round(damage * IgniteConstants.PYROMANCER_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Rogue rogue, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(rogue, attacker, IgniteConstants.ROGUE_AMPLIFIER);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(rogue, attacker);

        return Math.round(damage * IgniteConstants.ROGUE_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Wizard wizard, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(wizard, attacker, IgniteConstants.WIZARD_AMPLIFIER);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(wizard, attacker);

        return Math.round(damage * IgniteConstants.WIZARD_AMPLIFIER);
    }

    @Override
    public final int getTotalDamageForWizard(final Hero wizard, final Hero otherHero) {
        return getDamageWithoutRaceModifier(wizard, otherHero);
    }

    protected final int getDamageWithoutRaceModifier(final Hero attacked, final Hero attacker) {
        float damage = IgniteConstants.BASE_DAMAGE
                + IgniteConstants.DAMAGE_PER_LEVEL * attacker.getLevel();

        final LocationType currentLocationType = getHeroLocation(attacked);

        if (currentLocationType == IgniteConstants.LOCATION_TYPE) {
            damage *= IgniteConstants.LOCATION_AMPLIFIER;
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
        float periodicDamage = IgniteConstants.DAMAGE_PER_ROUND
                + IgniteConstants.OVERTIME_DAMAGE_PER_LEVEL * attacker.getLevel();

        final LocationType currentLocationType = getHeroLocation(attacked);

        if (currentLocationType == IgniteConstants.LOCATION_TYPE) {
            periodicDamage *= IgniteConstants.LOCATION_AMPLIFIER;
        }

        final int finalPeriodicDamage = Math.round(Math.round(periodicDamage) * heroAmplifier);

        attacked.setDamageAndNumOfRounds(finalPeriodicDamage,
                IgniteConstants.NUM_OF_ROUNDS_OVERTIME);
    }

    protected final LocationType getHeroLocation(final Hero hero) {
        final Position position = hero.getPosition();
        final GameMap map = GameMap.getInstance();

        return map.getLocationsType(position.getLine(), position.getColumn());
    }

    protected static class IgniteConstants {
        public static final int BASE_DAMAGE = 150;
        public static final int DAMAGE_PER_LEVEL = 20;

        public static final int DAMAGE_PER_ROUND = 50;
        public static final int OVERTIME_DAMAGE_PER_LEVEL = 30;
        public static final int NUM_OF_ROUNDS_OVERTIME = 2;

        public static final LocationType LOCATION_TYPE = LocationType.Volcanic;
        public static final float LOCATION_AMPLIFIER = 1.25f;

        public static final float ROGUE_AMPLIFIER = 0.8f;
        public static final float KNIGHT_AMPLIFIER = 1.2f;
        public static final float PYROMANCER_AMPLIFIER = 0.9f;
        public static final float WIZARD_AMPLIFIER = 1.05f;
    }
}
