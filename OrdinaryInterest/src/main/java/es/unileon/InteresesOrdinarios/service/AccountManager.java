package es.unileon.InteresesOrdinarios.service;

import java.io.Serializable;


import es.unileon.InteresesOrdinarios.domain.Account;


/**
 * @author Paula
 *
 */

public interface AccountManager extends Serializable {

	public void applyInterest(int percentage);
	
	public Account getAccount();

}
