package strategy;

import abilities.Ability;
import hero.Hero;

public class OffenseStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        hero.decreaseHpForStrategies();
        for (Ability ability : hero.getAbilities().getListOfAbilities()) {
            ability.increaseAmplifiersForStrategy();
        }
        System.out.println(hero.getHeroFullType());
    }
}
