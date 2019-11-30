package abilities.wizard_abilities;

import abilities.Ability;
import common.Position;
import constants.ConstantsForKnight;
import constants.ConstantsForPyromancer;
import constants.ConstantsForRogue;
import constants.ConstantsForWizard;
import hero.Hero;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;
import map.GameMap;
import map.LocationType;

public class Drain implements Ability {

    @Override
    public final int applyAbility(final Knight knight, final Hero attacker) {
        return getDamage(knight, attacker, ConstantsForKnight.INITIAL_HP,
                ConstantsForKnight.HP_ADDED_PER_LEVEL, DrainConstants.KNIGHT_PERCENT);
    }

    @Override
    public final int applyAbility(final Pyromancer pyromancer, final Hero attacker) {
        return getDamage(pyromancer, attacker, ConstantsForPyromancer.INITIAL_HP,
                ConstantsForPyromancer.HP_ADDED_PER_LEVEL, DrainConstants.PYROMANCER_PERCENT);
    }

    @Override
    public final int applyAbility(final Rogue rogue, final Hero attacker) {
        return getDamage(rogue, attacker, ConstantsForRogue.INITIAL_HP,
                ConstantsForRogue.HP_ADDED_PER_LEVEL, DrainConstants.ROGUE_PERCENT);
    }

    @Override
    public final int applyAbility(final Wizard wizard, final Hero attacker) {
        return getDamage(wizard, attacker, ConstantsForWizard.INITIAL_HP,
                ConstantsForWizard.HP_ADDED_PER_LEVEL, DrainConstants.WIZARD_PERCENT);
    }

    @Override
    public final int getTotalDamageForWizard(final Hero wizard, final Hero otherWizard) {
        return 0;
    }

    protected final int getDamage(final Hero attacked, final Hero attacker,
                                  final int initialHp, final int hpAddedPerLevel, final float heroPercent) {
        final int opponentCurrentHp = attacked.getHp();
        final int opponentMaxHp = initialHp + attacked.getLevel() * hpAddedPerLevel;

        final float minimum = Math.min(DrainConstants.OPPONENT_MAX_HP_AMPLIFIER
                * opponentMaxHp, opponentCurrentHp);

        float amplifier = DrainConstants.BASE_AMPLIFIER
                + DrainConstants.AMPLIFIER_PER_LEVEL * attacker.getLevel();
        amplifier += heroPercent * amplifier;

        final LocationType currentLocationType = getHeroLocation(attacked);

        if (currentLocationType == DrainConstants.LOCATION_TYPE) {
            amplifier *= DrainConstants.LOCATION_AMPLIFIER;
        }

        return Math.round(amplifier * minimum);

    }

    protected final LocationType getHeroLocation(final Hero hero) {
        final Position position = hero.getPosition();
        final GameMap map = GameMap.getInstance();

        return map.getLocationsType(position.getLine(), position.getColumn());
    }

    protected static class DrainConstants {
        public static final float BASE_AMPLIFIER = 0.2f;
        public static final float AMPLIFIER_PER_LEVEL = 0.05f;

        public static final LocationType LOCATION_TYPE = LocationType.Desert;
        public static final float LOCATION_AMPLIFIER = 1.1f;

        public static final float OPPONENT_MAX_HP_AMPLIFIER = 0.3f;

        public static final float ROGUE_PERCENT = -0.2f;
        public static final float KNIGHT_PERCENT = 0.2f;
        public static final float PYROMANCER_PERCENT = -0.1f;
        public static final float WIZARD_PERCENT = 0.05f;
    }
}
