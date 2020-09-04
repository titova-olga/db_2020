package homework.never_use_switch.mail_configuration;

import lombok.*;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MailInfo {
    private String text;
    @NonNull
    private MailType mailType;
    private String email;
}
