package homework.never_use_switch;

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
