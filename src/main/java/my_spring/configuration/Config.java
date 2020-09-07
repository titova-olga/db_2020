package my_spring.configuration;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface Config {
    <T> Class<? extends T> getImpl(Class<T> type);
    String getPackageToScan();
}
