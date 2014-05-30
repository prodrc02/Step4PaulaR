package es.unileon.springapp.service;

import java.io.Serializable;



import es.unileon.springapp.domain.Account;


/**
 * @author Paula
 *
 */

public interface AccountManager extends Serializable {

	public void applyInterest(int percentage);
	
	public Account getAccount();

}
