package homework.hero_game;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Hero {
    private String name;
    private int power;
    private int hp;

    public Hero(String heroName, int heroPower, int heroHp) {
        name = heroName;
        power = heroPower;
        hp = heroHp;
    }

    protected abstract void kick(Hero otherHero);

    protected boolean isAlive() {
        return hp > 0;
    }

    @Override
    public String toString() {
        return "Hero " + name + '\'' +
                ", has power = " + power +
                ", hp = " + hp;
    }
}
