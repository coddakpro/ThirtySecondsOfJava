package femaleMenstrualhealthApp;

import java.time.LocalDate;
//
//public class MenstrualCycle {
//    private LocalDate menstrualLastFlowFirstDayDate;
//    private int averageMenstrualFlowDurationInDays;
//    private int ovulationPeriodDuration;
//    private String[] safeDatesForSexualMating;
//
//    public MenstrualCycle(LocalDate menstrualLastFlowFirstDayDate, int averageMenstrualFlowDurationInDays, int ovulationPeriodDuration, String[] safeDatesForSexualMating) {
//        this.menstrualLastFlowFirstDayDate = menstrualLastFlowFirstDayDate;
//        this.averageMenstrualFlowDurationInDays = averageMenstrualFlowDurationInDays;
//        this.ovulationPeriodDuration = ovulationPeriodDuration;
//        this.safeDatesForSexualMating = safeDatesForSexualMating;
//    }
//
//    public LocalDate getMenstrualLastFlowFirstDayDate() {
//        return menstrualLastFlowFirstDayDate;
//    }
//
//    public void setMenstrualLastFlowFirstDayDate(LocalDate menstrualLastFlowFirstDayDate) {
//        this.menstrualLastFlowFirstDayDate = menstrualLastFlowFirstDayDate;
//    }
//
//    public int getAverageMenstrualFlowDurationInDays() {
//        return averageMenstrualFlowDurationInDays;
//    }
//
//    public void setAverageMenstrualFlowDurationInDays(int averageMenstrualFlowDurationInDays) {
//        this.averageMenstrualFlowDurationInDays = averageMenstrualFlowDurationInDays;
//    }
//
//    public int getOvulationPeriodDuration() {
//        return ovulationPeriodDuration;
//    }
//
//    public void setOvulationPeriodDuration(int ovulationPeriodDuration) {
//        this.ovulationPeriodDuration = ovulationPeriodDuration;
//    }
//
//    public String[] getSafeDatesForSexualMating() {
//        return safeDatesForSexualMating;
//    }
//
//    public void setSafeDatesForSexualMating(String[] safeDatesForSexualMating) {
//        this.safeDatesForSexualMating = safeDatesForSexualMating;
//    }
//
//    @Override
//    public String toString() {
//        return "MenstrualCycle [menstrualLastFlowFirstDayDate=" + menstrualLastFlowFirstDayDate + ", averageMenstrualFlowDurationInDays=" + averageMenstrualFlowDurationInDays + ", ovulationPeriodDuration=" + ovulationPeriodDuration + ", safeDatesForSexualMating=" + Arrays.toString(safeDatesForSexualMating) + "]";
//    }
//}


import java.time.LocalDate;
import java.util.List;

public class MenstrualCycle {
    private final LocalDate lastFlowFirstDayDate;
    private final List<LocalDate> expectedMonthlyFlowDates;
    private final LocalDate nextExpectedMonthlyFlowDate;
    private final List<LocalDate> safeDatesForSexualMating;
    private final int flowAverageNumberOfDays;

    public MenstrualCycle(LocalDate lastFlowFirstDayDate, List<LocalDate> expectedMonthlyFlowDates,
                          LocalDate nextExpectedMonthlyFlowDate, List<LocalDate> safeDatesForSexualMating,
                          int flowAverageNumberOfDays) {
        this.lastFlowFirstDayDate = lastFlowFirstDayDate;
        this.expectedMonthlyFlowDates = expectedMonthlyFlowDates;
        this.nextExpectedMonthlyFlowDate = nextExpectedMonthlyFlowDate;
        this.safeDatesForSexualMating = safeDatesForSexualMating;
        this.flowAverageNumberOfDays = flowAverageNumberOfDays;
    }

    public LocalDate getLastFlowFirstDayDate() {
        return lastFlowFirstDayDate;
    }

    public List<LocalDate> getExpectedMonthlyFlowDates() {
        return expectedMonthlyFlowDates;
    }

    public LocalDate getNextExpectedMonthlyFlowDate() {
        return nextExpectedMonthlyFlowDate;
    }

    public List<LocalDate> getSafeDatesForSexualMating() {
        return safeDatesForSexualMating;
    }

    public int getFlowAverageNumberOfDays() {
        return flowAverageNumberOfDays;
    }

    // Method to calculate the next expected monthly flow date
    public LocalDate calculateNextExpectedMonthlyFlowDate() {
        return nextExpectedMonthlyFlowDate.plusDays(flowAverageNumberOfDays);
    }
}
