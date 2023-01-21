package pl.javastart.task;

class CardPhoneContract extends Contract {
    private double accountBalance;
    private int sumSms;
    private int sumMms;
    private int sumPhoneCallSeconds;

    public CardPhoneContract(double smsCost, double oneMinuteCallCost, double mmsCost, double balance) {
        super(smsCost, oneMinuteCallCost, mmsCost);
        this.accountBalance = balance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    private void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public void sendSms() {
        super.sendSms();
        if (accountBalance >= getSmsCost()) {
            System.out.println("SMS wysłany");
            setAccountBalance(- getSmsCost());
            sumSms++;
        } else {
            System.out.println("Nie udało się wysłać SMSa");
        }
    }

    @Override
    public void sendMms() {
        super.sendMms();
        if (accountBalance >= getMmsCost()) {
            System.out.println("MMS wysłany");
            setAccountBalance(- getMmsCost());
            sumMms++;
        } else {
            System.out.println("Nie udało się wysłać MMSa");
        }
    }

    @Override
    public void call(int seconds) {
        super.call(seconds);
        if (accountBalance > seconds) {
            System.out.println("Rozmowa trwała: " + seconds + " sekund");
            sumPhoneCallSeconds += seconds;
        } else if (accountBalance < seconds) {
            System.out.println("Brak środków na koncie, nie możesz zadzwonić");
        }
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
        System.out.println("Wysłanych SMSów: " + sumSms);
        System.out.println("Wysłanych MMSów: " + sumMms);
        System.out.println("Liczba sekund rozmowy: " + sumPhoneCallSeconds);
        System.out.println("Na koncie zostało " + accountBalance + " zł");
    }
}
