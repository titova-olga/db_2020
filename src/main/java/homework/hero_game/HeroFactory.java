package homework.hero_game;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HeroFactory {

    private final List<String> heroTypes = Arrays.asList("Hobbit", "Elf", "King", "Knight");

    public Hero createRandomHero(String name) throws Exception {
        String randomHeroType = heroTypes.get(ThreadLocalRandom.current().nextInt(0, heroTypes.size()));

        // todo
        String pack = "homework.hero_game.";
        Class<?> cl = Class.forName(pack + randomHeroType);
        Constructor<?> ctor = cl.getConstructor(String.class);

        return (Hero) ctor.newInstance(name);
    }
}
