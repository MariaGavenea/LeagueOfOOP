package game.game_actions.execute_strategies;

import hero.heroes.HeroesFactory;
import strategy.Context;
import strategy.DefenseStrategy;
import strategy.OffenseStrategy;

public class ExecuteStrategies {
    protected HeroesFactory heroes;

    public ExecuteStrategies(HeroesFactory heroes) {
        this.heroes = heroes;
    }

    public void executeStrategies() {
        for (int i = 0; i < heroes.getSize(); ++i) {
            if (heroes.getHeroAt(i).getNumOfRoundsCantMove() > 0)
                continue;

            Context context = null;

            if (heroes.getHeroAt(i).checkDefenseStrategy()) {
                context = new Context(new DefenseStrategy());
            } else {
                if (heroes.getHeroAt(i).checkOffenseStrategy()) {
                    context = new Context(new OffenseStrategy());
                }
            }

            if (context != null) {
                context.executeStrategy(heroes.getHeroAt(i));
            }
        }
    }
}
