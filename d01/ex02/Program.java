package day01.ex02;

public class Program {

    public static void main(String[] args) {

        UsersArrayList list = new UsersArrayList();

        User John = new User("John", 1000);
        User Mike = new User("Mike", 1200);
        User Jo = new User("Jo", 900);

        list.addUser(John);
        list.addUser(Mike);
        list.addUser(Jo);

        System.out.println(list.retrieveNumberOfUsers());

        System.out.println(list.retrieveUserByIndex(0).getName() + ", ID - " + list.retrieveUserById(John.getIdentifier()).getIdentifier() + ", Balance - " + list.retrieveUserByIndex(0).getBalance());
        System.out.println(list.retrieveUserByIndex(1).getName() + ", ID - " + list.retrieveUserById(Mike.getIdentifier()).getIdentifier() + ", Balance - " + list.retrieveUserByIndex(1).getBalance());
        System.out.println(list.retrieveUserByIndex(2).getName() + ", ID - " + list.retrieveUserById(Jo.getIdentifier()).getIdentifier() + ", Balance - " + list.retrieveUserByIndex(2).getBalance());

        System.out.println(list.retrieveUserById(Jo.getIdentifier()));

        System.out.println(list.retrieveUserByIndex(5).getName());
    }
}