package my_spring;

import my_spring.cleaners.Cleaner;
import my_spring.irobot_configuration.BaseConfig;
import my_spring.speakers.Speaker;

/**
 * @author Evgeny Borisov
 */
public class IRobot {

    public IRobot(BaseConfig config) {
        speaker = ObjectFactory.getInstance().createObject(Speaker.class, config);
        cleaner = ObjectFactory.getInstance().createObject(Cleaner.class, config);
    }

    private Speaker speaker;
    private Cleaner cleaner;

    public void cleanRoom() {
        speaker.speak("Я начал уборку");
        cleaner.clean();
        speaker.speak("Я закончил уборку");
    }
}
