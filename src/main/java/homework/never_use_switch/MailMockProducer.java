package homework.never_use_switch;

import com.github.javafaker.Faker;
import homework.never_use_switch.mail_configuration.MailInfo;
import homework.never_use_switch.mail_configuration.MailType;
import homework.never_use_switch.mail_configuration.MailsConfigImpl;
import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 * @author Evgeny Borisov
 */
public class MailMockProducer {

    private MailDistributor mailDistributor = new MailDistributor(new MailsConfigImpl());
    private Faker faker = new Faker();
    private DataFactory dataFactory = new DataFactory();


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
        new MailMockProducer().sendMailsForever();
    }
}






