package homework.never_use_switch.mail_senders;

import homework.never_use_switch.mail_configuration.MailInfo;
import homework.never_use_switch.mail_configuration.MailType;

public interface MailSender {
    void sendMail(MailInfo mailInfo);
    MailType getMailType();
}
