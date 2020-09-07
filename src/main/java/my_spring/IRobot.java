package my_spring;

import my_spring.annotations.InjectByType;
import my_spring.annotations.InjectRandomInt;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */
public class IRobot {

    @InjectRandomInt(max = 10,min = 1)
    private int version;

    @InjectByType
    private Speaker speaker1;
    @InjectByType
    private Speaker speaker2;
    @InjectByType
    private Cleaner cleaner;


    @PostConstruct
    public void init() {
        System.out.println("version = " + version);

    }

    public void cleanRoom() {
        speaker1.speak("Я начал уборку");
        cleaner.clean();
        speaker2.speak("Я закончил уборку");
    }
}
