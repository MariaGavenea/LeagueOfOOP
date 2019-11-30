package game.game_actions.move;

import common.Position;

public final class ChooseDirection {

    private ChooseDirection() {
    }

    public static Position chooseDir(final Character ch) {
        switch (ch) {
            case 'R':
                return new Position(0, 1);

            case 'L':
                return new Position(0, -1);

            case 'D':
                return new Position(1, 0);

            case 'U':
                return new Position(-1, 0);

            default:
                return new Position(0, 0);
        }
    }
}
