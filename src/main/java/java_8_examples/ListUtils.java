package java_8_examples;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class ListUtils {
    public static <T> int countDuplicates(List<T> list, T t, Equaluator<T> equaluator) {
        int counter=0;
        for (T t1 : list) {
            if (equaluator.equal(t, t1)) {
                counter++;
            }
        }
        return counter;
    }
}
