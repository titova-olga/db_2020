package real_spring.qualifiers;

import org.springframework.stereotype.Component;

@Component
@DaoAnnotation(daoType = DaoType.DERBY)
public class DerbyDao implements Dao {
    @Override
    public void save() {
        System.out.println("Save in derby");
    }
}
