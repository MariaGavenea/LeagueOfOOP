package abilities.pyromancer_abilities;

import abilities.Ability;
import common.Position;
import constants.ConstantsForPyromancer;
import hero.Hero;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;
import map.GameMap;
import map.LocationType;

public class Fireblast implements Ability {
    protected float knightAmplifier;
    protected float pyromancerAmplifier;
    protected float rogueAmplifier;
    protected float wizardAmplifier;

    public Fireblast() {
        this.knightAmplifier = ConstantsForPyromancer.FireblastConstants.KNIGHT_AMPLIFIER;
        this.pyromancerAmplifier = ConstantsForPyromancer.FireblastConstants.PYROMANCER_AMPLIFIER;
        this.rogueAmplifier = ConstantsForPyromancer.FireblastConstants.ROGUE_AMPLIFIER;
        this.wizardAmplifier = ConstantsForPyromancer.FireblastConstants.WIZARD_AMPLIFIER;
    }

    @Override
    public final int applyAbility(final Knight knight, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(knight, attacker);

        return Math.round(damage * knightAmplifier);
    }

    @Override
    public final int applyAbility(final Pyromancer pyromancer, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(pyromancer, attacker);

        return Math.round(damage * pyromancerAmplifier);
    }

    @Override
    public final int applyAbility(final Rogue rogue, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(rogue, attacker);

        return Math.round(damage * rogueAmplifier);
    }

    @Override
    public final int applyAbility(final Wizard wizard, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(wizard, attacker);

        return Math.round(damage * wizardAmplifier);
    }

    @Override
    public final int getTotalDamageForWizard(final Hero wizard, final Hero otherHero) {
        return getDamageWithoutRaceModifier(wizard, otherHero);
    }

    @Override
    public void increaseAmplifiers() {
        knightAmplifier += ConstantsForPyromancer.OFFENSE_INCREASE_RACE_AMPLIFIER;
        pyromancerAmplifier += ConstantsForPyromancer.OFFENSE_INCREASE_RACE_AMPLIFIER;
        rogueAmplifier += ConstantsForPyromancer.OFFENSE_INCREASE_RACE_AMPLIFIER;
        wizardAmplifier += ConstantsForPyromancer.OFFENSE_INCREASE_RACE_AMPLIFIER;
    }

    @Override
    public void decreaseAmplifiers() {
        knightAmplifier -= ConstantsForPyromancer.DEFENSE_DECREASE_RACE_AMPLIFIER;
        pyromancerAmplifier -= ConstantsForPyromancer.DEFENSE_DECREASE_RACE_AMPLIFIER;
        rogueAmplifier -= ConstantsForPyromancer.DEFENSE_DECREASE_RACE_AMPLIFIER;
        wizardAmplifier -= ConstantsForPyromancer.DEFENSE_DECREASE_RACE_AMPLIFIER;
    }

    protected final int getDamageWithoutRaceModifier(final Hero attacked, final Hero attacker) {
        final int attackerLevel = attacker.getLevel();
        float damage = ConstantsForPyromancer.FireblastConstants.BASE_DAMAGE
                + ConstantsForPyromancer.FireblastConstants.DAMAGE_PER_LEVEL * attackerLevel;

        final LocationType currentLocationType = getHeroLocation(attacked);

        if (currentLocationType == ConstantsForPyromancer.FireblastConstants.LOCATION_TYPE) {
            damage *= ConstantsForPyromancer.FireblastConstants.LOCATION_AMPLIFIER;
        }

        return Math.round(damage);
    }

    protected final LocationType getHeroLocation(final Hero hero) {
        final Position position = hero.getPosition();
        final GameMap map = GameMap.getInstance();

        return map.getLocationsType(position.getLine(), position.getColumn());
    }


}
