package pl.javastart.task;

public abstract class Contract extends Phone {
    private double smsCost;
    private double oneMinuteCallCost;
    private double mmsCost;

    public Contract(double smsCost, double oneMinuteCallCost, double mmsCost) {
        this.smsCost = smsCost;
        this.oneMinuteCallCost = oneMinuteCallCost;
        this.mmsCost = mmsCost;
    }

    public double getSmsCost() {
        return smsCost;
    }

    public void setSmsCost(double smsCost) {
        this.smsCost = smsCost;
    }

    public double getOneMinuteCallCost() {
        return oneMinuteCallCost;
    }

    public void setOneMinuteCallCost(double oneMinuteCallCost) {
        this.oneMinuteCallCost = oneMinuteCallCost;
    }

    public double getMmsCost() {
        return mmsCost;
    }

    public void setMmsCost(double mmsCost) {
        this.mmsCost = mmsCost;
    }


}
