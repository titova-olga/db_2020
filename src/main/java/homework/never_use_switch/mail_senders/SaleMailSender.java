package homework.never_use_switch.mail_senders;

import homework.never_use_switch.mail_configuration.MailInfo;

public class SaleMailSender implements MailSender {
    @Override
    public void sendMail(MailInfo mailInfo) {
        System.out.println("Sale mail");
    }
}