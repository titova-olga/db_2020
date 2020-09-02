package homework.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Evgeny Borisov
 */
public class HttpCodeService {

    public void processHttp(String text) {

        String keyWord = "httpcode:";
        String regex = keyWord + "\\s?\\d{3}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            String subString = matcher.group();
            int headDigit = Character.getNumericValue(subString.charAt(subString.length() - 3));

            HttpCode.findByKey(headDigit).sendMessage();
        }
    }

    public static void main(String[] args) {
        String text = "olya httpcode: 404 hello.";
        HttpCodeService httpCodeService = new HttpCodeService();
        httpCodeService.processHttp(text);
    }
}
