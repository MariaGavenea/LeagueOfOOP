package abilities.rogue_abilities;

import abilities.Ability;
import common.Position;
import hero.Hero;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;
import map.GameMap;
import map.LocationType;

public class Paralysis implements Ability {

    @Override
    public final int applyAbility(final Knight knight, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(knight, attacker, ParalysisConstants.KNIGHT_AMPLIFIER);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(knight, attacker);

        return Math.round(damage * ParalysisConstants.KNIGHT_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Pyromancer pyromancer, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(pyromancer, attacker, ParalysisConstants.PYROMANCER_AMPLIFIER);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(pyromancer, attacker);

        return Math.round(damage * ParalysisConstants.PYROMANCER_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Rogue rogue, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(rogue, attacker, ParalysisConstants.ROGUE_AMPLIFIER);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(rogue, attacker);

        return Math.round(damage * ParalysisConstants.ROGUE_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Wizard wizard, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(wizard, attacker, ParalysisConstants.WIZARD_AMPLIFIER);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(wizard, attacker);

        return Math.round(damage * ParalysisConstants.WIZARD_AMPLIFIER);
    }

    @Override
    public final int getTotalDamageForWizard(final Hero wizard, final Hero otherHero) {
        return getDamageWithoutRaceModifier(wizard, otherHero);
    }

    protected final int getDamageWithoutRaceModifier(final Hero attacked, final Hero attacker) {
        float damage = ParalysisConstants.BASE_DAMAGE
                + ParalysisConstants.DAMAGE_PER_LEVEL * attacker.getLevel();

        final LocationType currentLocationType = getHeroLocation(attacked);


        if (currentLocationType == ParalysisConstants.LOCATION_TYPE) {
            damage *= ParalysisConstants.LOCATION_AMPLIFIER;
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
        int numOfRoundsOvertime = ParalysisConstants.NUM_OF_ROUNDS_OVERTIME;

        if (currentLocationType == ParalysisConstants.LOCATION_TYPE) {
            numOfRoundsOvertime = ParalysisConstants.NUM_OF_ROUNDS_OVERTIME_IF_ON_WOODS;
        }

        attacked.setDamageAndNumOfRounds(finalDamage, numOfRoundsOvertime);
        attacked.setNumOfRoundsCantMove(numOfRoundsOvertime);
    }

    protected final LocationType getHeroLocation(final Hero hero) {
        final Position position = hero.getPosition();
        final GameMap map = GameMap.getInstance();

        return map.getLocationsType(position.getLine(), position.getColumn());
    }

    protected static class ParalysisConstants {
        public static final int BASE_DAMAGE = 40;
        public static final int DAMAGE_PER_LEVEL = 10;

        public static final LocationType LOCATION_TYPE = LocationType.Woods;
        public static final float LOCATION_AMPLIFIER = 1.15f;

        public static final int NUM_OF_ROUNDS_OVERTIME = 3;
        public static final int NUM_OF_ROUNDS_OVERTIME_IF_ON_WOODS = 6;

        public static final float ROGUE_AMPLIFIER = 0.9f;
        public static final float KNIGHT_AMPLIFIER = 0.8f;
        public static final float PYROMANCER_AMPLIFIER = 1.2f;
        public static final float WIZARD_AMPLIFIER = 1.25f;
    }
}
