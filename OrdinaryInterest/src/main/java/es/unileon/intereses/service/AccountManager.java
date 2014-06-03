package es.unileon.intereses.service;

import java.io.Serializable;





import es.unileon.intereses.domain.Account;


/**
 * @author Paula
 *
 */

public interface AccountManager extends Serializable {

	public void applyInterest(int percentage);
	
	public Account getAccount();

}
