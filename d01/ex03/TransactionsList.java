package day01.ex03;

import java.util.UUID;

interface TransactionsList {

  class List {
    Transaction data;
    List next;   
  }

  public void addTransaction(Transaction trans);
  public void removeTransaction(UUID Id);
  public Transaction[] toArray();
}