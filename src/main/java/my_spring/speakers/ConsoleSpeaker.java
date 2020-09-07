package my_spring.speakers;

import my_spring.annotations.Singleton;

/**
 * @author Evgeny Borisov
 */
@Singleton
public class ConsoleSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}
