package homework.never_use_switch;

import java.util.Map;

public interface MailsConfig {
    Map<MailType, MailSender> getMailsSenders();
}
