package homework.never_use_switch;

import com.github.javafaker.Faker;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class MailMockProducerConfiguration {

    @Bean
    public Faker faker() {
        return new Faker();
    }

    @Bean
    public DataFactory dataFactory() {
        return new DataFactory();
    }
}
