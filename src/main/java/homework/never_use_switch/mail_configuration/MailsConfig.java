package homework.never_use_switch.mail_configuration;

import homework.never_use_switch.mail_senders.MailSender;

import java.util.Map;

public interface MailsConfig {
    Map<MailType, MailSender> getMailsSenders();
}
