package strategy;

import abilities.Ability;
import hero.Hero;

public class OffenseStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        hero.decreaseHp();
        for (Ability ability : hero.getAbilities().getListOfAbilities()) {
            ability.increaseAmplifiers();
        }
    }
}
