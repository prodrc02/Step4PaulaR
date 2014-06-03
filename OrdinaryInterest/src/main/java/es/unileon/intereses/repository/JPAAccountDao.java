package es.unileon.intereses.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.intereses.domain.Account;


/**
 * @author Paula
 *
 */

@Repository(value = "accountDao")
public class JPAAccountDao implements AccountDao {
	private EntityManager em = null;

	
	/**
	 * Sets the entity manager.
	 * @param em
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
	       this.em = em;
	}
	 
	
	
	/**
	 * @return
	 */
	@Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public Account getAccountDao() {
		List<Account> accounts = em.createQuery("select acc from Account acc order by acc.id").getResultList();
        return accounts.get(2);
	}

	/**
	 * @param account
	 */
	@Transactional(readOnly = false)
	public void saveAccount(Account acc) {
		em.merge(acc);

	}

}
