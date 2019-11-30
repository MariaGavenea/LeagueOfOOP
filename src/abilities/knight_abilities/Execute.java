package abilities.knight_abilities;

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

public class Execute implements Ability {

    @Override
    public final int applyAbility(final Knight knight, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(knight, attacker,
                ConstantsForKnight.INITIAL_HP, ConstantsForKnight.HP_ADDED_PER_LEVEL);

        return Math.round(damage * ExecuteConstants.KNIGHT_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Pyromancer pyromancer, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(pyromancer, attacker,
                ConstantsForPyromancer.INITIAL_HP, ConstantsForPyromancer.HP_ADDED_PER_LEVEL);

        return Math.round(damage * ExecuteConstants.PYROMANCER_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Rogue rogue, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(rogue, attacker,
                ConstantsForRogue.INITIAL_HP, ConstantsForRogue.HP_ADDED_PER_LEVEL);

        return Math.round(damage * ExecuteConstants.ROGUE_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Wizard wizard, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(wizard, attacker,
                ConstantsForWizard.INITIAL_HP, ConstantsForWizard.HP_ADDED_PER_LEVEL);

        return Math.round(damage * ExecuteConstants.WIZARD_AMPLIFIER);
    }

    @Override
    public final int getTotalDamageForWizard(final Hero wizard, final Hero otherHero) {
        return getDamageWithoutRaceModifier(wizard, otherHero,
                ConstantsForWizard.INITIAL_HP, ConstantsForWizard.HP_ADDED_PER_LEVEL);
    }

    protected final int getDamageWithoutRaceModifier(final Hero attacked, final Hero attacker,
                                                     final int initialHp, final int hpAddedPerLevel) {
        final int attackerLevel = attacker.getLevel();

        final int opponentMaxHp = initialHp
                + hpAddedPerLevel * attacked.getLevel();

        float hpPercentLimit = ExecuteConstants.HP_BASE_LIMIT_PERCENT
                + ExecuteConstants.HP_LIMIT_PER_LEVEL * attackerLevel;

        if (hpPercentLimit > ExecuteConstants.HP_LIMIT_MAX) {
            hpPercentLimit = ExecuteConstants.HP_LIMIT_MAX;
        }

        final int hpLimit = Math.round(hpPercentLimit * opponentMaxHp);

        if (attacked.getHp() < hpLimit) {
            return attacked.getHp();
        }

        float damage = ExecuteConstants.BASE_DAMAGE
                + ExecuteConstants.DAMAGE_PER_LEVEL * attackerLevel;

        final LocationType currentLocationType = getHeroLocation(attacker);

        if (currentLocationType == ExecuteConstants.LOCATION_TYPE) {
            damage *= ExecuteConstants.LOCATION_AMPLIFIER;
        }

        return Math.round(damage);
    }

    protected final LocationType getHeroLocation(final Hero hero) {
        final Position position = hero.getPosition();
        final GameMap map = GameMap.getInstance();

        return map.getLocationsType(position.getLine(), position.getColumn());
    }

    protected static class ExecuteConstants {
        public static final int BASE_DAMAGE = 200;
        public static final int DAMAGE_PER_LEVEL = 30;

        public static final float HP_BASE_LIMIT_PERCENT = 0.2f;
        public static final float HP_LIMIT_PER_LEVEL = 0.01f;
        public static final float HP_LIMIT_MAX = 0.4f;

        public static final LocationType LOCATION_TYPE = LocationType.Land;
        public static final float LOCATION_AMPLIFIER = 1.15f;

        public static final float ROGUE_AMPLIFIER = 1.15f;
        public static final float KNIGHT_AMPLIFIER = 1f;
        public static final float PYROMANCER_AMPLIFIER = 1.1f;
        public static final float WIZARD_AMPLIFIER = 0.8f;
    }
}
