package com.sharique.Repo;

import com.sharique.bean.Account;

public interface AccountRepo {
	boolean save(Account account);
	Account searchAccount(int accountnumber);
}
