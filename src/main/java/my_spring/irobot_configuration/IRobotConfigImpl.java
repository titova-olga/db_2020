package my_spring.irobot_configuration;

import lombok.SneakyThrows;
import my_spring.cleaners.Cleaner;
import my_spring.cleaners.CleanerImpl;
import my_spring.speakers.CapsLockConsoleSpeaker;
import my_spring.speakers.ConsoleSpeaker;
import my_spring.speakers.Speaker;

import java.lang.reflect.Field;
import java.util.Map;

public class IRobotConfigImpl implements BaseConfig {

    private final Map<Class, Class> robotConfig =
            Map.of(Speaker.class, CapsLockConsoleSpeaker.class,
                    Cleaner.class, CleanerImpl.class);

    @SneakyThrows
    public <T> Class<? extends T> getImpl(Class<T> clazz) {
        return robotConfig.get(clazz);
    }
}
