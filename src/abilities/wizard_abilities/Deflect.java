package abilities.wizard_abilities;

import abilities.Ability;
import common.Position;
import hero.Hero;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;
import map.GameMap;
import map.LocationType;

import java.util.List;

public class Deflect implements Ability {

    @Override
    public final int applyAbility(final Knight knight, final Hero attacker) {
        return getDamage(knight, attacker, DeflectConstants.KNIGHT_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Pyromancer pyromancer, final Hero attacker) {
        return getDamage(pyromancer, attacker, DeflectConstants.PYROMANCER_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Rogue rogue, final Hero attacker) {
        return getDamage(rogue, attacker, DeflectConstants.ROGUE_AMPLIFIER);
    }

    @Override
    public final int applyAbility(final Wizard wizard, final Hero attacker) {
        return 0;
    }

    @Override
    public final int getTotalDamageForWizard(final Hero wizard, final Hero otherHero) {
        return 0;
    }

    protected final int getDamage(final Hero attacked, final Hero attacker,
                                  final float heroAmplifier) {
        float newPercent = DeflectConstants.BASE_PERCENT
                + DeflectConstants.PERCENT_PER_LEVEL * attacker.getLevel();
        if (newPercent > DeflectConstants.MAX_PERCENT) {
            newPercent = DeflectConstants.MAX_PERCENT;
        }

        int damage = 0;
        final List<Ability> heroAbilities = attacked.getAbilities().getListOfAbilities();

        for (final Ability ability : heroAbilities) {
            damage += ability.getTotalDamageForWizard(attacker, attacked);
        }

        final LocationType currentLocationType = getHeroLocation(attacked);
        float locationAmplifier = 1;

        if (currentLocationType == DeflectConstants.LOCATION_TYPE) {
            locationAmplifier *= DeflectConstants.LOCATION_AMPLIFIER;
        }

        return Math.round(newPercent * damage * locationAmplifier * heroAmplifier);
    }

    protected final LocationType getHeroLocation(final Hero hero) {
        final Position position = hero.getPosition();
        final GameMap map = GameMap.getInstance();

        return map.getLocationsType(position.getLine(), position.getColumn());
    }

    protected static class DeflectConstants {
        public static final float BASE_PERCENT = 0.35f;
        public static final float PERCENT_PER_LEVEL = 0.02f;
        public static final float MAX_PERCENT = 0.7f;

        public static final LocationType LOCATION_TYPE = LocationType.Desert;
        public static final float LOCATION_AMPLIFIER = 1.1f;

        public static final float ROGUE_AMPLIFIER = 1.2f;
        public static final float KNIGHT_AMPLIFIER = 1.4f;
        public static final float PYROMANCER_AMPLIFIER = 1.3f;
    }
}
