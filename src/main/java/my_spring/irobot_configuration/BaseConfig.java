package my_spring.irobot_configuration;

public interface BaseConfig {
    <T> Class<? extends T> getImpl(Class<T> clazz);
}
