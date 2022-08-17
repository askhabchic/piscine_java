package day01.ex02;

import java.util.UUID;

enum Category {
    DEBITS,
    CREDITS;
}

public class Transaction {

    private UUID Identifier;
    private User Recipient;
    private User Sender;
    private Category TransferCategory;
    private Integer TransferAmount;

    public Transaction(UUID Id, User Recip, User Sndr, Integer Amount) {
        this.Identifier = Id;
        this.Recipient = Recip;
        this.Sender = Sndr;
        this.TransferAmount = Amount;
        if (Amount < 0) {
            setCategory(Category.CREDITS);
            this.Sender.setBalance(this.Sender.getBalance() + Amount);
        } else {
            setCategory(Category.DEBITS);
            this.Recipient.setBalance(this.Recipient.getBalance() + Amount);
        }
    }
    
    public UUID getIdentifier() { 
        return this.Identifier; 
    }

    public User getRecipient() {
        return this.Recipient;
    }

    public User getSender() {
        return this.Sender;
    }

    public Category getCategory() {
        return this.TransferCategory;
    }

    public Integer getAmount() {
        return this.TransferAmount;
    }

    public void setAmount(Integer Amount) {
        this.TransferAmount = Amount;
    }

    public void setCategory(Category cat) {
        this.TransferCategory = cat;
    }
}