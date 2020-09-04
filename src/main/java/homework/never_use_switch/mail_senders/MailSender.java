package homework.never_use_switch.mail_senders;

import homework.never_use_switch.mail_configuration.MailInfo;

public interface MailSender {
    void sendMail(MailInfo mailInfo);
}
