package homework.never_use_switch.mail_senders;

import homework.never_use_switch.mail_configuration.MailInfo;
import homework.never_use_switch.mail_configuration.MailType;
import org.springframework.stereotype.Component;

@Component
public class BirthdayMailSender implements MailSender {
    @Override
    public void sendMail(MailInfo mailInfo) {
        System.out.println("Birthday mail");
    }

    @Override
    public MailType getMailType() {
        return MailType.BIRTHDAY;
    }
}
