package game.game_actions.move;

import common.Position;
import hero.Hero;
import hero.HeroStatus;
import hero.heroes.HeroesFactory;

public class MoveHeroes {
    private HeroesFactory heroes;
    private String roundMoves;

    public MoveHeroes(final HeroesFactory heroes, final String roundMoves) {
        this.heroes = heroes;
        this.roundMoves = roundMoves;
    }

    public final void move() {
        for (int i = 0; i < heroes.getSize(); ++i) {
            if (heroes.getHeroAt(i).getStatus().equals(HeroStatus.alive)) {
                moveHero(heroes.getHeroAt(i), roundMoves.charAt(i));
            }
        }
    }

    protected final void moveHero(final Hero hero, final Character direction) {
        if (hero.getNumOfRoundsCantMove() > 0) {
            hero.decreaseNumOfRoundsCantMove();
            return;
        }

        final Position move = ChooseDirection.chooseDir(direction);

        final Position heroPosition = hero.getPosition();
        final int currentLine = heroPosition.getLine();
        final int currentColumn = heroPosition.getColumn();

        heroPosition.setPosition(currentLine + move.getLine(),
                currentColumn + move.getColumn());
    }
}