package main;

import common.Position;

import java.util.List;

public class GameInput {
    private static Position mapDim;
    private static List<String> landTypes;
    private static List<String> heroesTypes;
    private static List<Position> heroesPositions;
    private static List<String> roundMoves;

    GameInput() {
        mapDim = null;
        landTypes = null;
        heroesTypes = null;
        heroesPositions = null;
        roundMoves = null;
    }

    public GameInput(Position mapDim, List<String> landTypes, List<String> heroesTypes,
                     List<Position> heroesPositions, List<String> roundMoves) {
        GameInput.mapDim = mapDim;
        GameInput.landTypes = landTypes;
        GameInput.heroesTypes = heroesTypes;
        GameInput.heroesPositions = heroesPositions;
        GameInput.roundMoves = roundMoves;
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

    public static List<String> getRoundMoves() {
        return roundMoves;
    }

    @Override
    public String toString() {
        return "GameInput{" +
                "mapDim=" + mapDim +
                ", landTypes=" + landTypes +
                ", heroesTypes=" + heroesTypes +
                ", heroesPositions=" + heroesPositions +
                ", roundMoves=" + roundMoves +
                '}';
    }
}
