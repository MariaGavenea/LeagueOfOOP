package constants.constants_for_heroes;

import map.LocationType;

public final class ConstantsForKnight {
    public static final int INITIAL_HP = 900;
    public static final int HP_ADDED_PER_LEVEL = 80;

    public static final int HP_DEFENSE_DIVISOR = 4;
    public static final int HP_OFFENSE_DIVISOR = 5;

    public static final float OFFENSE_INCREASE_RACE_AMPLIFIER = 0.5f;
    public static final float DEFENSE_DECREASE_RACE_AMPLIFIER = 0.2f;

    public static class ExecuteConstants {
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

    public static class SlamConstants {
        public static final int BASE_DAMAGE = 100;
        public static final int DAMAGE_PER_LEVEL = 40;

        public static final LocationType LOCATION_TYPE = LocationType.Land;
        public static final float LOCATION_AMPLIFIER = 1.15f;

        public static final int NUM_OF_ROUNDS_OVERTIME = 1;

        public static final float ROGUE_AMPLIFIER = 0.8f;
        public static final float KNIGHT_AMPLIFIER = 1.2f;
        public static final float PYROMANCER_AMPLIFIER = 0.9f;
        public static final float WIZARD_AMPLIFIER = 1.05f;
    }

    private ConstantsForKnight() {
    }

}
