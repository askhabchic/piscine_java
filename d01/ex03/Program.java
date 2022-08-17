package day01.ex03;
import java.util.UUID;
public class Program {
    public static long uid1 = 990089;
    public static long uid2 = 915215199;
    public static void main(String[] argc) {
        UsersArrayList userList = new UsersArrayList();
        userList.addUser(new User("Adam", 10000));
        userList.addUser(new User("Steve", 25000));
        System.out.println(userList.retrieveUserByIndex(0).getName() + "[ID=" + userList.retrieveUserByIndex(0).getIdentifier() + "] balance is " + userList.retrieveUserByIndex(0).getBalance());
        System.out.println(userList.retrieveUserByIndex(1).getName() + "[ID=" + userList.retrieveUserByIndex(1).getIdentifier() + "] balance is " + userList.retrieveUserByIndex(1).getBalance());
        
        makeTransaction(userList.retrieveUserByIndex(0), userList.retrieveUserByIndex(1), 500);
        makeTransaction(userList.retrieveUserByIndex(0), userList.retrieveUserByIndex(1), 2500);
        makeTransaction(userList.retrieveUserByIndex(0), userList.retrieveUserByIndex(1), 3500);
        makeTransaction(userList.retrieveUserByIndex(1), userList.retrieveUserByIndex(0), 17000);
        makeTransaction(userList.retrieveUserByIndex(0), userList.retrieveUserByIndex(1), 1000);
        
        Transaction[] arr =  userList.retrieveUserById(0).getTransactionsList().toArray();
        
        for (Transaction elem : arr)
            elem.getForm();
        System.out.println(userList.retrieveUserByIndex(0).getName() + "[ID=" + userList.retrieveUserByIndex(0).getIdentifier() + "] balance is " + userList.retrieveUserByIndex(0).getBalance());
        System.out.println(userList.retrieveUserByIndex(1).getName() + "[ID=" + userList.retrieveUserByIndex(1).getIdentifier() + "] balance is " + userList.retrieveUserByIndex(1).getBalance());
    }

    private static void makeTransaction(User sender, User recipient, int amount) {
        if (sender.getBalance() - amount < 0)
            System.out.println("Not enough balance");
        else {
            UUID nw = new UUID(uid1, uid2);
            uid1 += 2000; uid2 += 22000;
            Transaction trSender = new Transaction(nw, recipient, sender, -amount);
            Transaction trRecipient = new Transaction(nw, recipient, sender, amount);
            sender.getTransactionsList().addTransaction(trSender);
            recipient.getTransactionsList().addTransaction(trRecipient);
        }
    }
}