package es.unileon.InteresesOrdinarios.domain;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import es.unileon.InteresesOrdinarios.domain.Account;

/**
 * @author Paula
 *
 */
public class AccountTests {

	private Account account;
	private static String ACCOUNT_DESCRIPTION = "1234-2096-33-9517408632 Titular: Paula";
	private static Double FINAL_BALANCE_MOV1 = new Double(15200.80);
	private static Double FINAL_BALANCE_MOV2 = new Double(18895.23);
	private static Double FINAL_BALANCE_MOV3 = new Double(1600.20);
	private static Double FINAL_BALANCE_MOV4 = new Double(2356.65);
	private static Double FINAL_BALANCE_MOV5 = new Double(30000.00);
	private static Double BALANCE_WITH_INTEREST = new Double(30085.77);
	private static Double AMOUNT_TO_INCREASE = new Double(88.77);
	private static Date DATE_MOV1 = new GregorianCalendar(2014, 4, 24)
			.getTime();
	private static Date DATE_MOV5 = new GregorianCalendar(2014, 5, 16)
			.getTime();

	@Before
	public void setUp() throws Exception {
		account = new Account();
		account.setAccountDescription(ACCOUNT_DESCRIPTION);
		account.setMovementBalance1(FINAL_BALANCE_MOV1);
		account.setMovementBalance2(FINAL_BALANCE_MOV2);
		account.setMovementBalance3(FINAL_BALANCE_MOV3);
		account.setMovementBalance4(FINAL_BALANCE_MOV4);
		account.setMovementBalance5(FINAL_BALANCE_MOV5);
		account.setDateMov1(DATE_MOV1);
		account.setDateMov5(DATE_MOV5);

	}

	@Test
	public void testSetAndGetDescription() {
		account.setAccountDescription(ACCOUNT_DESCRIPTION);
		assertEquals(ACCOUNT_DESCRIPTION, account.getAccountDescription());
	}

	@Test
	public void testSetAndGetMovementBalance1() {
		assertEquals(0, 0, 0);
		account.setMovementBalance1(FINAL_BALANCE_MOV1);
		assertEquals(FINAL_BALANCE_MOV1, account.getMovementBalance1(), 0);
	}

	@Test
	public void testSetAndGetMovementBalance2() {
		assertEquals(0, 0, 0);
		account.setMovementBalance2(FINAL_BALANCE_MOV2);
		assertEquals(FINAL_BALANCE_MOV2, account.getMovementBalance2(), 0);
	}

	@Test
	public void testSetAndGetMovementBalance3() {
		assertEquals(0, 0, 0);
		account.setMovementBalance3(FINAL_BALANCE_MOV3);
		assertEquals(FINAL_BALANCE_MOV3, account.getMovementBalance3(), 0);
	}

	@Test
	public void testSetAndGetMovementBalance4() {
		assertEquals(0, 0, 0);
		account.setMovementBalance4(FINAL_BALANCE_MOV4);
		assertEquals(FINAL_BALANCE_MOV4, account.getMovementBalance4(), 0);
	}

	@Test
	public void testSetAndGetMovementBalance5() {
		assertEquals(0, 0, 0);
		account.setMovementBalance5(FINAL_BALANCE_MOV5);
		assertEquals(FINAL_BALANCE_MOV5, account.getMovementBalance5(), 0);
	}

	@Test
	public void testSetAndGetMovementBalanceWithIncrease() {
		assertEquals(0, 0, 0);
		account.setMovementWithIncrease(BALANCE_WITH_INTEREST);
		assertEquals(BALANCE_WITH_INTEREST, account.getMovementWithIncrease(),
				0);
	}

	@Test
	public void testSetAndGetAmountToIncrease() {
		assertEquals(0, 0, 0);
		account.setAmountToIncrease(AMOUNT_TO_INCREASE);
		assertEquals(AMOUNT_TO_INCREASE, account.getAmountToIncrease(), 0);
	}

	@Test
	public void testRound() {
		double testNumber = 125.356;
		int decimals = 2;
		double roundNumber = 125.36;
		assertEquals(roundNumber, account.round(testNumber, decimals), 0);

	}

	@Test
	public void testBalanceAverage() {
		double average = 13610.58;
		assertEquals(average, account.getBalanceAverage(), 0);

	}

	@Test
	public void testDaysBetweenTwoDates() {
		int daysBetweenDates = 23;
		assertEquals(daysBetweenDates, account.daysBetweenTwoDates(),0);
	}

}
