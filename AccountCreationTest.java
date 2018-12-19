package com.sharique.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import com.sharique.Repo.AccountRepo;
import com.sharique.bean.Account;
import com.sharique.exception.InsufficientOpeningException;
import com.sharique.service.AccountService;
import com.sharique.service.AccountServiceImpl;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class AccountCreationTest {
   AccountService accountService;
	
	@Mock
	AccountRepo accrepo;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		accountService =new AccountServiceImpl(accrepo);
	}

	@Test(expected=com.sharique.exception.InsufficientOpeningException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException() throws InsufficientOpeningException
	{
		accountService.createAccount(101, 400);
	}
	
	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreatedSuccessfully() throws InsufficientOpeningException
	{
		Account account =new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		when(accrepo.save(account)).thenReturn(true);
		assertEquals(account, accountService.createAccount(101, 5000));
	}

}
