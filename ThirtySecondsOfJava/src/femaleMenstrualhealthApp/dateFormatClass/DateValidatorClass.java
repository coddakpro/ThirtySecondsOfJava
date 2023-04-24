package femaleMenstrualhealthApp.dateFormatClass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DateValidatorClass {
        public static boolean isValidDate(String inputDate) {
            String format = "yyyy-MM-dd HH:mm:ss";
            try {
                LocalDateTime.parse(inputDate, DateTimeFormatter.ofPattern(format));
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }
        }

        public static void main(String[] args) {
            String inputDate = "2022-01-01 12:00:00";
            if (isValidDate(inputDate)) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime inputDateTime = LocalDateTime.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                long difference = java.time.Duration.between(now, inputDateTime).toMillis();
                System.out.println("Difference in milliseconds: " + difference);
            } else {
                System.out.println("Invalid date format");
            }
        }
    }


