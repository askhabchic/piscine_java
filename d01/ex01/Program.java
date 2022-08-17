package day01.ex01;

public class Program {

    public static void main(String[] args) {
        User John = new User("John", 1000);
        User Mike = new User("Mike", 1200);
        User Jo = new User("Jo", 900);

        System.out.println(John.getName() + ", ID - " + John.getIdentifier() + ", Balance - " + John.getBalance());
        System.out.println(Mike.getName() + ", ID - " + Mike.getIdentifier() + ", Balance - " + Mike.getBalance());
        System.out.println(Jo.getName() + ", ID - " + Jo.getIdentifier() + ", Balance - " + Jo.getBalance());
    }
}