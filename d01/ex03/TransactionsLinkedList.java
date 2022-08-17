package day01.ex03;

import java.util.UUID;

class TransactionsLinkedList implements TransactionsList {
  
  List head = null;
  List last;
  int listIndex = 0;

  public void addTransaction(Transaction trans) {
	List lst = new List();
	lst.data = trans;
	lst.next = null;
	listIndex++;
	if (head == null) {
		head = lst;
		last = lst;
	} else {
		last.next = lst;
		last = lst;
	}
  }

  public void removeTransaction(UUID Id){
	List tmp = head;
	while (tmp != null && tmp.next != null) {
		if (tmp.next.data.getIdentifier().equals(Id)) {
			tmp.next = tmp.next.next;
			listIndex--;
			return ;
		}
		tmp = tmp.next;
	}
	throw new TransactionNotFoundException("Transaction witth ID = " + Id + " not found");
  }

  public Transaction[] toArray() {
	Transaction[] transArr = new Transaction[listIndex];
	List tmp = head;
	for (int i = 0; i < listIndex; i++) {
		transArr[i] = tmp.data;
		tmp = tmp.next;
	}
	return transArr;
  }
}