package my_spring;

import lombok.Getter;
import my_spring.annotations.InjectRandomInt;

/**
 * @author Evgeny Borisov
 */
@Getter
public class Soldier {
    @InjectRandomInt(min = 10,max = 15)
    private int power;
}
