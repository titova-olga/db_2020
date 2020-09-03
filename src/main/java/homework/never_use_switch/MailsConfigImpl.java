package homework.never_use_switch;

import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class MailsConfigImpl implements MailsConfig {
    @Getter
    private final Map<Integer, MailSender> mailsSenders =
            Map.of(1, new WelcomeMailSender(),
                    2, new SaleMailSender(),
                    3, new DelayMailSender(),
                    4, new BirthdayMailSender());
}
