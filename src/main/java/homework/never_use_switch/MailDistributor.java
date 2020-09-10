package homework.never_use_switch;

import homework.never_use_switch.mail_configuration.MailInfo;
import homework.never_use_switch.mail_configuration.MailType;
import homework.never_use_switch.mail_senders.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */

@Component
public class MailDistributor {

    private Map<MailType, MailSender> mailsConfig = new HashMap<>();

    @Autowired
    public MailDistributor(Set<MailSender> senders) {
        senders.stream().forEach(mailSender -> mailsConfig.put(mailSender.getMailType(), mailSender));
    }

    public void sendMailInfo(MailInfo mailInfo) {
        MailSender mailSender = mailsConfig.get(mailInfo.getMailType());
        mailSender.sendMail(mailInfo);
    }
}











