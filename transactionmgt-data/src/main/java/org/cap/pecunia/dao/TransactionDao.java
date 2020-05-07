package org.cap.pecunia.dao;

import org.cap.pecunia.entities.Account;
import org.cap.pecunia.entities.Cheque;
import org.cap.pecunia.entities.Transaction;

public interface TransactionDao {
	
	Account getAccountById(String accountNumber);
	
	double getBalance(Account account);
	
	Boolean updateBalance(Account account);
	
	int generateChequeId(Cheque cheque);
	
	int getTransactionId(Transaction transaction);
	
	void saveAccountDetails();

}
