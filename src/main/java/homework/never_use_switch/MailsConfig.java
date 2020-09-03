package homework.never_use_switch;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface MailsConfig {
    Map<Integer, MailSender> getMailsSenders();
}
