package angel.angels;

import angel.Angel;
import angel.AngelType;
import constants.constants_for_angels.ConstantsForSpawner;
import hero.HeroStatus;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

public class Spawner extends Angel {
    public Spawner() {
        angelType = AngelType.Spawner;
    }

    @Override
    public void influenceHero(Knight knight) {
        if (knight.getStatus() == HeroStatus.dead) {
            knight.setHp(ConstantsForSpawner.HP_TO_REVIVE_KNIGHT);
        }
    }

    @Override
    public void influenceHero(Pyromancer pyromancer) {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            pyromancer.setHp(ConstantsForSpawner.HP_TO_REVIVE_PYROMANCER);
        }
    }

    @Override
    public void influenceHero(Rogue rogue) {
        if (rogue.getStatus() == HeroStatus.dead) {
            rogue.setHp(ConstantsForSpawner.HP_TO_REVIVE_ROGUE);
        }
    }

    @Override
    public void influenceHero(Wizard wizard) {
        if (wizard.getStatus() == HeroStatus.dead) {
            wizard.setHp(ConstantsForSpawner.HP_TO_REVIVE_WIZARD);
        }
    }
}
