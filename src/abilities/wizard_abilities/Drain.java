package abilities.wizard_abilities;

import abilities.Ability;
import common.Position;
import constants.constants_for_heroes.ConstantsForKnight;
import constants.constants_for_heroes.ConstantsForPyromancer;
import constants.constants_for_heroes.ConstantsForRogue;
import constants.constants_for_heroes.ConstantsForWizard;
import hero.Hero;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;
import map.GameMap;
import map.LocationType;

public class Drain implements Ability {
    protected float knightPercent;
    protected float pyromancerPercent;
    protected float roguePercent;
    protected float wizardPercent;

    public Drain() {
        this.knightPercent = ConstantsForWizard.DrainConstants.KNIGHT_PERCENT;
        this.pyromancerPercent = ConstantsForWizard.DrainConstants.PYROMANCER_PERCENT;
        this.roguePercent = ConstantsForWizard.DrainConstants.ROGUE_PERCENT;
        this.wizardPercent = ConstantsForWizard.DrainConstants.WIZARD_PERCENT;
    }

    @Override
    public final int applyAbility(final Knight knight, final Hero attacker) {
        return getDamage(knight, attacker, ConstantsForKnight.INITIAL_HP,
                ConstantsForKnight.HP_ADDED_PER_LEVEL, knightPercent);
    }

    @Override
    public final int applyAbility(final Pyromancer pyromancer, final Hero attacker) {
        return getDamage(pyromancer, attacker, ConstantsForPyromancer.INITIAL_HP,
                ConstantsForPyromancer.HP_ADDED_PER_LEVEL, pyromancerPercent);
    }

    @Override
    public final int applyAbility(final Rogue rogue, final Hero attacker) {
        return getDamage(rogue, attacker, ConstantsForRogue.INITIAL_HP,
                ConstantsForRogue.HP_ADDED_PER_LEVEL, roguePercent);
    }

    @Override
    public final int applyAbility(final Wizard wizard, final Hero attacker) {
        return getDamage(wizard, attacker, ConstantsForWizard.INITIAL_HP,
                ConstantsForWizard.HP_ADDED_PER_LEVEL, wizardPercent);
    }

    @Override
    public final int getTotalDamageForWizard(final Hero wizard, final Hero otherWizard) {
        return 0;
    }

    @Override
    public void increaseAmplifiersForStrategy() {
        knightPercent += ConstantsForWizard.OFFENSE_INCREASE_RACE_AMPLIFIER;
        pyromancerPercent += ConstantsForWizard.OFFENSE_INCREASE_RACE_AMPLIFIER;
        roguePercent += ConstantsForWizard.OFFENSE_INCREASE_RACE_AMPLIFIER;
        wizardPercent += ConstantsForWizard.OFFENSE_INCREASE_RACE_AMPLIFIER;
    }

    @Override
    public void decreaseAmplifiersForStrategy() {
        knightPercent -= ConstantsForWizard.DEFENSE_DECREASE_RACE_AMPLIFIER;
        pyromancerPercent -= ConstantsForWizard.DEFENSE_DECREASE_RACE_AMPLIFIER;
        roguePercent -= ConstantsForWizard.DEFENSE_DECREASE_RACE_AMPLIFIER;
        wizardPercent -= ConstantsForWizard.DEFENSE_DECREASE_RACE_AMPLIFIER;
    }

    @Override
    public void modifyAmplifiers(float percent) {
        knightPercent += percent;
        pyromancerPercent += percent;
        roguePercent += percent;
        wizardPercent += percent;
    }

    protected final int getDamage(final Hero attacked, final Hero attacker, final int initialHp,
                                  final int hpAddedPerLevel, final float heroPercent) {
        final int opponentCurrentHp = attacked.getHp();
        final int opponentMaxHp = initialHp + attacked.getLevel() * hpAddedPerLevel;

        final float minimum = Math.min(ConstantsForWizard.DrainConstants.OPPONENT_MAX_HP_AMPLIFIER
                * opponentMaxHp, opponentCurrentHp);

        float amplifier = ConstantsForWizard.DrainConstants.BASE_AMPLIFIER
                + ConstantsForWizard.DrainConstants.AMPLIFIER_PER_LEVEL * attacker.getLevel();
        amplifier += heroPercent * amplifier;

        final LocationType currentLocationType = getHeroLocation(attacked);

        if (currentLocationType == ConstantsForWizard.DrainConstants.LOCATION_TYPE) {
            amplifier *= ConstantsForWizard.DrainConstants.LOCATION_AMPLIFIER;
        }

        return Math.round(amplifier * minimum);

    }

    protected final LocationType getHeroLocation(final Hero hero) {
        final Position position = hero.getPosition();
        final GameMap map = GameMap.getInstance();

        return map.getLocationsType(position.getLine(), position.getColumn());
    }
}
