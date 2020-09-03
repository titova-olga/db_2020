package homework.never_use_switch;

public class WelcomeMailSender implements MailSender {
    @Override
    public void sendMail(MailInfo mailInfo) {
        System.out.println("Welcome mail");
    }
}
