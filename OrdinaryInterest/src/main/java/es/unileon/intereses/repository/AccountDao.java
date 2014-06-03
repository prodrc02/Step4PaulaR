package es.unileon.intereses.repository;

import es.unileon.intereses.domain.Account;

/**
 * @author Paula
 *
 */

public interface AccountDao {
	
	public Account getAccountDao();
	
	/**
	 * @param acc
	 */
	public void saveAccount(Account account);

}
