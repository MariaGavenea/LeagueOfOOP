package game;

import angel.Angel;
import angel.angels.AngelsFactory;
import game.game_actions.execute_strategies.ExecuteStrategies;
import game.game_actions.fight.Fight;
import game.game_actions.move.MoveHeroes;
import hero.Hero;
import hero.heroes.HeroesFactory;
import magician.GreatMagician;
import magician.Observer;
import magician.Subject;
import main.GameInput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Game extends Subject {
    private HeroesFactory heroes;
    private List<String> allRoundMoves;
    private int numOfRounds;
    private List<List<String>> angelsInfo;
    private String filePath;

    public Game(final GameInput gameInput, final String filePath) {
        heroes = HeroesFactory.getInstance();
        allRoundMoves = gameInput.getRoundMoves();
        numOfRounds = allRoundMoves.size();
        angelsInfo = gameInput.getAngelsInfo();
        this.filePath = filePath;
    }

    public final void startGame() throws IOException {
        FileWriter fw = new FileWriter(filePath);
        final Observer greatMagiciansObsForGame = new GreatMagician(this, fw);

        for (int i = 0; i < numOfRounds; i++) {
            fw.write("~~ Round " + (i + 1) + " ~~\n");

            // apply overtime damages
            final Fight fight = new Fight(heroes, fw);
            fight.applyOvertimeDamages();

            // apply strategies
            final ExecuteStrategies executeStrategies = new ExecuteStrategies(heroes);
            executeStrategies.executeStrategies();

            // move
            final MoveHeroes moveHeroes = new MoveHeroes(heroes, allRoundMoves.get(i));
            moveHeroes.move();

            // fight
            Observer greatMagiciansObsForFight = new GreatMagician(fight, fw);
            fight.chooseFightersAndFight();

            final AngelsFactory angelsFactory = new AngelsFactory(angelsInfo.get(i));
            for (int j = 0; j < angelsFactory.getSize(); ++j) {
                final Angel angel = angelsFactory.getAngelAt(j);
                this.setMessage("Angel " + angel.getAngelType() + " was spawned at "
                        + angel.getPosition() + "\n");

                final Observer greatMagiciansObsForAngel = new GreatMagician(angel, fw);
                for (int k = 0; k < heroes.getSize(); ++k) {
                    Hero hero = heroes.getHeroAt(k);
                    if (angel.getPosition().equals(hero.getPosition())) {
                        hero.acceptVisit(angel);
                    }
                }
            }

            fw.write("\n");
        }

        fw.write("~~ Results ~~\n");
        for (int i = 0; i < heroes.getSize(); ++i) {
            fw.write(heroes.getHeroAt(i).getInfoForPrint());
            fw.write("\n");
        }

        fw.close();
    }
}
