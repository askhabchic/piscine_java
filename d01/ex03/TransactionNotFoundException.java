package day01.ex03;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(String mess) {
        super(mess);
    }
}
