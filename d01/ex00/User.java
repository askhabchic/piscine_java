package day01.ex00;

public class User {

    private int Identifier;
    private String Name;
    private int Balance;

    public User(String name, int Id, int balance) {
        this.Name = name;
        this.Identifier = Id;
        if (balance < 0)
            setBalance(0);
        else
            setBalance(balance);
    }

    public int getIdentifier() { 
        return Identifier; 
    }

    public String getName() { 
        return Name; 
    }

    public int getBalance() { 
        return Balance; 
    }

    public void setBalance(int newBal) { 
        if (newBal < 0)
            Balance = 0;
        else Balance = newBal; 
    }

}