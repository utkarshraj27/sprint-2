package org.cap.pecunia.service;

import org.cap.pecunia.entities.Account;
import org.cap.pecunia.entities.Cheque;
import org.cap.pecunia.entities.Transaction;

public interface TransactionService {
	
	double getBalance(Account account);
	
	Account getAccountById(String accountNumber);
	
	boolean updateBalance(Account account);
	
	int creditUsingSlip(Transaction transaction);
	
	int debitUsingSlip(Transaction transaction);
	
	int creditUsingCheque(Transaction transaction,Cheque cheque);
	
	int debitUsingCheque(Transaction transaction,Cheque cheque);
	
	

}
