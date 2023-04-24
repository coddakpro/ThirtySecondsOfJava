////import java.time.LocalDate;
////import java.time.format.DateTimeFormatter;
////import java.util.ArrayList;
////import java.util.List;
////import java.util.Scanner;
////
////public class MenstrualCycleCalculator1 {
////    private LocalDate lastPeriodStartDate;
////    private int cycleLength;
////
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////
////        System.out.print("Enter your last period start date (yyyy-MM-dd): ");
////        String dateString = scanner.nextLine();
////
////        LocalDate lastPeriodStartDate = null;
////        try {
////            lastPeriodStartDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
////        } catch (Exception e) {
////            System.out.println("Invalid date format, please try again.");
////            System.exit(1);
////        }
////
////        System.out.print("Enter your menstrual cycle length (in days): ");
////        int cycleLength = 0;
////        try {
////            cycleLength = Integer.parseInt(scanner.nextLine());
////            if (cycleLength <= 0) {
////                throw new Exception();
////            }
////        } catch (Exception e) {
////            System.out.println("Invalid cycle length, please try again.");
////            System.exit(1);
////        }
////
////        LocalDate lastOvulationDate = lastPeriodStartDate.plusDays((int) (cycleLength * 0.5));
////
////        List<MenstrualCycle> menstrualCycleList = new ArrayList<>();
////        for (int i = 0; i < 12; i++) {
////            menstrualCycleList.add(new MenstrualCycle(lastPeriodStartDate, cycleLength));
////            lastPeriodStartDate = lastPeriodStartDate.plusDays(cycleLength);
////        }
////
////        System.out.println("Next 12 menstrual cycle dates:");
////        for (MenstrualCycle cycle : menstrualCycleList) {
////            System.out.println(cycle.getNextPeriodStartDate());
////        }
////
////        System.out.println("Ovulation fertility window:");
////        System.out.println(menstrualCycleList.get(0).getOvulationStartDate() + " to " + menstrualCycleList.get(0).getOvulationEndDate());
////
////        System.out.println("Safe dates for intercourse:");
////        System.out.println(menstrualCycleList.get(0).getSafeStartDate() + " to " + menstrualCycleList.get(0).getSafeEndDate());
////    }
////
////    public MenstrualCycle(LocalDate lastPeriodStartDate, int cycleLength) {
////        this.lastPeriodStartDate = lastPeriodStartDate;
////        this.cycleLength = cycleLength;
////    }
////
////    public LocalDate getNextPeriodStartDate() {
////        return lastPeriodStartDate.plusDays(cycleLength);
////    }
////
////    public LocalDate getOvulationStartDate() {
////        return lastPeriodStartDate.plusDays((int) (cycleLength * 0.4));
////    }
////
////    public LocalDate getOvulationEndDate() {
////        return lastPeriodStartDate.plusDays((int) (cycleLength * 0.5));
////    }
////
////    public LocalDate getSafeStartDate() {
////        return lastPeriodStartDate.plusDays((int) (cycleLength * 0.6));
////    }
////
////    public LocalDate getSafeEndDate() {
////        return lastPeriodStartDate.plusDays((int) (cycleLength * 0.9));
////    }
////
////
////}
////
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//  public class MenstrualCycleCalculator {
//
//
//      public static void main(String[] args) {
//         String result = MenstrualCycleCalculator(LocalDate lastPeriodStartDate, int menstrualCycleLength, LocalDate
//          lastOvulationDate);
//
//      }
//          private LocalDate lastPeriodStartDate;
//          private int menstrualCycleLength;
//          private LocalDate lastOvulationDate;
//
//          Scanner scanner = new Scanner(System.in);
//
//        public MenstrualCycleCalculator(LocalDate lastPeriodStartDate, int menstrualCycleLength, LocalDate
//          lastOvulationDate){
//              this.lastPeriodStartDate = lastPeriodStartDate;
//              this.menstrualCycleLength = menstrualCycleLength;
//              this.lastOvulationDate = lastOvulationDate;
//          }
//
//          public List<LocalDate> calculateMenstrualCycleDates () throws IllegalArgumentException {
//              if (menstrualCycleLength <= 0) {
//                  throw new IllegalArgumentException("Menstrual cycle length must be positive");
//              }
//              List<LocalDate> menstrualCycleDates = new ArrayList<>();
//              LocalDate startDate = lastPeriodStartDate;
//              while (startDate.isBefore(LocalDate.now().plusYears(1))) {
//                  menstrualCycleDates.add(startDate);
//                  startDate = startDate.plusDays(menstrualCycleLength);
//              }
//              return menstrualCycleDates;
//          }
//
//          public LocalDate calculateNextPeriodStartDate () throws IllegalArgumentException {
//              if (menstrualCycleLength <= 0) {
//                  throw new IllegalArgumentException("Menstrual cycle length must be positive");
//              }
//              LocalDate lastPeriodEndDate = lastPeriodStartDate.plusDays(menstrualCycleLength - 1);
//              return lastPeriodEndDate.plusDays(1);
//          }
//
//          public List<LocalDate> calculateOvulationDates () throws IllegalArgumentException {
//              if (lastOvulationDate == null) {
//                  return null;
//              }
//              List<LocalDate> ovulationDates = new ArrayList<>();
//              LocalDate startDate = lastOvulationDate;
//              while (startDate.isBefore(LocalDate.now().plusYears(1))) {
//                  ovulationDates.add(startDate);
//                  startDate = startDate.plusDays(28);
//              }
//              return ovulationDates;
//          }
//
//          public List<LocalDate> calculateSafeDatesForIntercourse () throws IllegalArgumentException {
//              if (menstrualCycleLength <= 0) {
//                  throw new IllegalArgumentException("Menstrual cycle length must be positive");
//              }
//              LocalDate startDate = lastPeriodStartDate;
//              List<LocalDate> safeDates = new ArrayList<>();
//              while (startDate.isBefore(LocalDate.now().plusYears(1))) {
//                  LocalDate fertileStartDate = startDate.plusDays(menstrualCycleLength - 20);
//                  LocalDate fertileEndDate = startDate.plusDays(menstrualCycleLength - 10);
//                  safeDates.add(startDate.plusDays(menstrualCycleLength));
//                  safeDates.add(startDate.plusDays(menstrualCycleLength).plusDays(7));
//                  safeDates.add(startDate.plusDays(menstrualCycleLength).plusDays(14));
//                  safeDates.add(startDate.plusDays(menstrualCycleLength).plusDays(21));
//                  safeDates.add(startDate.plusDays(menstrualCycleLength).plusDays(28));
//                  startDate = startDate.plusDays(menstrualCycleLength);
//              }
//              return safeDates;
//          }
//
//
//        }
//
////
////
////
////
////
////
//////
//////
//////    public class MenstrualCycleCalculator {
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////
////}
//////            // Read user inputs
//////            System.out.println("Enter your last period start date (yyyy-MM-dd):");
//////            String lastPeriodStartString = scanner.nextLine();
//////            System.out.println("Enter your menstrual cycle length (in days):");
//////            int cycleLength = scanner.nextInt();
//////
//////            // Parse the last period start date
//////            LocalDate lastPeriodStart = LocalDate.parse(lastPeriodStartString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//////
//////            // Calculate next period start date
//////            LocalDate nextPeriodStart = lastPeriodStart.plusDays(cycleLength);
//////
//////            // Calculate fertile window
//////            LocalDate fertileStart = nextPeriodStart.minusDays(14);
//////            LocalDate fertileEnd = nextPeriodStart.minusDays(10);
//////
//////            // Output the results
//////            System.out.println("Your next period start date is " + nextPeriodStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//////            System.out.println("Your fertile window is from " + fertileStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " to " + fertileEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//////        }
//////    }
//////
//////
