package my_spring;

import lombok.SneakyThrows;
import my_spring.irobot_configuration.BaseConfig;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {

    private static ObjectFactory objectFactory = new ObjectFactory();

    private ObjectFactory() {
    }

    public static ObjectFactory getInstance() {
        return objectFactory;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type, BaseConfig objectConfig) {

        if (type.isInterface()) {
            return objectConfig.getImpl(type).getDeclaredConstructor().newInstance();
        }
        else {
            return type.getDeclaredConstructor().newInstance();
        }
    }
}
