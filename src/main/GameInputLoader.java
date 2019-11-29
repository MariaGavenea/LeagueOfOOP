package main;

import common.Position;
import fileio.FileSystem;

import java.util.ArrayList;
import java.util.List;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        List<String> landTypes = null;
        List<String> heroesTypes = null;
        List<Position> heroesPositions = null;
        List<String> roundMoves = null;
        Position mapDim = null;
        int numRows = 0;
        int numColumns = 0;
        int numHeroes = 0;
        int numRounds = 0;

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            numRows = fs.nextInt();
            numColumns = fs.nextInt();
            mapDim = new Position(numRows, numColumns);
            landTypes = new ArrayList<>(numRows);

            for (int i = 0; i < numRows; ++i) {
                landTypes.add(fs.nextWord());
            }

            numHeroes = fs.nextInt();
            heroesTypes = new ArrayList<>(numHeroes);
            heroesPositions = new ArrayList<>(numHeroes);

            for (int i = 0; i < numHeroes; ++i) {
                heroesTypes.add(fs.nextWord());
                heroesPositions.add(new Position(fs.nextInt(), fs.nextInt()));
            }

            numRounds = fs.nextInt();
            roundMoves = new ArrayList<>(numRounds);

            for (int i = 0; i < numRounds; ++i) {
                roundMoves.add(fs.nextWord());
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(mapDim, landTypes, heroesTypes, heroesPositions, roundMoves);
    }
}
