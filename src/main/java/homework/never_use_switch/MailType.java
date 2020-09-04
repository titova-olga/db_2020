package homework.never_use_switch;

import heroes.RandomUtil;

public enum MailType {
    WELCOME, SALE, DELAY, BIRTHDAY;

    public static MailType getRandomMailType() {
        int randomIndex = RandomUtil.getIntBetween(0, MailType.values().length);
        return MailType.values()[randomIndex];
    }
}
