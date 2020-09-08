package my_spring.factory;

import lombok.SneakyThrows;
import my_spring.annotations.Singleton;
import my_spring.configuration.Config;
import my_spring.object_configurers.ObjectConfigurer;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {

    private static ObjectFactory objectFactory = new ObjectFactory();
    private Config config;
    private Reflections scanner;
    private List<ObjectConfigurer> objectConfigurers = new ArrayList<>();
    private Map<Class<?>, Object> singletons = new HashMap<>();

    @SneakyThrows
    public void configure(Config config) {
        this.config = config;
        scanner = new Reflections(config.getPackageToScan());
        addObjectConfigurers();
        addSingletons();
    }

    private ObjectFactory() {
    }

    public static ObjectFactory getInstance() {
        return objectFactory;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = resolveImpl(type);
        if (implClass.isAnnotationPresent(Singleton.class) && singletons.containsKey(type)) {
            return (T) singletons.get(type);
        }
        T t = create(implClass);
        configure(t);
        invokeInitMethod(implClass, t);
        return t;
    }

    @SneakyThrows
    private void addObjectConfigurers() {
        Set<Class<? extends ObjectConfigurer>> classes = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                objectConfigurers.add(aClass.getDeclaredConstructor().newInstance());
            }
        }
    }

    @SneakyThrows
    private void addSingletons() {
        Set<Class<? extends Object>> classes = scanner.getSubTypesOf(Object.class);
        for (Class<? extends Object> aClass : classes) {
            if (aClass.isAnnotationPresent(Singleton.class)) {
                singletons.put(aClass, createObject(aClass));
            }
        }
    }

    private <T> void invokeInitMethod(Class<? extends T> implClass, T t) throws IllegalAccessException, InvocationTargetException {
        Set<Method> methods = ReflectionUtils.getAllMethods(implClass);
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        objectConfigurers.forEach(objectConfigurer -> objectConfigurer.configure(t));
    }

    private <T> T create(Class<? extends T> implClass) throws InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException, NoSuchMethodException {
        T obj = implClass.getDeclaredConstructor().newInstance();

        if(implClass.isAnnotationPresent(Singleton.class)) {
            saveSingletonInCache(implClass, obj);
        }

        return obj;
    }

    private <T> void saveSingletonInCache(Class<? extends T> implClass, T obj) {
        singletons.put(implClass, obj);
    }

    private <T> Class<? extends T> resolveImpl(Class<T> type) {
        Class<? extends T> implClass;
        if (type.isInterface()) {
            implClass = config.getImpl(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + " has 0 or more than one impl, please update your config");
                }
                implClass = classes.iterator().next();
            }
        }else {
            implClass = type;
        }
        return implClass;
    }
}

