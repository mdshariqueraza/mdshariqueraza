package com.sharique.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sharique.Repo.AccountRepo;
import com.sharique.bean.Account;
import com.sharique.exception.InsufficientBalanceException;
import com.sharique.exception.InvalidAccountException;
import com.sharique.service.AccountService;
import com.sharique.service.AccountServiceImpl;

public class AccoutForWithDrwalTest {
	AccountService accountService;
	@Mock
	AccountRepo accrepo;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		accountService =new AccountServiceImpl(accrepo);
	
	 }

	@Test(expected=com.sharique.exception.InvalidAccountException.class)
	public void whenAccountNumberisnotThereForWithdrwal() throws InvalidAccountException, InsufficientBalanceException
	{
		accountService.withDrawlAmount(122,1000);
	}
	
	@Test(expected=com.sharique.exception.InsufficientBalanceException.class)
	public void whenAmountIsGreaterThanDepositAmountisnotThereForWithdrwal() throws  InvalidAccountException,InsufficientBalanceException
	{
		Account account =new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		when(accrepo.searchAccount(101)).thenReturn(account);
		accountService.withDrawlAmount(101,1000);
	}
	
	@Test(expected=com.sharique.exception.InsufficientBalanceException.class)
	public void whenAmountIsLesserThanDepositAmountisnotThereForWithdrwal() throws  InvalidAccountException,InsufficientBalanceException
	{
		Account account =new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		when(accrepo.searchAccount(101)).thenReturn(account);
		assertEquals(account,accountService.withDrawlAmount(101,1000));
	}
}
