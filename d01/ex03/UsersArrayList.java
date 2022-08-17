package day01.ex03;

public class UsersArrayList implements UsersList {

    private int usersIndex = 0;
    private int usersCount = 10;

    private User[] users = new User[usersCount];

    public void addUser(User user) {
        if (user != null)
            users[usersIndex] = user;
        usersIndex++;
        if (usersCount == usersIndex)
            users = reallocNewArray();
    }

    private User[] reallocNewArray() {
        usersCount *= 2;
        User[] newArr = new User[usersCount];
        for (int i = 0; i < usersIndex; i++) {
            newArr[i] = users[i];
        }
        return newArr;
    }

    public User retrieveUserById(Integer Id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getIdentifier() == Id)
                return users[i];
        }
        throw new UserNotFoundException("User with ID [" + Id + "] is not found");
    }
    
    public User retrieveUserByIndex(Integer Index) {
        if (Index > usersIndex || Index < 0)
            throw new UserNotFoundException("User with index [" + Index + "] is not found");
        return users[Index];
    }

    public int retrieveNumberOfUsers() {
        return usersIndex;
    }

}