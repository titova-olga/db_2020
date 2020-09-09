package homework.never_use_switch;

import com.github.javafaker.Faker;
import homework.never_use_switch.mail_configuration.MailInfo;
import homework.never_use_switch.mail_configuration.MailType;
import homework.never_use_switch.mail_configuration.MailsConfigImpl;
import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class MailMockProducer {

    @Autowired
    private MailDistributor mailDistributor;

    @Autowired
    private Faker faker;

    @Autowired
    private DataFactory dataFactory;


    @SneakyThrows
    public void sendMailsForever()  {
        while (true) {
            MailType mailType = MailType.getRandomMailType();
            MailInfo mailInfo = MailInfo.builder()
                    .email(dataFactory.getEmailAddress())
                    .mailType(mailType)
                    .text(faker.chuckNorris().fact()).build();
            try {
                mailDistributor.sendMailInfo(mailInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        context.getBean(MailMockProducer.class).sendMailsForever();

        context.close();
    }
}






