package abilities.wizard_abilities;

import abilities.Ability;
import common.Position;
import constants.constants_for_heroes.ConstantsForWizard;
import hero.Hero;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;
import map.GameMap;
import map.LocationType;

import java.util.List;

public class Deflect implements Ability {
    protected float knightAmplifier;
    protected float pyromancerAmplifier;
    protected float rogueAmplifier;

    public Deflect() {
        this.knightAmplifier = ConstantsForWizard.DeflectConstants.KNIGHT_AMPLIFIER;
        this.pyromancerAmplifier = ConstantsForWizard.DeflectConstants.PYROMANCER_AMPLIFIER;
        this.rogueAmplifier = ConstantsForWizard.DeflectConstants.ROGUE_AMPLIFIER;
    }

    @Override
    public final int applyAbility(final Knight knight, final Hero attacker) {
        return getDamage(knight, attacker, knightAmplifier);
    }

    @Override
    public final int applyAbility(final Pyromancer pyromancer, final Hero attacker) {
        return getDamage(pyromancer, attacker, pyromancerAmplifier);
    }

    @Override
    public final int applyAbility(final Rogue rogue, final Hero attacker) {
        return getDamage(rogue, attacker, rogueAmplifier);
    }

    @Override
    public final int applyAbility(final Wizard wizard, final Hero attacker) {
        return 0;
    }

    @Override
    public final int getTotalDamageForWizard(final Hero wizard, final Hero otherHero) {
        return 0;
    }

    @Override
    public final void increaseAmplifiersForStrategy() {
        knightAmplifier += ConstantsForWizard.OFFENSE_INCREASE_RACE_AMPLIFIER;
        pyromancerAmplifier += ConstantsForWizard.OFFENSE_INCREASE_RACE_AMPLIFIER;
        rogueAmplifier += ConstantsForWizard.OFFENSE_INCREASE_RACE_AMPLIFIER;
    }

    @Override
    public final void decreaseAmplifiersForStrategy() {
        knightAmplifier -= ConstantsForWizard.DEFENSE_DECREASE_RACE_AMPLIFIER;
        pyromancerAmplifier -= ConstantsForWizard.DEFENSE_DECREASE_RACE_AMPLIFIER;
        rogueAmplifier -= ConstantsForWizard.DEFENSE_DECREASE_RACE_AMPLIFIER;
    }

    @Override
    public final void modifyAmplifiers(final float percent) {
        knightAmplifier += percent;
        pyromancerAmplifier += percent;
        rogueAmplifier += percent;
    }

    protected final int getDamage(final Hero attacked, final Hero attacker,
                                  final float heroAmplifier) {
        float newPercent = ConstantsForWizard.DeflectConstants.BASE_PERCENT
                + ConstantsForWizard.DeflectConstants.PERCENT_PER_LEVEL * attacker.getLevel();
        if (newPercent > ConstantsForWizard.DeflectConstants.MAX_PERCENT) {
            newPercent = ConstantsForWizard.DeflectConstants.MAX_PERCENT;
        }

        float damage = 0;
        final List<Ability> heroAbilities = attacked.getAbilities().getListOfAbilities();

        for (final Ability ability : heroAbilities) {
            damage += ability.getTotalDamageForWizard(attacker, attacked);
        }

        final LocationType currentLocationType = getHeroLocation(attacked);
        float locationAmplifier = 1;

        if (currentLocationType == ConstantsForWizard.DeflectConstants.LOCATION_TYPE) {
            locationAmplifier *= ConstantsForWizard.DeflectConstants.LOCATION_AMPLIFIER;
        }

        return Math.round(newPercent * damage * locationAmplifier * heroAmplifier);
    }

    protected final LocationType getHeroLocation(final Hero hero) {
        final Position position = hero.getPosition();
        final GameMap map = GameMap.getInstance();

        return map.getLocationsType(position.getLine(), position.getColumn());
    }


}
