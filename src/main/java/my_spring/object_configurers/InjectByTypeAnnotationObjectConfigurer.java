package my_spring.object_configurers;

import lombok.SneakyThrows;
import my_spring.annotations.InjectByType;
import my_spring.factory.Context;
import my_spring.factory.ObjectFactory;

import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
public class InjectByTypeAnnotationObjectConfigurer implements ObjectConfigurer {
    @SneakyThrows
    @Override
    public void configure(Object t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                Object value = Context.getInstance().createObject(field.getType());
                field.setAccessible(true);
                field.set(t,value);
            }
        }
    }
}
