package abilities.knight_abilities;

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

public class Execute implements Ability {
    protected float knightAmplifier;
    protected float pyromancerAmplifier;
    protected float rogueAmplifier;
    protected float wizardAmplifier;

    public Execute() {
        this.knightAmplifier = ConstantsForKnight.ExecuteConstants.KNIGHT_AMPLIFIER;
        this.pyromancerAmplifier = ConstantsForKnight.ExecuteConstants.PYROMANCER_AMPLIFIER;
        this.rogueAmplifier = ConstantsForKnight.ExecuteConstants.ROGUE_AMPLIFIER;
        this.wizardAmplifier = ConstantsForKnight.ExecuteConstants.WIZARD_AMPLIFIER;
    }

    @Override
    public final int applyAbility(final Knight knight, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(knight, attacker,
                ConstantsForKnight.INITIAL_HP, ConstantsForKnight.HP_ADDED_PER_LEVEL);

        return Math.round(damage * knightAmplifier);
    }

    @Override
    public final int applyAbility(final Pyromancer pyromancer, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(pyromancer, attacker,
                ConstantsForPyromancer.INITIAL_HP, ConstantsForPyromancer.HP_ADDED_PER_LEVEL);

        return Math.round(damage * pyromancerAmplifier);
    }

    @Override
    public final int applyAbility(final Rogue rogue, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(rogue, attacker,
                ConstantsForRogue.INITIAL_HP, ConstantsForRogue.HP_ADDED_PER_LEVEL);

        return Math.round(damage * rogueAmplifier);
    }

    @Override
    public final int applyAbility(final Wizard wizard, final Hero attacker) {
        final int damage = getDamageWithoutRaceModifier(wizard, attacker,
                ConstantsForWizard.INITIAL_HP, ConstantsForWizard.HP_ADDED_PER_LEVEL);

        return Math.round(damage * wizardAmplifier);
    }

    @Override
    public final int getTotalDamageForWizard(final Hero wizard, final Hero otherHero) {
        float damage = ConstantsForKnight.ExecuteConstants.BASE_DAMAGE
                + ConstantsForKnight.ExecuteConstants.DAMAGE_PER_LEVEL * otherHero.getLevel();

        final LocationType currentLocationType = getHeroLocation(wizard);

        if (currentLocationType == ConstantsForKnight.ExecuteConstants.LOCATION_TYPE) {
            damage *= ConstantsForKnight.ExecuteConstants.LOCATION_AMPLIFIER;
        }

        return Math.round(damage);
    }

    @Override
    public void increaseAmplifiersForStrategy() {
        knightAmplifier += ConstantsForKnight.OFFENSE_INCREASE_RACE_AMPLIFIER;
        pyromancerAmplifier += ConstantsForKnight.OFFENSE_INCREASE_RACE_AMPLIFIER;
        rogueAmplifier += ConstantsForKnight.OFFENSE_INCREASE_RACE_AMPLIFIER;
        wizardAmplifier += ConstantsForKnight.OFFENSE_INCREASE_RACE_AMPLIFIER;
    }

    @Override
    public void decreaseAmplifiersForStrategy() {
        knightAmplifier -= ConstantsForKnight.DEFENSE_DECREASE_RACE_AMPLIFIER;
        pyromancerAmplifier -= ConstantsForKnight.DEFENSE_DECREASE_RACE_AMPLIFIER;
        rogueAmplifier -= ConstantsForKnight.DEFENSE_DECREASE_RACE_AMPLIFIER;
        wizardAmplifier -= ConstantsForKnight.DEFENSE_DECREASE_RACE_AMPLIFIER;
    }

    @Override
    public void modifyAmplifiers(float percent) {
        // knightAmplifier += percent;
        pyromancerAmplifier += percent;
        rogueAmplifier += percent;
        wizardAmplifier += percent;
    }

    protected final int getDamageWithoutRaceModifier(final Hero attacked, final Hero attacker,
                                                     final int initialHp, final int hpAddedPerLevel) {
        final int attackerLevel = attacker.getLevel();

        final int opponentMaxHp = initialHp
                + hpAddedPerLevel * attacked.getLevel();

        float hpPercentLimit = ConstantsForKnight.ExecuteConstants.HP_BASE_LIMIT_PERCENT
                + ConstantsForKnight.ExecuteConstants.HP_LIMIT_PER_LEVEL * attackerLevel;

        if (hpPercentLimit > ConstantsForKnight.ExecuteConstants.HP_LIMIT_MAX) {
            hpPercentLimit = ConstantsForKnight.ExecuteConstants.HP_LIMIT_MAX;
        }

        final int hpLimit = Math.round(hpPercentLimit * opponentMaxHp);

        if (attacked.getHp() < hpLimit) {
            return attacked.getHp();
        }

        float damage = ConstantsForKnight.ExecuteConstants.BASE_DAMAGE
                + ConstantsForKnight.ExecuteConstants.DAMAGE_PER_LEVEL * attackerLevel;

        final LocationType currentLocationType = getHeroLocation(attacker);

        if (currentLocationType == ConstantsForKnight.ExecuteConstants.LOCATION_TYPE) {
            damage *= ConstantsForKnight.ExecuteConstants.LOCATION_AMPLIFIER;
        }

        return Math.round(damage);
    }

    protected final LocationType getHeroLocation(final Hero hero) {
        final Position position = hero.getPosition();
        final GameMap map = GameMap.getInstance();

        return map.getLocationsType(position.getLine(), position.getColumn());
    }
}
