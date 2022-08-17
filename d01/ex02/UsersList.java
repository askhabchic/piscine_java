package day01.ex02;

public interface UsersList {

    public void addUser(User user);
    public User retrieveUserById(Integer Id);
    public User retrieveUserByIndex(Integer Index);
    public int retrieveNumberOfUsers();

}