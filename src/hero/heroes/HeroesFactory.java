package hero.heroes;

import common.Position;
import hero.ChooseHeroType;
import hero.Hero;
import main.GameInput;

import java.util.ArrayList;
import java.util.List;

public final class HeroesFactory {
    private static HeroesFactory instance = null;
    private List<Hero> heroes;

    private HeroesFactory() {
        heroes = new ArrayList<>();
        final List<String> heroesTypes = GameInput.getHeroesTypes();
        final List<Position> heroesPositions = GameInput.getHeroesPositions();

        for (int i = 0; i < heroesTypes.size(); ++i) {
            final Hero hero = ChooseHeroType.chooseType(heroesTypes.get(i).charAt(0));

            final Position position1 = new Position(heroesPositions.get(i).getLine(),
                    heroesPositions.get(i).getColumn());
            hero.setPosition(position1);

            heroes.add(hero);
        }
    }

    public static HeroesFactory getInstance() {
        if (instance == null) {
            instance = new HeroesFactory();
        }
        return instance;
    }

    public Hero getHeroAt(final int index) {
        return heroes.get(index);
    }

    public int getSize() {
        return heroes.size();
    }
}
