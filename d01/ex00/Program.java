package day01.ex00;

import java.util.UUID;

public class Program {

    static long random1 = 4356178;
    static long random2 = 794555856;

    public static void main(String[] args) {
        User John = new User("John", 45, 1000);
        User Mike = new User("Mike", 26, 1200);

        System.out.println(John.getName() + ", ID - " + John.getIdentifier() + ", Balance - " + John.getBalance());
        System.out.println(Mike.getName() + ", ID - " + Mike.getIdentifier() + ", Balance - " + Mike.getBalance());
        
        UUID transId1 = new UUID(random1, random2);
        UUID transId2 = new UUID(random1 + 1000, random2 + 2000);
        
        Transaction trans1 = new Transaction(transId1, John, Mike, 500);
        Transaction trans2 = new Transaction(transId1, John, Mike, -500);

        printTransaction(John.getName(), Mike.getName(), trans1.getAmount(), trans1.getIdentifier());
        printTransaction(John.getName(), Mike.getName(), trans2.getAmount(), trans2.getIdentifier());

        System.out.println(John.getName() + ", ID - " + John.getIdentifier() + ", Balance - " + John.getBalance());
        System.out.println(Mike.getName() + ", ID - " + Mike.getIdentifier() + ", Balance - " + Mike.getBalance());
        
        Transaction trans3 = new Transaction(transId2, Mike, John, 300);
        Transaction trans4 = new Transaction(transId2, Mike, John, -300);
        
        printTransaction(Mike.getName(), John.getName(), trans3.getAmount(), trans3.getIdentifier());
        printTransaction(Mike.getName(), John.getName(), trans4.getAmount(), trans4.getIdentifier());

        System.out.println(John.getName() + ", ID - " + John.getIdentifier() + ", Balance - " + John.getBalance());
        System.out.println(Mike.getName() + ", ID - " + Mike.getIdentifier() + ", Balance - " + Mike.getBalance());
    }

    static public void printTransaction(String rec, String sen, int amount, UUID id) {
        if (amount < 0) {
            System.out.println(sen + " -> " + rec + ", -" + (-amount) + ", OUTCOME, " + id);
            System.out.println(rec + " -> " + sen + ", +" + (-amount) + ", INCOME, " + id);
        } else {
            System.out.println(sen + " -> " + rec + ", -" + amount + ", OUTCOME, " + id);
            System.out.println(rec + " -> " + sen + ", +" + amount + ", INCOME, " + id);
        }
    }


}