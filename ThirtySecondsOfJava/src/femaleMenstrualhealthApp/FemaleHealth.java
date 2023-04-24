package femaleMenstrualhealthApp;

public class FemaleHealth<MenstrualCycle> {
    private MenstrualCycle menstrualCycle;

    public FemaleHealth(MenstrualCycle menstrualCycle) {
        this.menstrualCycle = menstrualCycle;
    }

    public MenstrualCycle getMenstrualCycle() {
        return menstrualCycle;
    }

    public void setMenstrualCycle(MenstrualCycle menstrualCycle) {
        this.menstrualCycle = menstrualCycle;
    }

    @Override
    public String toString() {
        return "FemaleHealth [menstrualCycle=" + menstrualCycle + "]";
    }
}
