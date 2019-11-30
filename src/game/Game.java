package game;

import game.game_actions.fight.Fight;
import game.game_actions.move.MoveHeroes;
import hero.heroes.HeroesFactory;
import main.GameInput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Game {
    private HeroesFactory heroes;
    private List<String> allRoundMoves;
    private int numOfRounds;

    public Game(final GameInput gameInput) {
        heroes = HeroesFactory.getInstance();
        allRoundMoves = gameInput.getRoundMoves();
        numOfRounds = allRoundMoves.size();
    }

    public final void startGame() {
        final Fight fight = new Fight(heroes);

        for (int i = 0; i < numOfRounds; i++) {
            // move
            final MoveHeroes moveHeroes = new MoveHeroes(heroes, allRoundMoves.get(i));
            moveHeroes.move();

            // fight
            fight.applyOvertimeDamages();
            fight.chooseFightersAndFight();
        }
    }

    public final void printFinalResults(final String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);

        for (int i = 0; i < heroes.getSize(); ++i) {
            fw.write(heroes.getHeroAt(i).getInfoForPrint());
            fw.write("\n");
        }

        fw.close();
    }
}
