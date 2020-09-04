package homework.never_use_switch;

import homework.never_use_switch.mail_configuration.MailInfo;
import homework.never_use_switch.mail_configuration.MailsConfig;
import homework.never_use_switch.mail_senders.MailSender;
import lombok.RequiredArgsConstructor;

/**
 * @author Evgeny Borisov
 */
@RequiredArgsConstructor
public class MailDistributor {

    private final MailsConfig mailsConfig;

    public void sendMailInfo(MailInfo mailInfo) {
        MailSender mailSender = mailsConfig.getMailsSenders().get(mailInfo.getMailType());
        mailSender.sendMail(mailInfo);
    }
}
