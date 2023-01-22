package pl.javastart.task;

public class Main {

    public static void main(String[] args) {

        Phone phone1 = new Phone(new CardPhoneContract(0.5, 0.5, 0.5, 1));
        Phone phone2 = new Phone(new SubscriptionPhoneContract(1, 1, 1));

        phone2.printAccountState();
        phone2.sendSms();
        phone2.printAccountState();
        phone2.sendSms();
        phone2.sendSms();
        phone2.printAccountState();
        phone2.sendSms();
        phone2.sendMms();
        phone2.sendSms();
        phone2.printAccountState();
        phone2.call(30);
        phone2.printAccountState();

//        phone1.printAccountState();
//        phone1.sendMms();
//        phone1.printAccountState();
//        phone1.sendMms();
//        phone1.printAccountState();
//        phone1.sendMms();
//        phone1.printAccountState();

//        -------------------

//        phone1.call(60);
//        phone1.printAccountState();
//        phone1.call(30);
//        phone1.printAccountState();
//        phone1.call(30);
//        phone1.printAccountState();

    }
}
