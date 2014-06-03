package es.unileon.intereses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.unileon.intereses.domain.Account;
import es.unileon.intereses.repository.AccountDao;

/**
 * @author Paula
 *
 */
@Component
public class SimpleAccountManager implements AccountManager {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AccountDao accountDao;
	
	
	/**
	 * Method with the formula of ordinary interest: Average balance * interest/100 * days between the two dates/365 = amount to increase
	 * After applying the formula is calculated the new balance of the account= amount to increase + balance of the last movement
	 * 
	 * @param percentage
	 */
	public void applyInterest(int percentage) {
		Account account = accountDao.getAccountDao();
		if (account != null) {
						
				double amountToIncrease = account.getBalanceAverage()
						 * percentage / 100 * account.daysBetweenTwoDates() / 365;

				double newBalance = amountToIncrease
						+ account.getMovementBalance5();

				account.setAmountToIncrease(amountToIncrease);
				account.setMovementWithIncrease(newBalance);
				accountDao.saveAccount(account);
		}
	}

	/**
	 * 
	 * @return account.getAccount()
	 */
	public Account getAccount() {

		return accountDao.getAccountDao();
	}

	/**
	 * 
	 * @param account
	 */
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
}