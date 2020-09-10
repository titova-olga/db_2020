package real_spring.aspects;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:dao_writer.properties")
@ComponentScan
@EnableAspectJAutoProxy
public class Config {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.getBean(Dao.class).save();
    }
}
