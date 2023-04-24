package femaleMenstrualhealthApp;//public class MenstrualHealthApp{
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
//}

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenstrualHealthApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for fields of MenstrualCycle class
        System.out.print("Enter date of first day of last menstrual flow (YYYY-MM-DD): ");
        LocalDate lastFlowFirstDayDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter average monthly flow cycle in days (default is 28): ");
        int averageMonthlyFlowCycle = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter average number of days of flow per cycle (default is 5): ");
        int flowAverageNumberOfDays = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        // Call menstralCalculator method to get calculated menstrual cycle data
        List<MenstrualCycle> menstrualCycles = menstralCalculator(lastFlowFirstDayDate, averageMonthlyFlowCycle, flowAverageNumberOfDays);

        // Display calculated menstrual cycle data for next 12 months
        System.out.println("\nExpected menstrual cycle data for next 12 months:");
        for (int i = 0; i < 12; i++) {
            MenstrualCycle cycle = menstrualCycles.get(i);
            System.out.println("Month " + (i + 1) + ":");
            System.out.println("  Expected monthly flow dates: " + cycle.getExpectedMonthlyFlowDates());
            System.out.println("  Next expected monthly flow date: " + cycle.getNextExpectedMonthlyFlowDate());
            System.out.println("  Safe dates for sexual mating: " + cycle.getSafeDatesForSexualMating());
        }
    }

    public static List<MenstrualCycle> menstralCalculator(LocalDate lastFlowFirstDayDate, int averageMonthlyFlowCycle, int flowAverageNumberOfDays) {
        List<MenstrualCycle> menstrualCycles = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            // Calculate expected monthly flow dates
            List<LocalDate> expectedMonthlyFlowDates = new ArrayList<>();
            LocalDate nextExpectedMonthlyFlowDate = lastFlowFirstDayDate.plusDays(averageMonthlyFlowCycle);
            for (int j = 0; j < 12; j++) {
                expectedMonthlyFlowDates.add(nextExpectedMonthlyFlowDate);
                nextExpectedMonthlyFlowDate = nextExpectedMonthlyFlowDate.plusDays(averageMonthlyFlowCycle);
            }

            // Calculate safe dates for sexual mating
            LocalDate startOfSafeDays = lastFlowFirstDayDate.plusDays(averageMonthlyFlowCycle - 18);
            LocalDate endOfSafeDays = lastFlowFirstDayDate.plusDays(averageMonthlyFlowCycle - 10);
            List<LocalDate> safeDatesForSexualMating = new ArrayList<>();
            for (LocalDate date = startOfSafeDays; date.isBefore(endOfSafeDays.plusDays(1)); date = date.plusDays(1)) {
                safeDatesForSexualMating.add(date);
            }

            // Create MenstrualCycle object and add to list
            MenstrualCycle cycle = new MenstrualCycle(lastFlowFirstDayDate, expectedMonthlyFlowDates, nextExpectedMonthlyFlowDate, safeDatesForSexualMating, flowAverageNumberOfDays);
            menstrualCycles.add(cycle);

            // Update lastFlowFirstDayDate for next iteration
            lastFlowFirstDayDate = nextExpectedMonthlyFlowDate;
        }

        return menstrualCycles;
    }

}






//
//
//public class MenstrualHealthApp {
//    // ... existing code ...
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // ... existing code ...
//
//        // Call menstralCalculator method to get calculated menstrual cycle data
//        List<MenstrualCycle> menstrualCycles = menstralCalculator(lastFlowFirstDayDate, averageMonthlyFlowCycle, flowAverageNumberOfDays);
//
//        // Display calculated menstrual cycle data for next 12 months
//        System.out.println("\nExpected menstrual cycle data for next 12 months:");
//        for (int i = 0; i < 12; i++) {
//            MenstrualCycle cycle = menstrualCycles.get(i);
//            System.out.println("Month " + (i + 1) + ":");
//            System.out.println("  Expected monthly flow dates: " + cycle.getExpectedMonthlyFlowDates());
//            System.out.println("  Next expected monthly flow date: " + cycle.getNextExpectedMonthlyFlowDate());
//            System.out.println("  Safe dates for sexual mating: " + cycle.getSafeDatesForSexualMating());
//
//            // Use cycle.getNextExpectedMonthlyFlowDate() to get next expected monthly flow date
//            LocalDate nextExpectedMonthlyFlowDate = cycle.getNextExpectedMonthlyFlowDate();
//            System.out.println("  Next expected monthly flow date after that: " + cycle.calculateNextExpectedMonthlyFlowDate());
//        }
//    }
//}

//
//
//import java.time.LocalDate;
//        import java.time.format.DateTimeParseException;
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Scanner;
//
//public class MenstrualHealthApp {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Prompt for the last menstrual flow first day date
//        LocalDate lastFlowFirstDayDate = null;
//        while (lastFlowFirstDayDate == null) {
//            System.out.println("Enter the date of the first day of your last menstrual flow (in yyyy-MM-dd format):");
//            String input = scanner.nextLine();
//
//            try {
//                lastFlowFirstDayDate = LocalDate.parse(input);
//            } catch (DateTimeParseException e) {
//                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
//            }
//        }
//
//        // Prompt for the average monthly flow cycle length
//        int averageMonthlyFlowCycle = 28;
//        while (true) {
//            System.out.println("Enter the average length of your menstrual cycle in days (default: 28):");
//            String input = scanner.nextLine();
//
//            if (input.isEmpty()) {
//                break;
//            }
//
//            try {
//                averageMonthlyFlowCycle = Integer.parseInt(input);
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input. Please enter a number.");
//            }
//        }
//
//        // Prompt for the average length of menstrual flow
//        int flowAverageNumberOfDays = 5;
//        while (true) {
//            System.out.println("Enter the average length of your menstrual flow in days (default: 5):");
//            String input = scanner.nextLine();
//
//            if (input.isEmpty()) {
//                break;
//            }
//
//            try {
//                flowAverageNumberOfDays = Integer.parseInt(input);
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input. Please enter a number.");
//            }
//        }
//
//        // Call menstralCalculator method to get calculated menstrual cycle data
//        List<MenstrualCycle> menstrualCycles = menstralCalculator(lastFlowFirstDayDate, averageMonthlyFlowCycle, flowAverageNumberOfDays);
//
//        // Display calculated menstrual cycle data for next 12 months
//        System.out.println("\nExpected menstrual cycle data for next 12 months:");
//        for (int i = 0; i < 12; i++) {
//            MenstrualCycle cycle = menstrualCycles.get(i);
//            System.out.println("Month " + (i + 1) + ":");
//            System.out.println("  Expected monthly flow dates: " + cycle.getExpectedMonthlyFlowDates());
//            System.out.println("  Next expected monthly flow date: " + cycle.getNextExpectedMonthlyFlowDate());
//            System.out.println("  Safe dates for sexual mating: " + cycle.getSafeDatesForSexualMating());
//
//            // Use cycle.getNextExpectedMonthlyFlowDate() to get next expected monthly flow date
//            LocalDate nextExpectedMonthlyFlowDate = cycle.getNextExpectedMonthlyFlowDate();
//            System.out.println("  Next expected monthly flow date after that: " + cycle.calculateNextExpectedMonthlyFlowDate());
//        }
//    }
//
//    // Method to calculate menstrual cycle data
//    public static List<MenstrualCycle> menstralCalculator(LocalDate lastFlowFirstDayDate, int averageMonthlyFlowCycle, int flowAverageNumberOfDays) {
//        List<MenstrualCycle> menstrualCycles = new ArrayList<>();
//
//        for (int i = 0; i < 12; i++) {
//            LocalDate lastFlowFirstDayDateForNextCycle = i == 0 ? lastFlowFirstDayDate : menstrualCycles.get
