package constants;

import map.LocationType;

public final class ConstantsForRogue {
    public static final int INITIAL_HP = 600;
    public static final int HP_ADDED_PER_LEVEL = 40;

    public static final int HP_DEFENSE_DIVISOR = 2;
    public static final int HP_OFFENSE_DIVISOR = 7;

    public static final float OFFENSE_INCREASE_RACE_AMPLIFIER = 0.4f;
    public static final float DEFENSE_DECREASE_RACE_AMPLIFIER = 0.1f;

    public static class BackstabConstants {
        public static final int BASE_DAMAGE = 200;
        public static final int DAMAGE_PER_LEVEL = 20;

        public static final LocationType LOCATION_TYPE = LocationType.Woods;
        public static final float LOCATION_AMPLIFIER = 1.15f;

        public static final float CRITICAL_AMPLIFIER = 1.5f;
        public static final int HIT_NUMBER_FOR_CRITICAL = 3;

        public static final float ROGUE_AMPLIFIER = 1.2f;
        public static final float KNIGHT_AMPLIFIER = 0.9f;
        public static final float PYROMANCER_AMPLIFIER = 1.25f;
        public static final float WIZARD_AMPLIFIER = 1.25f;
    }

    public static class ParalysisConstants {
        public static final int BASE_DAMAGE = 40;
        public static final int DAMAGE_PER_LEVEL = 10;

        public static final LocationType LOCATION_TYPE = LocationType.Woods;
        public static final float LOCATION_AMPLIFIER = 1.15f;

        public static final int NUM_OF_ROUNDS_OVERTIME = 3;
        public static final int NUM_OF_ROUNDS_OVERTIME_IF_ON_WOODS = 6;

        public static final float ROGUE_AMPLIFIER = 0.9f;
        public static final float KNIGHT_AMPLIFIER = 0.8f;
        public static final float PYROMANCER_AMPLIFIER = 1.2f;
        public static final float WIZARD_AMPLIFIER = 1.25f;
    }

    private ConstantsForRogue() {
    }
}
