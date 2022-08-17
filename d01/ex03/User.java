package day01.ex03;

public class User {

    private int Identifier;
    private String Name;
    private int Balance;
    TransactionsLinkedList list;

    public User(String name, int balance) {
        this.Name = name;
        this.Identifier = UserIdsGenerator.getInstance().generateId();
        list = new TransactionsLinkedList();
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

    public TransactionsLinkedList getTransactionsList() {
        return list;
    }
    
    public void setBalance(int newBal) { 
        if (newBal < 0)
            Balance = 0;
        else Balance = newBal; 
    }

}