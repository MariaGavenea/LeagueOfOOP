package abilities.knight_abilities;

import abilities.Ability;
import common.Position;
import hero.Hero;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;
import map.GameMap;
import map.LocationType;

public class Slam implements Ability {

    @Override
    public final int applyAbility(final Knight knight, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(knight);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(knight, attacker);

        return Math.round(damage * SlamConstants.KNIGHT_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Pyromancer pyromancer, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(pyromancer);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(pyromancer, attacker);

        return Math.round(damage * SlamConstants.PYROMANCER_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Rogue rogue, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(rogue);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(rogue, attacker);

        return Math.round(damage * SlamConstants.ROGUE_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Wizard wizard, final Hero attacker) {
        // reset overtime effects
        resetOvertimeEffects(wizard);

        // Compute current round damage
        int damage = getDamageWithoutRaceModifier(wizard, attacker);

        return Math.round(damage * SlamConstants.WIZARD_AMPLIFIER);
    }

    @Override
    public final int getTotalDamageForWizard(final Hero wizard, final Hero otherHero) {
        return getDamageWithoutRaceModifier(wizard, otherHero);
    }

    protected final int getDamageWithoutRaceModifier(final Hero attacked, final Hero attacker) {
        int damage = SlamConstants.BASE_DAMAGE
                + SlamConstants.DAMAGE_PER_LEVEL * attacker.getLevel();

        final LocationType currentLocationType = getHeroLocation(attacked);

        if (currentLocationType == SlamConstants.LOCATION_TYPE) {
            damage = Math.round(damage * SlamConstants.LOCATION_AMPLIFIER);
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

        hero.setNumOfRoundsCantMove(SlamConstants.NUM_OF_ROUNDS_OVERTIME);
    }

    protected static class SlamConstants {
        public static final int BASE_DAMAGE = 100;
        public static final int DAMAGE_PER_LEVEL = 40;

        public static final LocationType LOCATION_TYPE = LocationType.Land;
        public static final float LOCATION_AMPLIFIER = 1.15f;

        public static final int NUM_OF_ROUNDS_OVERTIME = 1;

        public static final float ROGUE_AMPLIFIER = 0.8f;
        public static final float KNIGHT_AMPLIFIER = 1.2f;
        public static final float PYROMANCER_AMPLIFIER = 0.9f;
        public static final float WIZARD_AMPLIFIER = 1.05f;
    }
}
