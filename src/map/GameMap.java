package map;

import common.Position;
import main.GameInput;

import java.util.ArrayList;
import java.util.List;

public final class GameMap {
    private static GameMap instance = null;
    private int lines;
    private int columns;
    private List<List<LocationType>> map;

    private GameMap() {
        final Position dim = GameInput.getMapDim();
        lines = dim.getLine();
        columns = dim.getColumn();

        final List<String> locationTypes = GameInput.getLandTypes();
        map = new ArrayList<>();

        for (final String str : locationTypes) {
            final List<LocationType> list = new ArrayList<>();

            for (int i = 0; i < str.length(); ++i) {
                final LocationType locationType = ChooseLocationType.chooseType(str.charAt(i));
                list.add(locationType);
            }

            map.add(list);
        }
    }

    public static GameMap getInstance() {
        if (instance == null) {
            instance = new GameMap();
        }
        return instance;
    }

    public LocationType getLocationsType(final int x, final int y) {
        return map.get(x).get(y);
    }
}
