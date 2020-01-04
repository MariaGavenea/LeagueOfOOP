package strategy;

import abilities.Ability;
import hero.Hero;

public class OffenseStrategy implements Strategy {
    @Override
    public final void applyStrategy(final Hero hero) {
        hero.decreaseHpForStrategies();
        for (Ability ability : hero.getAbilities().getListOfAbilities()) {
            ability.increaseAmplifiersForStrategy();
        }
    }
}
