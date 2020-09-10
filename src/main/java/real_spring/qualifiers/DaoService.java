package real_spring.qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DaoService {

    @Autowired
    @DaoAnnotation(daoType = DaoType.ORACLE)
    private Dao oracleDao;

    @Autowired
    @DaoAnnotation(daoType = DaoType.DERBY)
    private Dao derbyDao;

    @Scheduled(fixedDelay = 1000)
    public void doWork() {
        oracleDao.save();
    }

    @Scheduled(fixedDelay = 3000)
    public void doBackup() {
        derbyDao.save();
    }
}
