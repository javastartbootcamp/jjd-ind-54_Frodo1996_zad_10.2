package pl.javastart.task;

import java.io.PrintStream;

class MixPhoneContract extends Contract {
    private static final int SMS_LIMIT = 100;
    private static final int MMS_LIMIT = 50;
    private static final int SECONDS_LIMIT = 60;
    private static final int SECONDS_IN_MINUTE = 60;
    private double accountBalance;
    private int sentSms;
    private int sentMms;
    private int sumPhoneCallSeconds;

    public MixPhoneContract(double smsCost, double oneMinuteCallCost, double mmsCost, double accountBalance) {
        super(smsCost, oneMinuteCallCost, mmsCost);
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    private void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public void sendSms() {
        if (sentSms <= SMS_LIMIT) {
            smsSent();
            sentSms++;
        } else if (getAccountBalance() >= getSmsCost()) {
            System.out.println("SMS wysłany, kosztował: " + getSmsCost() + " zł");
            accountBalance -= getSmsCost();
        } else {
            noMoneyToSendSms();
        }
    }

    @Override
    public void sendMms() {
        if (sentMms <= MMS_LIMIT) {
            mmsSent();
            sentMms++;
        } else if (getAccountBalance() >= getMmsCost()) {
            System.out.println("MMS wysłany, kosztował: " + getMmsCost() + " zł");
            accountBalance -= getMmsCost();
        } else {
            noMoneyToSendMms();
        }
    }

    @Override
    public void call(int seconds) {
        int freeSeconds = SECONDS_LIMIT - sumPhoneCallSeconds;
        int secondsToPay = seconds - freeSeconds;
        if (accountBalance == 0) {
            noMoneyToCall();
        } else if (secondsToPay <= 0) {
            sumPhoneCallSeconds += seconds;
            printCallSummary(seconds);
        } else if (calculateMaxPhoneCallInSeconds() >= secondsToPay) {
            sumPhoneCallSeconds += seconds;
            setAccountBalance(getAccountBalance() - calculateCost(secondsToPay));
            printCallSummary(seconds);
        } else {
            sumPhoneCallSeconds += calculateMaxPhoneCallInSeconds();
            System.out.println("Mogłeś rozmawiać tylko: " + calculateMaxPhoneCallInSeconds() + " sekund");
            setAccountBalance(0);
        }
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
        System.out.println("Wysłanych SMSów: " + sentSms);
        System.out.println("Wysłanych MMSów: " + sentMms);
        System.out.println("Liczba sekund rozmowy: " + sumPhoneCallSeconds);
        System.out.println("Na koncie zostało: ");
        System.out.printf("%.2f", getAccountBalance());
        System.out.print(" zł\n\n");

    }
}
