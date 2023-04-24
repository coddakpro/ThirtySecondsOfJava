package femaleMenstrualhealthApp.dateFormatClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DateFormatsAcceptance {
    public static void main(String[] args) {
//        String inputDate = "01/Jan/2000";
//        String inputDate = "01-Jan-2000";
        String inputDate = "01 Jan 00";
        String outputDate =  DateFormatsAcceptance.convertDate(inputDate);
        System.out.println("Output date: " + outputDate);

    }



    public static String convertDate(String inputDate) {
        String[] patterns = {
                "dd/MMM/yyyy",
                "dd/MMMM/yyyy",
                "dd/MM/yy",
                "dd-MMM-yyyy",
                "dd-MMMM-yy",
                "dd MMM, yy",
                "dd MMM yy",
                "d EEEE MM yy",
                "dd-MMM-yy",
                "dd/MMM/yy",
                "dd/MMMM/yy",
                "dd MMM, yyyy",
                "dd MMMM, yy",
                "dd MM yyyy",
                "dd MM yy",
                "dd MMMM yyyy",
                "dd-MM-yy",
                "dd/MM/yy",
                "EEEE,d MMMM,yyyy",
                "EEEE,d MMM,yyyy",
                "EEEE d MM yy",
                "EEEE,dd /MM/yy"
        };

        String outputPattern = "dd/MM/yyyy hh:mm:ss a";

        for (String pattern : patterns) {
            try {
                LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern(pattern));
                return DateTimeFormatter.ofPattern(outputPattern).format(date.atStartOfDay());
            } catch (DateTimeParseException e) {
                // try next pattern
            }
        }

        return "Invalid date format";
    }

}


