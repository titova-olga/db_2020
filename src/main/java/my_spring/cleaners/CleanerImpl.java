package my_spring.cleaners;

import my_spring.annotations.InjectRandomInt;

/**
 * @author Evgeny Borisov
 */
public class CleanerImpl implements Cleaner {

    @InjectRandomInt(min=3,max=10)
    private int repeat = 1;

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVVVVVVVVVVVVVvvvvvvvvvvvvvvvvvvvv");
        }
    }
}
