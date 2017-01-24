package com.datastax.banking.service;

import java.util.List;

import com.datastax.banking.dao.BankDao;
import com.datastax.banking.model.Account;
import com.datastax.banking.model.Customer;
import com.datastax.banking.model.Transaction;
import com.datastax.demo.utils.PropertyHelper;

public class BankService {

	private String contactPointsStr = PropertyHelper.getProperty("contactPoints", "localhost");
	private BankDao dao;
	
	public BankService(){
		this.dao = new BankDao(contactPointsStr.split(","));
	}
	
	
	public Customer getCustomer(String customerId){
		
		return dao.getCustomer(customerId);
	}
	
	public List<Account> getAccounts(String customerId){
		
		return dao.getCustomerAccounts(customerId);
	}

	public List<Transaction> getTransactions(String accountId) {
		
		return dao.getTransactions(accountId);
	}
}
