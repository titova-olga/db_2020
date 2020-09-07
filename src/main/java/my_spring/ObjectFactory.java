package my_spring;

import com.github.javafaker.Faker;
import heroes.Hero;
import lombok.SneakyThrows;
import my_spring.irobot_configuration.BaseConfig;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {

    private static ObjectFactory objectFactory = new ObjectFactory();

    private Reflections scanner = new Reflections("my_spring");


    private ObjectFactory() {
    }

    public static ObjectFactory getInstance() {
        return objectFactory;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type, BaseConfig objectConfig) {
        Class<? extends T> clazz;

        if (type.isInterface()) {
            clazz = objectConfig.getImpl(type);
            if (clazz == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() == 0) {
                    throw new IllegalArgumentException();
                }
                else {
                    clazz = (Class<? extends T>) classes.toArray()[0];
                }
            }
        }
        else {
            clazz = type;
        }

        return clazz.getDeclaredConstructor().newInstance();
    }
}
