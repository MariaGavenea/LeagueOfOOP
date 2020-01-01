package strategy;

import hero.Hero;

public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Hero hero) {
        strategy.applyStrategy(hero);
    }
}
