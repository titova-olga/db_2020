package homework.hero_game;

import java.util.concurrent.ThreadLocalRandom;

public class King extends Hero{

    private static final int LOW_POWER = 5;
    private static final int HIGH_POWER = 15;

    private static final int LOW_HP = 5;
    private static final int HIGH_HP = 15;

    public King(String heroName) {
        super(heroName, generateRandomPower(), generateRandomHp());
    }

    private static int generateRandomPower() {
        return ThreadLocalRandom.current().nextInt(LOW_POWER, HIGH_POWER + 1);
    }

    private static int generateRandomHp() {
        return ThreadLocalRandom.current().nextInt(LOW_HP, HIGH_HP + 1);
    }

    @Override
    protected void kick(Hero otherHero) {
        otherHero.setHp(otherHero.getHp() - ThreadLocalRandom.current().nextInt(0, getPower()));
    }
}
