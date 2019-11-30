package main;

import common.Position;

import java.util.List;

public class GameInput {
    private static Position mapDim;
    private static List<String> landTypes;
    private static List<String> heroesTypes;
    private static List<Position> heroesPositions;
    private List<String> roundMoves;

    GameInput() {
        mapDim = null;
        landTypes = null;
        heroesTypes = null;
        heroesPositions = null;
        roundMoves = null;
    }

    public GameInput(final Position mapDim, final List<String> landTypes,
                     final List<String> heroesTypes, final List<Position> heroesPositions,
                     final List<String> roundMoves) {
        GameInput.mapDim = mapDim;
        GameInput.landTypes = landTypes;
        GameInput.heroesTypes = heroesTypes;
        GameInput.heroesPositions = heroesPositions;
        this.roundMoves = roundMoves;
    }

    public static Position getMapDim() {
        return mapDim;
    }

    public static List<String> getLandTypes() {
        return landTypes;
    }

    public static List<String> getHeroesTypes() {
        return heroesTypes;
    }

    public static List<Position> getHeroesPositions() {
        return heroesPositions;
    }

    public final List<String> getRoundMoves() {
        return roundMoves;
    }
}
