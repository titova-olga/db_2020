package homework.hero_game;

public class Elf extends Hero {

    private static final int POWER = 10;
    private static final int HP = 10;

    public Elf(String heroName) {
        super(heroName, POWER, HP);
    }

    @Override
    protected void kick(Hero otherHero) {
        if (otherHero.getPower() < getPower()) {
            otherHero.setHp(0);
        }
        else {
            otherHero.setPower(otherHero.getPower() - 1);
        }
    }
}
