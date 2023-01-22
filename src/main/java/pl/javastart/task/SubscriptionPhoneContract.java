package pl.javastart.task;

class SubscriptionPhoneContract extends Contract {
    private int sumSms;
    private int sumMms;
    private int sumPhoneCallSeconds;

    public SubscriptionPhoneContract(double smsCost, double oneMinuteCallCost, double mmsCost) {
        super(smsCost, oneMinuteCallCost, mmsCost);
        this.setSmsCost(0);
        this.setMmsCost(0);
        this.setOneMinuteCallCost(0);
    }

    @Override
    public void sendSms() {
        smsSent();
        sumSms++;
    }

    @Override
    public void sendMms() {
        mmsSent();
        sumMms++;
    }

    @Override
    public void call(int seconds) {
        System.out.println("Rozmowa trwała: " + seconds + " sekund");
        sumPhoneCallSeconds += seconds;
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
        System.out.println("Wysłanych SMSów: " + sumSms);
        System.out.println("Wysłanych MMSów: " + sumMms);
        System.out.println("Liczba sekund rozmowy: " + sumPhoneCallSeconds);
        System.out.println("Na koncie zostało: KONTO NO LIMIT");
        int costOfSubscription = 30;
        System.out.println("Miesięczny koszt abonamentu: " + costOfSubscription + " zł\n");
    }
}
