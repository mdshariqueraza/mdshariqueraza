package com.sharique.service;

import java.util.ArrayList;

import com.sharique.Repo.AccountRepo;
import com.sharique.bean.Account;
import com.sharique.exception.InsufficientBalanceException;
import com.sharique.exception.InsufficientOpeningException;
import com.sharique.exception.InvalidAccountException;

public class AccountServiceImpl implements AccountService {
	AccountRepo accrepo;
	public AccountServiceImpl(AccountRepo accrepo) {
		super();
		this.accrepo = accrepo;
	}
	
	public Account createAccount(int accountnumber,int amount) throws InsufficientOpeningException{
		if(amount<500)
		{
			throw new InsufficientOpeningException();
		}
		Account acc=new Account();
		acc.setAccountNumber(accountnumber);
		acc.setAmount(amount);
		if(accrepo.save(acc))
		{
		return acc;	
		}
		return null;
	}

	@Override
	public Account depositAmount(int accountnumber,int amount)
			throws InvalidAccountException {
		Account acc = accrepo.searchAccount(accountnumber);
		System.out.println(acc);
		if(acc==null)
		{
			throw new  InvalidAccountException();
			
		}
		acc.setAccountNumber(accountnumber);
		acc.setAmount(amount+acc.getAmount());
		return acc;
	}

	@Override
	public Account withDrawlAmount(int accountnumber, int amount)
			throws InsufficientBalanceException, InvalidAccountException {
		int depositAmount=5000;
		Account acc = accrepo.searchAccount(accountnumber);
		System.out.println(acc);
		if(acc==null)
		{
			throw new  InvalidAccountException();
			
		}
		if(amount<depositAmount){
			throw new InsufficientBalanceException();
		}
		if(amount>depositAmount){
			depositAmount=depositAmount-amount;
		}
		return null;
	}
}
