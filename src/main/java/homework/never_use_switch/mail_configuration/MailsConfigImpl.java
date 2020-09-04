package homework.never_use_switch.mail_configuration;

import homework.never_use_switch.mail_senders.*;
import lombok.Getter;

import java.util.Map;

@Getter
public class MailsConfigImpl implements MailsConfig {
    private final Map<MailType, MailSender> mailsSenders =
            Map.of(MailType.WELCOME, new WelcomeMailSender(),
                    MailType.SALE, new SaleMailSender(),
                    MailType.DELAY, new DelayMailSender(),
                    MailType.BIRTHDAY, new BirthdayMailSender());
}
