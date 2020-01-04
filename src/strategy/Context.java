package strategy;

import hero.Hero;

public class Context {
    private Strategy strategy;

    public Context(final Strategy strategy) {
        this.strategy = strategy;
    }

    public final void executeStrategy(final Hero hero) {
        strategy.applyStrategy(hero);
    }
}
