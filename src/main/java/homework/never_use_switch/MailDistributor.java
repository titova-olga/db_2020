package homework.never_use_switch;

import lombok.RequiredArgsConstructor;

/**
 * @author Evgeny Borisov
 */
@RequiredArgsConstructor
public class MailDistributor {

    private final MailsConfig mailsConfig;

    public void sendMailInfo(MailInfo mailInfo) {
        MailSender mailSender = mailsConfig.getMailsSenders().get(mailInfo.getMailType());
        mailSender.sendMail(mailInfo);
    }
}
