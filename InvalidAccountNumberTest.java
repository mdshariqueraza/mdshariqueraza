package com.sharique.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sharique.Repo.AccountRepo;
import com.sharique.bean.Account;
import com.sharique.exception.InsufficientOpeningException;
import com.sharique.exception.InvalidAccountException;
import com.sharique.service.AccountService;
import com.sharique.service.AccountServiceImpl;

public class InvalidAccountNumberTest{

AccountService accountService;

	@Mock
	AccountRepo accrepo;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		accountService =new AccountServiceImpl(accrepo);
	
	 }

	@Test(expected=com.sharique.exception.InvalidAccountException.class)
	public void whenAccountNumberisnotThereForDeposit() throws InvalidAccountException
	{
		accountService.depositAmount(122,1000);
	}

	@Test
	public void whenAccountNumberisthereForDeposit() throws InvalidAccountException
	{
		Account account =new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		when(accrepo.searchAccount(101)).thenReturn(account);
		assertEquals(account,accountService.depositAmount(101,9000));
	
	}
	
}
