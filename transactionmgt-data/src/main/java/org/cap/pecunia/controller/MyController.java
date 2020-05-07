package org.cap.pecunia.controller;


import org.cap.pecunia.dto.SlipRequestDto;
import org.cap.pecunia.dto.TransactionSlipDto;
import org.cap.pecunia.entities.Account;
import org.cap.pecunia.entities.Transaction;
import org.cap.pecunia.exceptions.InSufficientBalanceException;
import org.cap.pecunia.service.TransactionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transaction")
public class MyController {
	
	private static final Logger Log = LoggerFactory.getLogger(MyController.class);
	
	@Autowired
	private TransactionService service;
	
	 @GetMapping("/CreditUsingSlip")
	    public ResponseEntity<TransactionSlipDto>creditUsingSlip(@RequestBody SlipRequestDto requestDto){
		   Transaction transaction = convertToTransaction(requestDto);
	       int transactionid = service.creditUsingSlip(transaction);
	       transaction.setTransactionId(transactionid);
	       transaction.setTransDate(java.time.LocalDate.now());
	      
	       TransactionSlipDto responseDto = convertFromTransaction(transaction);
	       
	       
		   
		   
	        ResponseEntity<TransactionSlipDto>response=new ResponseEntity<>(responseDto, HttpStatus.OK);
	        return response;
	   }
	 
	 
	 Transaction convertToTransaction(SlipRequestDto requestDto)
	 {
		 Transaction trans = new Transaction();
		 trans.setTransAccountId(requestDto.getTransAccountId());
		 trans.setTransTo(requestDto.getTransTo());
		 trans.setTransAmount(requestDto.getTransAmount());
		 trans.setTransType(requestDto.getTransType());
		 return trans;
	 }
	 TransactionSlipDto convertFromTransaction(Transaction transaction)
	 {
		 TransactionSlipDto dto = new TransactionSlipDto();
		 dto.setTransactionId(transaction.getTransactionId());
		 dto.setTransType(transaction.getTransType());
		 dto.setTransAmount(transaction.getTransAmount());
		 dto.setTransDate(transaction.getTransDate());
		 dto.setTransAccountId(transaction.getTransAccountId());
		 dto.setTransTo(transaction.getTransTo());
		 return dto;
	 }
	 
	 @GetMapping("/find/{id}")
	    public ResponseEntity<Account>findAccountDetails(@PathVariable("id") String accountNumber){
		   
		 Account myaccount=service.getAccountById(accountNumber);
	        ResponseEntity<Account>response=new ResponseEntity<>(myaccount, HttpStatus.OK);
	        return response;
	   }
	 
	 @ExceptionHandler(InSufficientBalanceException.class)
	   public ResponseEntity<String> handleBalanceNotFound(InSufficientBalanceException ex) {
	       Log.error("Low Balance", ex);
	       String msg = ex.getMessage();
	       ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
	       return response;
	   }

	  

}
