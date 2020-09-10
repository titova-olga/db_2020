    package real_spring.qualifiers;

import org.springframework.stereotype.Component;

@Component
@DaoAnnotation(daoType = DaoType.ORACLE)
public class OracleDao implements Dao {
    @Override
    public void save() {
        System.out.println("Save in oracle");
    }
}
