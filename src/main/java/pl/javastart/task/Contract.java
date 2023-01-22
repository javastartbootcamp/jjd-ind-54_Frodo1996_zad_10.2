package pl.javastart.task;

public abstract class Contract {
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

    public void sendSms() {
    }

    public void call(int seconds) {
    }

    public void sendMms() {
    }

    public void printAccountState() {
        System.out.println("=== STAN KONTA ===");
    }

    public void printCallSummary(int seconds) {
        System.out.println("Rozmowa trwała: " + seconds + " sekund\n");
    }

    public void smsSent() {
        System.out.println("SMS wysłany\n");
    }

    public void mmsSent() {
        System.out.println("MMS wysłany\n");
    }

    public void noMoneyToCall() {
        System.out.println("Brak środków na koncie, nie możesz zadzwonić");
    }

    public void noMoneyToSendSms() {
        System.out.println("Nie udało się wysłać SMSa");
    }

    public void noMoneyToSendMms() {
        System.out.println("Nie udało się wysłać MMSa");
    }

    public double calculateCost(int seconds) {
        return 0;
    }
}
