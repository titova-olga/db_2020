package homework.never_use_switch;

public class SaleMailSender implements MailSender {
    @Override
    public void sendMail(MailInfo mailInfo) {
        System.out.println("Sale mail");
    }
}
