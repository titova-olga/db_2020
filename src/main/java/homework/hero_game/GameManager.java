package homework.hero_game;

public class GameManager {
    public void fight(Hero h1, Hero h2) {

        System.out.println("START STATUS:");
        System.out.println(h1 + "\n" + h2);

        while (h1.isAlive() && h2.isAlive()) {
            System.out.println("Hero " + h1.getName() + " kicks " + h2.getName());
            h1.kick(h2);
            System.out.println("Result: \n" + h2);

            System.out.println("Hero " + h1.getName() + " kicks " + h2.getName());
            h2.kick(h1);
            System.out.println("Result: \n" + h1);
        }
    }

    public static void main(String[] args) throws Exception {
        HeroFactory heroFactory = new HeroFactory();

        Hero heroOlya = heroFactory.createRandomHero("Olya");
        Hero heroMasha = heroFactory.createRandomHero("Masha");

        GameManager game = new GameManager();
        game.fight(heroOlya, heroMasha);
    }
}
