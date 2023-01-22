package pl.javastart.task.logic;

public class CardPhoneContract extends Contract {
    double accountBalance;
    int sumPhoneCallSeconds;
    static final int SECONDS_IN_MINUTE = 60;

    public CardPhoneContract(double smsCost, double mmsCost, double oneMinuteCallCost, double balance) {
        super(smsCost, oneMinuteCallCost, mmsCost);
        this.accountBalance = balance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public void sendSms() {
        if (accountBalance == 0 || accountBalance < getSmsCost()) {
            noMoneyToSendSms();
        } else if (accountBalance >= getSmsCost()) {
            smsSent();
            setAccountBalance(getAccountBalance() - getSmsCost());
            sumSentSms();
        }
    }

    @Override
    public void sendMms() {
        if (accountBalance == 0 || accountBalance < getMmsCost()) {
            noMoneyToSendMms();
        } else if (accountBalance >= getMmsCost()) {
            mmsSent();
            setAccountBalance(getAccountBalance() - getMmsCost());
            sumSentMms();
        }
    }

    @Override
    public void call(int seconds) {
        if (accountBalance == 0 && (accountBalance * 100) < seconds) {
            noMoneyToCall();
        } else if ((accountBalance * 100) >= seconds) {
            System.out.println("Rozmowa trwała: " + seconds + " sekund");
            sumPhoneCallSeconds += seconds;
            setAccountBalance(getAccountBalance() - calculateCost(seconds));
        } else {
            System.out.println("Rozmowa trwała: " + seconds + " sekund i wyzerowałeś konto");
            setAccountBalance(0);
        }
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
        System.out.println("Wysłanych SMSów: " + numberOfSentSms());
        System.out.println("Wysłanych MMSów: " + numberOfSentMms());
        System.out.println("Liczba sekund rozmowy: " + sumPhoneCallSeconds);
        System.out.println("Na koncie zostało ");
        System.out.printf("%.2f", getAccountBalance());
        System.out.print(" zł\n\n");
    }

    @Override
    public double calculateCost(int seconds) {
        return getOneMinuteCallCost() / SECONDS_IN_MINUTE * seconds;
    }

    @Override
    public String contractName() {
        return "'NA KARTĘ'";
    }
}