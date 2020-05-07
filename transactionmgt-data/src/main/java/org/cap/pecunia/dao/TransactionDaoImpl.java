package org.cap.pecunia.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.cap.pecunia.entities.Account;
import org.cap.pecunia.entities.Cheque;
import org.cap.pecunia.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class TransactionDaoImpl implements TransactionDao {
	
	@Autowired
	private EntityManagerFactory emf;
	
	 public void saveAccountDetails() {
		 
		 
		 Account acc1 = new Account();
		    acc1.setAccountNumber("123456789098");
		    acc1.setAccountBalance(1009890);
		    acc1.setAccountHolderName("Utkarsh");
		    acc1.setAccountType("Saving");
		    acc1.setBankName("Punjab National bank");
		    Account acc2 = new Account();
		    acc2.setAccountNumber("123456789097");
		    acc2.setAccountBalance(40000);
		    acc2.setAccountHolderName("Vishal");
		    acc2.setAccountType("Current");
		    acc2.setBankName("State Bank Of India");
		    Account acc3 = new Account();
		    acc3.setAccountNumber("123456789096");
		    acc3.setAccountBalance(9000);
		    acc3.setAccountHolderName("Yashweer");
		    acc3.setAccountType("Saving");
		    acc3.setBankName("United bank Of India");
		    EntityManager em = emf.createEntityManager();
		   
		    em.persist(acc1);
		    em.persist(acc2);
		    em.persist(acc3);
		   
		    em.close();
	 }
		    
	
	@Override
	public Account getAccountById(String accountNumber) {
		saveAccountDetails();
		EntityManager em = emf.createEntityManager();
		Account accountEntity = em.find(Account.class, accountNumber);
		
		em.close();
		return accountEntity;
	}

	@Override
	public double getBalance(Account account) {
		double balance = account.getAccountBalance();
		System.out.println(balance);
		return balance;
	}

	@Override
	public Boolean updateBalance(Account account) {
		EntityManager em = emf.createEntityManager();
		em.merge(account);
		return true;
	}

	@Override
	public int generateChequeId(Cheque cheque) {
		int generatedId=445566;
		generatedId++;
		cheque.setChequeId(Integer.toString(generatedId));
		return generatedId;
	}

	@Override
	public int getTransactionId(Transaction transaction) {
	 int generatedId = 112233;
	 generatedId++;
	 
	 return generatedId;
		
	}
}
