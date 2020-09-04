package date_time;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static date_time.Main.convert;
import static date_time.Main.daysBetween;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testConvertFromDateToLocalDate() {
        LocalDateTime predictedDate = convert(new Date(120, 8, 4, 9, 30));
        LocalDateTime expectedDate = LocalDateTime.of(2020, 9, 4, 9, 30);
        Assert.assertEquals(expectedDate, predictedDate);
    }

    @Test
    public void testConvertFromLocalDateToDate() {
        Date predictedDate = convert(LocalDate.of(2020, 9, 4));
        Date expectedDate = new Date(120, 8, 4);
        Assert.assertEquals(expectedDate, predictedDate);
    }

    @Test
    public void testDaysBetweenTwoDatesInStringFormat() {
        String firstDate = "2020/09/04&10:30";
        String lastDate = "2021/09/04&10:30";
        Assert.assertEquals(daysBetween(firstDate, lastDate), 365);
    }
}