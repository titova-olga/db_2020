package homework.never_use_switch;

public class DelayMailSender implements MailSender {
    @Override
    public void sendMail(MailInfo mailInfo) {
        System.out.println("Delay mail");
    }
}
