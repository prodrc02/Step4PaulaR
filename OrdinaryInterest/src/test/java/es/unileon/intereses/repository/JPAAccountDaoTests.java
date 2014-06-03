package es.unileon.intereses.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.intereses.domain.Account;
import es.unileon.intereses.repository.AccountDao;

public class JPAAccountDaoTests {
	
	private ApplicationContext context;
    private AccountDao accountDao;

    
    @Before
    public void setUp() throws Exception {
    	context = new ClassPathXmlApplicationContext(
				"classpath:test-context.xml");
        accountDao = (AccountDao) context.getBean("accountDao");
    }
    
    
    
	@Test
	public void testGetAccount() {
		Account account = accountDao.getAccountDao();
		assertNotNull(account);
		
	}

	@Test
	public void testSaveAccount(){
		Account acc1 = accountDao.getAccountDao();
		
		Double movementBalance1 = acc1.getMovementBalance1();
		acc1.setMovementBalance1(15200.80);
		Double movementBalance2 =acc1.getMovementBalance2();
		acc1.setMovementBalance2(18895.23);
		Double movementBalance3 = acc1.getMovementBalance3();
		acc1.setMovementBalance3(1600.20);
		Double movementBalance4 = acc1.getMovementBalance4();
		acc1.setMovementBalance4(2356.65);
		Double movementBalance5 = acc1.getMovementBalance5();
		acc1.setMovementBalance5(30000.00);
		Double balanceWithInterest = acc1.getMovementWithIncrease();
		acc1.setMovementWithIncrease(30088.77);
		Double amountToIncrease =acc1.getAmountToIncrease();
		acc1.setAmountToIncrease(88.77);
	
		accountDao.saveAccount(acc1);
		
		Account acc2 = accountDao.getAccountDao();
		
		assertEquals(acc2.getMovementBalance1(), 15200.80, 0);
		assertEquals(acc2.getMovementBalance2(), 18895.23, 0);
		assertEquals(acc2.getMovementBalance3(), 1600.20, 0);
		assertEquals(acc2.getMovementBalance4(), 2356.65, 0);
		assertEquals(acc2.getMovementBalance5(), 30000.00, 0);
		assertEquals(acc2.getMovementWithIncrease(), 30088.77, 0);
		assertEquals(acc2.getAmountToIncrease(), 88.77, 0);
	acc2.setMovementBalance1(movementBalance1);
		acc2.setMovementBalance2(movementBalance2);
		acc2.setMovementBalance3(movementBalance3);
		acc2.setMovementBalance4(movementBalance4);
		acc2.setMovementBalance5(movementBalance5);
		acc2.setMovementWithIncrease(balanceWithInterest);
		acc2.setAmountToIncrease(amountToIncrease);
		
		
		
		accountDao.saveAccount(acc2);

		
		
		
	}
	
	
	
}
