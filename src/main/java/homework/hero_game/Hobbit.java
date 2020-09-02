package homework.hero_game;

public class Hobbit extends Hero {

    private static final int POWER = 0;
    private static final int HP = 3;

    public Hobbit(String heroName) {
        super(heroName, POWER, HP);
    }

    @Override
    protected void kick(Hero otherHero) {
        toCry();
    }

    private void toCry() {
        System.out.println("I can only cry :(((");
    }
}
