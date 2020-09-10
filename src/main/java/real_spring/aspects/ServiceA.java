package real_spring.aspects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceA {
    @Autowired
    private ServiceB serviceB;

    public void save() {
        System.out.println("AAAAA");
        serviceB.save();
    }
}
