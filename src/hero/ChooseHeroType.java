package hero;

import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

public final class ChooseHeroType {

    private ChooseHeroType() {
    }

    public static Hero chooseType(final Character ch) {
        switch (ch) {
            case 'K':
                return new Knight();

            case 'P':
                return new Pyromancer();

            case 'R':
                return new Rogue();

            default:
                return new Wizard();
        }
    }
}
