package es.unileon.intereses.repository;

import es.unileon.intereses.domain.Account;

public class InMemoryAccountDao implements AccountDao{

	private Account account;

	public InMemoryAccountDao(Account account) {
		this.account = account;
	}

	public Account getAccountDao() {
		return account;
	}

	public void saveAccount(Account acc) {

	}


	
	
}
