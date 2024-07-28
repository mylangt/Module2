package ss3_static.exercise3;

import java.time.LocalDate;

public class LocalDateUtilManagement {
    public static void main(String[] args) {
        String dateString1 = "24/03/2001";
        String dateString2 = "1969/12/15";

        LocalDate date1 = LocalDateUtil.fromString_ddMMyyyy(dateString1);
        LocalDate date2 = LocalDateUtil.fromString_yyyyMMdd(dateString2);

        System.out.println("LocalDate tu chuoi dd/MM/yyyy: " + date1);
        System.out.println("LocalDate tu chuoi yyyy/MM/dd: " + date2);

        LocalDate currentDate = LocalDate.now();

        String formattedDate1 = LocalDateUtil.toString_ddMMyyyy(currentDate);
        String formattedDate2 = LocalDateUtil.toString_yyyyMMdd(currentDate);

        System.out.println("Chuoi tu LocalDate (dd/MM/yyyy): " + formattedDate1);
        System.out.println("Chuoi tu LocalDate (yyyy/MM/dd): " + formattedDate2);
    }
}
