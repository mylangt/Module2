package ss3_static.exercise3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateUtil {
    private final static DateTimeFormatter formatter_ddMMyyyy = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final static DateTimeFormatter formatter_yyyyMMdd = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public static LocalDate fromString_ddMMyyyy(String date) {
        return LocalDate.parse(date, formatter_ddMMyyyy);
    }

    public static LocalDate fromString_yyyyMMdd(String date) {
        return LocalDate.parse(date, formatter_yyyyMMdd);
    }

    public static String toString_ddMMyyyy(LocalDate date) {
        return date.format(formatter_ddMMyyyy);
    }

    public static String toString_yyyyMMdd(LocalDate date) {
        return date.format(formatter_yyyyMMdd);
    }
}
