package homework.hero_game;

import java.util.concurrent.ThreadLocalRandom;

public class Knight extends Hero{
    private static final int LOW_POWER = 2;
    private static final int HIGH_POWER = 12;

    private static final int LOW_HP = 2;
    private static final int HIGH_HP = 12;

    public Knight(String heroName) {
        super(heroName, generateRandomPower(), generateRandomHp());
    }

    private static int generateRandomPower() {
        return ThreadLocalRandom.current().nextInt(LOW_POWER, HIGH_POWER + 1);
    }

    private static int generateRandomHp() {
        return ThreadLocalRandom.current().nextInt(LOW_HP, HIGH_HP + 1);
    }

    // todo remove copy paste
    @Override
    protected void kick(Hero otherHero) {
        otherHero.setHp(otherHero.getHp() - ThreadLocalRandom.current().nextInt(0, getPower()));
    }
}
