package my_spring.annotations;/**
 * @author Evgeny Borisov
 */

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface Singleton {
}