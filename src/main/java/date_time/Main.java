package date_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * @author Evgeny Borisov
 */
public class Main {

    public static Date convert(LocalDate date) {
        return java.util.Date.from(date.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static LocalDateTime convert(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    // 1981/02/30&18:20
    public static int daysBetween(String firstDate, String lastDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd&HH:mm");
        LocalDateTime date1 = LocalDateTime.parse(firstDate, formatter);
        LocalDateTime date2 = LocalDateTime.parse(lastDate, formatter);
        return (int) Duration.between(date1, date2).toDays();
    }

    public static void main(String[] args) {
        System.out.println(daysBetween("2020/02/14&18:30", "2020/02/15&18:30"));
    }
}
