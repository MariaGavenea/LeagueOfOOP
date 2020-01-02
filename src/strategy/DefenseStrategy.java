package strategy;

import abilities.Ability;
import hero.Hero;

public class DefenseStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        hero.increaseHpForStrategies();
        for (Ability ability : hero.getAbilities().getListOfAbilities()) {
            ability.decreaseAmplifiersForStrategy();
        }
    }
}
