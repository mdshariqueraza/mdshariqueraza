package com.sharique.service;

import com.sharique.Repo.AccountRepo;
import com.sharique.bean.Account;
import com.sharique.exception.InsufficientBalanceException;
import com.sharique.exception.InsufficientOpeningException;
import com.sharique.exception.InvalidAccountException;

public interface AccountService {
	
Account createAccount(int accountnumber,int amount) throws InsufficientOpeningException;
Account depositAmount(int accountnumber,int amount) throws InvalidAccountException;
Account withDrawlAmount(int accountnumber,int amount) throws InsufficientBalanceException,InvalidAccountException;
}
