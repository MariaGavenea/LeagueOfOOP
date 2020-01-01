package strategy;

import abilities.Ability;
import hero.Hero;

public class DefenseStrategy implements Strategy {
    @Override
    public void applyStrategy(Hero hero) {
        hero.increaseHp();
        for (Ability ability : hero.getAbilities().getListOfAbilities()) {
            ability.decreaseAmplifiers();
        }
    }
}
