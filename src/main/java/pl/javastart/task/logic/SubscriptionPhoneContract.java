package pl.javastart.task.logic;

public class SubscriptionPhoneContract extends Contract {
    int sumPhoneCallSeconds;
    int costOfSubscription;

    public SubscriptionPhoneContract(int costOfSubscription) {
        this.costOfSubscription = costOfSubscription;
        this.setSmsCost(0);
        this.setMmsCost(0);
        this.setOneMinuteCallCost(0);
    }

    @Override
    public void sendSms() {
        smsSent();
        sumSentSms();
    }

    @Override
    public void sendMms() {
        mmsSent();
        sumSentMms();
    }

    @Override
    public void call(int seconds) {
        System.out.println("Rozmowa trwała: " + seconds + " sekund");
        sumPhoneCallSeconds += seconds;
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
        System.out.println("Wysłanych SMSów: " + numberOfSentSms());
        System.out.println("Wysłanych MMSów: " + numberOfSentMms());
        System.out.println("Liczba sekund rozmowy: " + sumPhoneCallSeconds);
        System.out.println("Na koncie zostało: KONTO NO LIMIT");
        System.out.println("Miesięczny koszt abonamentu: " + costOfSubscription + " zł\n");
    }

    @Override
    public String contractName() {
        return "'NA ABONAMENT'";
    }
}