package homework.never_use_switch;

import homework.never_use_switch.mail_configuration.MailInfo;
import homework.never_use_switch.mail_configuration.MailsConfig;
import homework.never_use_switch.mail_senders.MailSender;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */

@Component
public class MailDistributor {

    @Autowired
    private MailsConfig mailsConfig;

    public void sendMailInfo(MailInfo mailInfo) {
        MailSender mailSender = mailsConfig.getMailsSenders().get(mailInfo.getMailType());
        mailSender.sendMail(mailInfo);
    }
}











