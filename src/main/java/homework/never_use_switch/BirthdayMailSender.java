package homework.never_use_switch;

public class BirthdayMailSender implements MailSender {
    @Override
    public void sendMail(MailInfo mailInfo) {
        System.out.println("Birthday mail");
    }
}
