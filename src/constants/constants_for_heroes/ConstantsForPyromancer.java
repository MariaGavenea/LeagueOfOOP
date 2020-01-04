package constants.constants_for_heroes;

import map.LocationType;

public final class ConstantsForPyromancer {
    public static final int INITIAL_HP = 500;
    public static final int HP_ADDED_PER_LEVEL = 50;

    public static final int HP_DEFENSE_DIVISOR = 3;
    public static final int HP_OFFENSE_DIVISOR = 4;

    public static final int HP_LOWER_LIMIT_STRATEGY_DIVISOR = 4;
    public static final int HP_UPPER_LIMIT_STRATEGY_DIVISOR = 3;

    public static final float OFFENSE_INCREASE_RACE_AMPLIFIER = 0.7f;
    public static final float DEFENSE_DECREASE_RACE_AMPLIFIER = 0.3f;

    public static class FireblastConstants {
        public static final int BASE_DAMAGE = 350;
        public static final int DAMAGE_PER_LEVEL = 50;

        public static final LocationType LOCATION_TYPE = LocationType.Volcanic;
        public static final float LOCATION_AMPLIFIER = 1.25f;

        public static final float ROGUE_AMPLIFIER = 0.8f;
        public static final float KNIGHT_AMPLIFIER = 1.2f;
        public static final float PYROMANCER_AMPLIFIER = 0.9f;
        public static final float WIZARD_AMPLIFIER = 1.05f;
    }

    public static class IgniteConstants {
        public static final int BASE_DAMAGE = 150;
        public static final int DAMAGE_PER_LEVEL = 20;

        public static final int DAMAGE_PER_ROUND = 50;
        public static final int OVERTIME_DAMAGE_PER_LEVEL = 30;
        public static final int NUM_OF_ROUNDS_OVERTIME = 2;

        public static final LocationType LOCATION_TYPE = LocationType.Volcanic;
        public static final float LOCATION_AMPLIFIER = 1.25f;

        public static final float ROGUE_AMPLIFIER = 0.8f;
        public static final float KNIGHT_AMPLIFIER = 1.2f;
        public static final float PYROMANCER_AMPLIFIER = 0.9f;
        public static final float WIZARD_AMPLIFIER = 1.05f;
    }

    private ConstantsForPyromancer() {
    }
}

