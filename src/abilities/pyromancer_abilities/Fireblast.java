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

public class Fireblast implements Ability {

    @Override
    public final int applyAbility(final Knight knight, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(knight, attacker);

        return Math.round(damage * FireblastConstants.KNIGHT_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Pyromancer pyromancer, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(pyromancer, attacker);

        return Math.round(damage * FireblastConstants.PYROMANCER_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Rogue rogue, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(rogue, attacker);

        return Math.round(damage * FireblastConstants.ROGUE_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Wizard wizard, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(wizard, attacker);

        return Math.round(damage * FireblastConstants.WIZARD_AMPLIFIER);
    }

    @Override
    public final int getTotalDamageForWizard(final Hero wizard, final Hero otherHero) {
        return getDamageWithoutRaceModifier(wizard, otherHero);
    }

    protected final int getDamageWithoutRaceModifier(final Hero attacked, final Hero attacker) {
        final int attackerLevel = attacker.getLevel();
        float damage = FireblastConstants.BASE_DAMAGE
                + FireblastConstants.DAMAGE_PER_LEVEL * attackerLevel;

        final LocationType currentLocationType = getHeroLocation(attacked);

        if (currentLocationType == FireblastConstants.LOCATION_TYPE) {
            damage *= FireblastConstants.LOCATION_AMPLIFIER;
        }

        return Math.round(damage);
    }

    protected final LocationType getHeroLocation(final Hero hero) {
        final Position position = hero.getPosition();
        final GameMap map = GameMap.getInstance();

        return map.getLocationsType(position.getLine(), position.getColumn());
    }

    protected static class FireblastConstants {
        public static final int BASE_DAMAGE = 350;
        public static final int DAMAGE_PER_LEVEL = 50;

        public static final LocationType LOCATION_TYPE = LocationType.Volcanic;
        public static final float LOCATION_AMPLIFIER = 1.25f;

        public static final float ROGUE_AMPLIFIER = 0.8f;
        public static final float KNIGHT_AMPLIFIER = 1.2f;
        public static final float PYROMANCER_AMPLIFIER = 0.9f;
        public static final float WIZARD_AMPLIFIER = 1.05f;
    }
}
