package real_spring.aspects;

import lombok.Setter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class DatabaseExceptionAspect {

    private List<String> mails;

    @Autowired
    public void setWords(@Value("${dba_mails}") String[] words) {
        this.mails = Arrays.asList(words);
    }

    @AfterThrowing(pointcut = "execution(* real_spring.aspects..*.*(..)) " +
            "&& @target(org.springframework.stereotype.Repository)", throwing = "ex")
    public void afterDatabaseException(DatabaseRuntimeException ex) throws Throwable {
        System.out.println("catch ex in aspect: " + ex.getMessage());
        System.out.println("and write them to: " );
        mails.forEach(System.out::println);
    }
}
