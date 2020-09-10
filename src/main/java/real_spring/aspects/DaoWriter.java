package real_spring.aspects;

import org.springframework.stereotype.Component;

@Component
public class DaoWriter implements Dao {
    @Override
    public void save() {
        System.out.println("try to save something in database ...");
        throw new DatabaseRuntimeException("attempt failed...");
    }
}