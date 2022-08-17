package day01.ex02;

public class UserIdsGenerator {

    private static UserIdsGenerator instance;
    private static int id = 0;

    private UserIdsGenerator() {}

    public int generateId() {
        return id++;
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }
}