package es.unileon.intereses.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import es.unileon.intereses.domain.Account;
import es.unileon.intereses.repository.AccountDao;
import es.unileon.intereses.repository.InMemoryAccountDao;
import es.unileon.intereses.service.SimpleAccountManager;

/**
 * @author Paula
 *
 */
public class SimpleAccountManagerTests {

	private SimpleAccountManager accountManager;

	private Account account;
	

	private static String ACCOUNT_DESCRIPTION = "1234-2096-33-9517408632 Titular: Paula";
	private static Double FINAL_BALANCE_MOV1 = new Double(15200.80);	
	private static Double FINAL_BALANCE_MOV2 = new Double(18895.23);
	private static Double FINAL_BALANCE_MOV3 = new Double(1600.20);
	private static Double FINAL_BALANCE_MOV4 = new Double(2356.65);
	private static Double FINAL_BALANCE_MOV5 = new Double(30000.00);
	private static Double BALANCE_WITH_INTEREST = new Double(30085.77);
	private static Date DATE_MOV1 = new GregorianCalendar(2014,4,24).getTime();
	private static Date DATE_MOV5 = new GregorianCalendar(2014,5,16).getTime();
	
	
	
	private static int INTEREST = 10;

	@Before
	public void setUp() throws Exception {
		accountManager = new SimpleAccountManager();
		account = new Account();
		account.setAccountDescription(ACCOUNT_DESCRIPTION);
		account.setMovementBalance1(FINAL_BALANCE_MOV1);
		account.setMovementBalance2(FINAL_BALANCE_MOV2);
		account.setMovementBalance3(FINAL_BALANCE_MOV3);
		account.setMovementBalance4(FINAL_BALANCE_MOV4);
		account.setMovementBalance5(FINAL_BALANCE_MOV5);
		account.setDateMov1(DATE_MOV1);
		account.setDateMov5(DATE_MOV5);
		
		
		
		AccountDao accountDao = new InMemoryAccountDao(account);
		accountManager.setAccountDao(accountDao);
		//accountManager.setAccount(account);

	}

	@Test
	public void testGetEmptyAccount(){
		accountManager = new SimpleAccountManager();
		accountManager.setAccountDao(new InMemoryAccountDao(null));
		assertNull(accountManager.getAccount());
	}
	
	
	@Test
	public void testGetAccount() {
		account = accountManager.getAccount();
		assertNotNull(account);
		assertEquals(ACCOUNT_DESCRIPTION, account.getAccountDescription());
		assertEquals(FINAL_BALANCE_MOV1,account.getMovementBalance1());
		assertEquals(FINAL_BALANCE_MOV2,account.getMovementBalance2());
		assertEquals(FINAL_BALANCE_MOV3,account.getMovementBalance3());
		assertEquals(FINAL_BALANCE_MOV4,account.getMovementBalance4());
		assertEquals(FINAL_BALANCE_MOV5,account.getMovementBalance5());
		assertEquals(DATE_MOV1, account.getDateMov1());
		assertEquals(DATE_MOV5, account.getDateMov5());
		
	}

	@Test
	public void testApplyInterestWithNullAccount() {
		try {
			accountManager = new SimpleAccountManager();
			accountManager.setAccountDao(new InMemoryAccountDao(null));
			accountManager.applyInterest(INTEREST);
		
		} catch (NullPointerException ex) {
			fail("Account is null.");
		}
	}

	@Test
	public void testApplyInterestWithEmptyAccount() {
		try {
			accountManager = new SimpleAccountManager();
			//accountManager.setAccount(new Account());
			accountManager.setAccountDao(new InMemoryAccountDao(new Account()));
		} catch (Exception ex) {
			fail("Account is empty.");
		}
	}
	
	
	@Test
	public void testApplyInterest() {
		account = accountManager.getAccount();
		accountManager.applyInterest(INTEREST);
		assertEquals(BALANCE_WITH_INTEREST, account.getMovementWithIncrease(),0);
	
	}
}