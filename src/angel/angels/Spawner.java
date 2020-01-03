package angel.angels;

import angel.Angel;
import angel.AngelType;
import constants.constants_for_angels.ConstantsForSpawner;
import hero.HeroStatus;
import hero.heroes.Knight;
import hero.heroes.Pyromancer;
import hero.heroes.Rogue;
import hero.heroes.Wizard;

import java.io.IOException;

public class Spawner extends Angel {
    public Spawner() {
        angelType = AngelType.Spawner;
    }

    @Override
    public void influenceHero(Knight knight) throws IOException {
        if (knight.getStatus() == HeroStatus.dead) {
            knight.setHp(ConstantsForSpawner.HP_TO_REVIVE_KNIGHT);

            setState(angelType + " helped Knight " + knight.getId() + "\n");
            setState("Player Knight " + knight.getId() + " was brought to life by an angel\n");
        }
    }

    @Override
    public void influenceHero(Pyromancer pyromancer) throws IOException {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            pyromancer.setHp(ConstantsForSpawner.HP_TO_REVIVE_PYROMANCER);

            setState(angelType + " helped Pyromancer " + pyromancer.getId() + "\n");
            setState("Player Pyromancer " + pyromancer.getId()
                    + " was brought to life by an angel\n");
        }
    }

    @Override
    public void influenceHero(Rogue rogue) throws IOException {
        if (rogue.getStatus() == HeroStatus.dead) {
            rogue.setHp(ConstantsForSpawner.HP_TO_REVIVE_ROGUE);

            setState(angelType + " helped Rogue " + rogue.getId() + "\n");
            setState("Player Rogue " + rogue.getId() + " was brought to life by an angel\n");
        }
    }

    @Override
    public void influenceHero(Wizard wizard) throws IOException {
        if (wizard.getStatus() == HeroStatus.dead) {
            wizard.setHp(ConstantsForSpawner.HP_TO_REVIVE_WIZARD);

            setState(angelType + " helped Wizard " + wizard.getId() + "\n");
            setState("Player Wizard " + wizard.getId() + " was brought to life by an angel\n");
        }
    }
}
