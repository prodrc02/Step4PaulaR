package es.unileon.InteresesOrdinarios.service;

import es.unileon.InteresesOrdinarios.domain.Account;

/**
 * @author Paula
 *
 */
public class SimpleAccountManager implements AccountManager {

	private static final long serialVersionUID = 1L;

	private Account account;
	
	
	/**
	 * Method with the formula of ordinary interest: Average balance * interest/100 * days between the two dates/365 = amount to increase
	 * After applying the formula is calculated the new balance of the account= amount to increase + balance of the last movement
	 * 
	 * @param percentage
	 */
	public void applyInterest(int percentage) {
		if (account != null) {
						
				double amountToIncrease = account.getBalanceAverage()
						 * percentage / 100 * account.daysBetweenTwoDates() / 365;

				double newBalance = amountToIncrease
						+ account.getMovementBalance5();

				account.setAmountToIncrease(amountToIncrease);
				account.setMovementWithIncrease(newBalance);
		}
	}

	/**
	 * 
	 * @return account
	 */
	public Account getAccount() {

		return account;
	}

	/**
	 * 
	 * @param account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
}