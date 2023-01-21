package pl.javastart.task;

class MixPhoneContract extends Contract {
    private static int SMS_LIMIT = 100;
    private static int MMS_LIMIT = 50;
    private static double MINUTES_FOR_CALL_LIMIT = 100;
    private static final int LIMIT_END = 0;
    private double accountBalance;
    private int sumSms;
    private int sumMms;
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
        if (SMS_LIMIT > LIMIT_END) {
            System.out.println("SMS wysłany");
            SMS_LIMIT--;
            sumSms++;
        } else if (getAccountBalance() >= getSmsCost()) {
            System.out.println("SMS wysłany, kosztował: " + getSmsCost() + " zł");
            setAccountBalance(- getSmsCost());
        } else {
            System.out.println("Nie udało się wysłać SMSa");
        }
    }

    @Override
    public void sendMms() {
        if (MMS_LIMIT > LIMIT_END) {
            System.out.println("MMS wysłany");
            MMS_LIMIT--;
            sumMms++;
        } else if (getAccountBalance() >= getMmsCost()) {
            System.out.println("MMS wysłany, kosztował: " + getMmsCost() + " zł");
            setAccountBalance(- getMmsCost());
        } else {
            System.out.println("Nie udało się wysłać MMSa");
        }
    }

    @Override
    public void call(int seconds) {
        if (MINUTES_FOR_CALL_LIMIT > LIMIT_END) {
            System.out.println("Rozmowa trwała: " + seconds + " sekund");
            double calculateMinutesToSeconds = (MINUTES_FOR_CALL_LIMIT * 60) - seconds;
            MINUTES_FOR_CALL_LIMIT = (calculateMinutesToSeconds / 60) - MINUTES_FOR_CALL_LIMIT;
            sumPhoneCallSeconds += seconds;
        } else if (getAccountBalance() >= seconds) {
            System.out.println("Rozmowa trwała: " + seconds + " sekund");
        } else {
            System.out.println("Brak środków na koncie");
        }
    }

    @Override
    public void printAccountState() {
        super.printAccountState();
        System.out.println("Wysłanych SMSów: " + sumSms);
        System.out.println("Wysłanych MMSów: " + sumMms);
        System.out.println("Liczba sekund rozmowy: " + sumPhoneCallSeconds);
        System.out.println("Na koncie zostało " + getAccountBalance() + " zł");
    }
}
