package homework.never_use_switch.mail_senders;

import homework.never_use_switch.mail_configuration.MailInfo;

public class DelayMailSender implements MailSender {
    @Override
    public void sendMail(MailInfo mailInfo) {
        System.out.println("Delay mail");
    }
}
