package map;

public final class ChooseLocationType {

    private ChooseLocationType() {
    }

    public static LocationType chooseType(final Character ch) {
        switch (ch) {
            case 'L':
                return LocationType.Land;

            case 'D':
                return LocationType.Desert;

            case 'W':
                return LocationType.Woods;

            case 'V':
                return LocationType.Volcanic;

            default:
                return LocationType.Undefined;
        }
    }
}