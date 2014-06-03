package es.unileon.intereses.web;

import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.intereses.domain.Account;
import es.unileon.intereses.repository.InMemoryAccountDao;
import es.unileon.intereses.service.SimpleAccountManager;
import es.unileon.intereses.web.BeforeInterestController;

/**
 * @author Paula
 *
 */



public class BeforeInterestControllerTests {
	/**
	 * Test taken of the 'springapp' example adapted to the application
	 * 
	 * @throws Exception
	 */
	@Test
	public void testHandleRequestView() throws Exception {
		BeforeInterestController controller = new BeforeInterestController();
		SimpleAccountManager  spm = new SimpleAccountManager();
		spm.setAccountDao(new InMemoryAccountDao(new Account()));
		controller.setAccountManager(spm);
		//controller.setAccountManager(new SimpleAccountManager());
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("movementsBeforeInterest", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		@SuppressWarnings("unchecked")
		Map<String, Object> modelMap = (Map<String, Object>) modelAndView
				.getModel().get("model");
		String nowValue = (String) modelMap.get("now");
		assertNotNull(nowValue);
	}
}