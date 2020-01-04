package constants.constants_for_heroes;

import map.LocationType;

public final class ConstantsForWizard {
    public static final int INITIAL_HP = 400;
    public static final int HP_ADDED_PER_LEVEL = 30;

    public static final int HP_DEFENSE_DIVISOR = 5;
    public static final int HP_OFFENSE_DIVISOR = 10;

    public static final int HP_LOWER_LIMIT_STRATEGY_DIVISOR = 4;
    public static final int HP_UPPER_LIMIT_STRATEGY_DIVISOR = 2;

    public static final float OFFENSE_INCREASE_RACE_AMPLIFIER = 0.6f;
    public static final float DEFENSE_DECREASE_RACE_AMPLIFIER = 0.2f;

    public static class DeflectConstants {
        public static final float BASE_PERCENT = 0.35f;
        public static final float PERCENT_PER_LEVEL = 0.02f;
        public static final float MAX_PERCENT = 0.7f;

        public static final LocationType LOCATION_TYPE = LocationType.Desert;
        public static final float LOCATION_AMPLIFIER = 1.1f;

        public static final float ROGUE_AMPLIFIER = 1.2f;
        public static final float KNIGHT_AMPLIFIER = 1.4f;
        public static final float PYROMANCER_AMPLIFIER = 1.3f;
    }

    public static class DrainConstants {
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

    private ConstantsForWizard() {
    }
}
