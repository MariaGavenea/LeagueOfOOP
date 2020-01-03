package hero;

import abilities.Abilities;
import angel.VisitedByAngel;
import common.Position;

public abstract class Hero implements MortalHero, VisitedByAngel {
    protected int id;
    protected int hp;
    protected int xp;
    protected int level;
    protected HeroType heroType;
    protected HeroFullType heroFullType;
    protected HeroStatus status;
    protected Position position;
    protected Abilities abilities;
    protected int fightNumber;

    // info about overtime effects that a hero suffers from
    protected int damageOvertime;
    protected int numOfRoundsGetsDamage;
    protected int numOfRoundsCantMove;


    public Hero() {
        id = 0;
        xp = 0;
        level = 0;
        status = HeroStatus.alive;
        fightNumber = 0;

        damageOvertime = 0;
        numOfRoundsGetsDamage = 0;
        numOfRoundsCantMove = 0;
    }

    // decrease life
    public final void getDamaged(final int damage) {
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
            status = HeroStatus.dead;
        }
    }

    // new life at level up
    public abstract void newHp();

    // modify Hp (for strategies)
    public abstract void increaseHpForStrategies();

    public abstract void decreaseHpForStrategies();

    public abstract boolean checkDefenseStrategy();

    public abstract boolean checkOffenseStrategy();

    public final void addHp(final int value) {
        hp += value;
        if (hp <= 0) {
            hp = 0;
            status = HeroStatus.dead;
        }
    }

    // fight number
    public final void increaseFightNumber() {
        fightNumber++;
    }

    // apply overtime damage for a round
    public final void getDamagedForRound() {
        if (numOfRoundsGetsDamage > 0) {
            this.getDamaged(damageOvertime);
            numOfRoundsGetsDamage--;
        }
    }

    // overtime impossibility to move
    public final void decreaseNumOfRoundsCantMove() {
        if (numOfRoundsCantMove > 0) {
            numOfRoundsCantMove--;
        }
    }

    // info for print
    public final String getInfoForPrint() {
        if (status.equals(HeroStatus.dead)) {
            return heroType + " " + status;
        }

        return heroType + " " + level + " " + xp + " " + hp
                + " " + position.getLine() + " " + position.getColumn();
    }

    // getters
    public final int getHp() {
        return hp;
    }

    public final int getXp() {
        return xp;
    }

    public final int getLevel() {
        return level;
    }

    public final int getDamageOvertime() {
        return damageOvertime;
    }

    public final int getNumOfRoundsGetsDamage() {
        return numOfRoundsGetsDamage;
    }

    public final Position getPosition() {
        return position;
    }

    public final Abilities getAbilities() {
        return abilities;
    }

    public final HeroStatus getStatus() {
        return status;
    }

    public final HeroType getHeroType() {
        return heroType;
    }

    public final int getNumOfRoundsCantMove() {
        return numOfRoundsCantMove;
    }

    public final int getFightNumber() {
        return fightNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // setters
    public void setHp(int hp) {
        this.hp = hp;
        if (hp > 0) {
            status = HeroStatus.alive;
        } else {
            this.hp = 0;
            status = HeroStatus.dead;
        }
    }

    public final void setXp(final int xp) {
        this.xp = xp;
    }

    public final void setLevel(final int level) {
        this.level = level;
    }

    public final void setPosition(final Position position) {
        this.position = position;
    }

    public final void setNumOfRoundsCantMove(final int numOfRoundsCantMove) {
        this.numOfRoundsCantMove = numOfRoundsCantMove;
    }

    public final void setDamageAndNumOfRounds(final int damage, final int numOfRounds) {
        damageOvertime = damage;
        numOfRoundsGetsDamage = numOfRounds;
    }

    public HeroFullType getHeroFullType() {
        return heroFullType;
    }
}
