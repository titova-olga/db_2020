package my_spring;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */

public class DBankServiceImpl implements DBankService {
    @Override
    public void doWork() {
        System.out.println("working...");
        this.drinkBeer();
    }

    @Override
    @Benchmark
    public void drinkBeer() {
        System.out.println("drinking...");
    }


    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext(new JavaConfig(Map.of(), "my_spring"));
        DBankService bankService = context.getBean(DBankService.class);
        System.out.println(bankService.getClass());
        bankService.drinkBeer();
    }
}


















