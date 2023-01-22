package pl.javastart.task;

import pl.javastart.task.logic.CardPhoneContract;
import pl.javastart.task.logic.MixPhoneContract;
import pl.javastart.task.logic.Phone;
import pl.javastart.task.logic.SubscriptionPhoneContract;

public class Main {

    public static void main(String[] args) {
        Phone phone1 = new Phone(new CardPhoneContract(0.1, 0.2, 1, 1));
        Phone phone2 = new Phone(new SubscriptionPhoneContract(30));
        Phone phone3 = new Phone(new MixPhoneContract(0.1, 0.2, 1, 1));

        phone1.printAccountState();
        phone1.call(30);
        phone1.printAccountState();
        phone1.call(30);
        phone1.printAccountState();
        phone1.call(10);
        phone1.printAccountState();

//        -----------------------------

        phone2.printAccountState();
//        phone2.sendSms();
//        phone2.printAccountState();
//        phone2.sendSms();
//        phone2.sendSms();
//        phone2.printAccountState();
//        phone2.sendSms();
//        phone2.sendMms();
//        phone2.sendSms();
//        phone2.printAccountState();
//        phone2.call(30);
//        phone2.printAccountState();

//        ------------------

//        phone3.call(60);
        phone3.printAccountState();
//        phone3.call(45);
//        phone3.printAccountState();
//        phone3.call(30);
//        phone3.printAccountState();
    }
}