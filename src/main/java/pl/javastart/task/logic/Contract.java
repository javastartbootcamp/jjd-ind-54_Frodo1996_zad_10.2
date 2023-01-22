package pl.javastart.task.logic;

public abstract class Contract {
    double smsCost;
    double oneMinuteCallCost;
    double mmsCost;
    int sentSms;
    int sentMms;
    int sumPhoneCallSeconds;
    int name;

    public Contract(double smsCost, double oneMinuteCallCost, double mmsCost) {
        this.smsCost = smsCost;
        this.oneMinuteCallCost = oneMinuteCallCost;
        this.mmsCost = mmsCost;
    }

    public Contract() {
    }

    public abstract String contractName();

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

    public abstract void sendSms();

    public abstract void call(int seconds);

    public abstract void sendMms();

    public void smsSent() {
        System.out.println("SMS wysłany\n");
    }

    public int sumSentSms() {
        return sentSms++;
    }

    public int numberOfSentSms() {
        return sentSms;
    }

    public void mmsSent() {
        System.out.println("MMS wysłany\n");
    }

    public int sumSentMms() {
        return sentMms++;
    }

    public int numberOfSentMms() {
        return sentMms;
    }

    public int sumPhoneCallSeconds(int seconds) {
        return sumPhoneCallSeconds + seconds;
    }

    public int timeInSecondsUsedForCalls() {
        return sumPhoneCallSeconds;
    }

    public double calculateCost(int seconds) {
        return 0;
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

    public void printAccountState() {
        System.out.println("=== STAN KONTA: " + contractName() + " ===");
    }

    public void printCallSummary(int seconds) {
        System.out.println("Rozmowa trwała: " + seconds + " sekund\n");
    }
}