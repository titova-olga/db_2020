package my_spring.speakers;

public class CapsLockConsoleSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        System.out.println(message.toUpperCase());
    }
}
