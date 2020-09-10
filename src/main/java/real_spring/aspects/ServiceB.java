package real_spring.aspects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceB {
    @Autowired
    private Dao myDao;

    public void save() {
        System.out.println("BBBBB");
        myDao.save();
    }
}
