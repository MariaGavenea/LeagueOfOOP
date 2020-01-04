package game.game_actions.fight;

import abilities.Ability;
import constants.constants_for_heroes.ConstantsForLevelUp;
import constants.constants_for_heroes.ConstantsForXp;
import hero.Hero;
import hero.HeroStatus;
import hero.heroes.HeroesFactory;
import magician.GreatMagician;
import magician.Observer;
import magician.Subject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Fight extends Subject {
    private HeroesFactory heroes;
    private FileWriter fw;

    public Fight(final HeroesFactory heroes, final FileWriter fw) {
        this.heroes = heroes;
        this.fw = fw;
    }

    public final void applyOvertimeDamages() {
        for (int i = 0; i < heroes.getSize(); ++i) {
            heroes.getHeroAt(i).getDamagedForRound();
        }
    }

    public final void chooseFightersAndFight() throws IOException {
        for (int i = 0; i < heroes.getSize() - 1; ++i) {
            for (int j = i + 1; j < heroes.getSize(); ++j) {
                if (heroes.getHeroAt(i).getPosition().equals(heroes.getHeroAt(j).getPosition())) {
                    if (heroes.getHeroAt(i).getStatus().equals(HeroStatus.alive)
                            && heroes.getHeroAt(j).getStatus().equals(HeroStatus.alive)) {
                        fight(heroes.getHeroAt(i), heroes.getHeroAt(j));
                        computeNewInfoForWinners(heroes.getHeroAt(i), heroes.getHeroAt(j));
                    }
                }
            }
        }
    }

    protected final void fight(final Hero hero1, final Hero hero2) {
        final List<Ability> hero1Abilities = hero1.getAbilities().getListOfAbilities();
        final List<Ability> hero2Abilities = hero2.getAbilities().getListOfAbilities();
        int hero1Damage = 0;
        int hero2Damage = 0;

        for (int i = 0; i < hero1Abilities.size(); ++i) {
            hero2Damage += hero2.getDamagedBy(hero1Abilities.get(i), hero1);
        }

        for (int i = 0; i < hero2Abilities.size(); ++i) {
            hero1Damage += hero1.getDamagedBy(hero2Abilities.get(i), hero2);
        }

        hero1.increaseFightNumber();
        hero2.increaseFightNumber();

        // apply damage
        hero1.getDamaged(hero1Damage);
        hero2.getDamaged(hero2Damage);
    }

    protected final void computeNewInfoForWinners(final Hero hero1, final Hero hero2)
            throws IOException {
        Observer greatMagicianObsForHero = new GreatMagician(this, fw);
        // add XP
        final int hero1Level = hero1.getLevel();
        final int hero2Level = hero2.getLevel();

        if (hero2.getStatus().equals(HeroStatus.dead)
                && hero1.getStatus().equals(HeroStatus.dead)) {
            setMessage("Player " + hero2.getHeroFullType() + " " + hero2.getId()
                    + " was killed by " + hero1.getHeroFullType() + " " + hero1.getId() + "\n");

            setMessage("Player " + hero1.getHeroFullType() + " " + hero1.getId()
                    + " was killed by " + hero2.getHeroFullType() + " " + hero2.getId() + "\n");
            return;
        }

        if (hero2.getStatus().equals(HeroStatus.dead)) { // hero1 won
            addXp(hero1, hero2Level);

            setMessage("Player " + hero2.getHeroFullType() + " " + hero2.getId()
                    + " was killed by " + hero1.getHeroFullType() + " " + hero1.getId() + "\n");
            // compute new level
            computeLevel(hero1);
        }

        if (hero1.getStatus().equals(HeroStatus.dead)) { // hero2 won
            addXp(hero2, hero1Level);

            setMessage("Player " + hero1.getHeroFullType() + " " + hero1.getId()
                    + " was killed by " + hero2.getHeroFullType() + " " + hero2.getId() + "\n");

            // compute new level
            computeLevel(hero2);
        }

        // if the hero has increased in level then he gets 100% HP according to his new level
        if (hero1.getLevel() > hero1Level) {
            hero1.newHp();
        }

        if (hero2.getLevel() > hero2Level) {
            hero2.newHp();
        }
    }

    protected final void addXp(final Hero winner, final int levelLoser) {
        final int winnerXP;
        final int levelWinner = winner.getLevel();

        winnerXP = winner.getXp() + Math.max(ConstantsForXp.CONST1,
                ConstantsForXp.CONST2 - (levelWinner - levelLoser) * ConstantsForXp.MULTIPLIER);

        winner.setXp(winnerXP);
    }

    protected final void computeLevel(final Hero hero) throws IOException {
        final int oldLevel = hero.getLevel();
        final int level = (hero.getXp() - ConstantsForLevelUp.BASE_VALUE
                + ConstantsForLevelUp.VALUE_FOR_ONE_LEVEL_UP)
                / ConstantsForLevelUp.VALUE_FOR_ONE_LEVEL_UP;

        if (level > oldLevel) {
            hero.setLevel(level);
        }

        for (int i = oldLevel + 1; i <= level; i++) {
            setMessage(hero.getHeroFullType() + " " + hero.getId() + " reached level "
                    + i + "\n");
        }
    }
}
