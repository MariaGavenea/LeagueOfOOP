package main;

import game.Game;

import java.io.IOException;

public final class Main {

    private Main() {
    }

    public static void main(final String[] args) throws IOException {
        final GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        final GameInput gameInput = gameInputLoader.load();

        final Game game = new Game(gameInput);
        game.startGame();
        game.printFinalResults(args[1]);
    }
}
