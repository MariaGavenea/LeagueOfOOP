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
    public final void influenceHero(final Knight knight) throws IOException {
        if (knight.getStatus() == HeroStatus.dead) {
            knight.setHp(ConstantsForSpawner.HP_TO_REVIVE_KNIGHT);

            setMessage(angelType + " helped Knight " + knight.getId() + "\n");
            setMessage("Player Knight " + knight.getId() + " was brought to life by an angel\n");
        }
    }

    @Override
    public final void influenceHero(final Pyromancer pyromancer) throws IOException {
        if (pyromancer.getStatus() == HeroStatus.dead) {
            pyromancer.setHp(ConstantsForSpawner.HP_TO_REVIVE_PYROMANCER);

            setMessage(angelType + " helped Pyromancer " + pyromancer.getId() + "\n");
            setMessage("Player Pyromancer " + pyromancer.getId()
                    + " was brought to life by an angel\n");
        }
    }

    @Override
    public final void influenceHero(final Rogue rogue) throws IOException {
        if (rogue.getStatus() == HeroStatus.dead) {
            rogue.setHp(ConstantsForSpawner.HP_TO_REVIVE_ROGUE);

            setMessage(angelType + " helped Rogue " + rogue.getId() + "\n");
            setMessage("Player Rogue " + rogue.getId() + " was brought to life by an angel\n");
        }
    }

    @Override
    public final void influenceHero(final Wizard wizard) throws IOException {
        if (wizard.getStatus() == HeroStatus.dead) {
            wizard.setHp(ConstantsForSpawner.HP_TO_REVIVE_WIZARD);

            setMessage(angelType + " helped Wizard " + wizard.getId() + "\n");
            setMessage("Player Wizard " + wizard.getId() + " was brought to life by an angel\n");
        }
    }
}
