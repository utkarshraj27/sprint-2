package org.cap.pecunia.service;

import java.util.Date;

import org.cap.pecunia.dao.TransactionDao;
import org.cap.pecunia.entities.Account;
import org.cap.pecunia.entities.Cheque;
import org.cap.pecunia.entities.Transaction;
import org.cap.pecunia.exceptions.InSufficientBalanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

	private TransactionDao dao;

	public TransactionDao getDao() {
		return dao;
	}
	@Autowired
	public void setDao(TransactionDao dao) {
		this.dao = dao;
	}
	

	@Override
	public Account getAccountById(String accountNumber) {
		
		Account account = dao.getAccountById(accountNumber);
		return account;
		
	}
	@Override
	public double getBalance(Account account) {
		double balance = dao.getBalance(account);
		return balance;
	}
	@Override
	public boolean updateBalance(Account account) {
		boolean result = dao.updateBalance(account);
		return result;
	}
	@Override
	public int creditUsingSlip(Transaction transaction) {
		String acc1= transaction.getTransAccountId();
		Account firstacc = getAccountById(acc1);
		System.out.println(firstacc);
		double firstbalance = getBalance(firstacc);
		double transamt = transaction.getTransAmount();
		if(transamt>firstbalance)
		{
			throw new InSufficientBalanceException("Low Balance");
		}
		String acc2 = transaction.getTransTo();
		Account secondacc = getAccountById(acc2);
		double secondbalance = getBalance(secondacc);
		double updatedbalance = secondbalance+transamt;
		firstacc.setAccountBalance(firstbalance-transamt);
		secondacc.setAccountBalance(updatedbalance);
		
		
		int transactionid = dao.getTransactionId(transaction);
		return transactionid;
		
		
		
	}
	@Override
	public int debitUsingSlip(Transaction transaction) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int creditUsingCheque(Transaction transaction, Cheque cheque) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int debitUsingCheque(Transaction transaction, Cheque cheque) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
