package es.unileon.springapp.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.springapp.service.SimpleAccountManager;
import es.unileon.springapp.web.AfterInterestController;

/**
 * 
 * @author Paula
 *
 */


public class AfterInterestControllerTests {
	/**
	 * Test taken of the 'springapp' example adapted to the application
	 * 
	 * @throws Exception
	 */
	@Test
	public void testHandleRequestView() throws Exception {
		AfterInterestController controller = new AfterInterestController();
		controller.setAccountManager(new SimpleAccountManager());
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("movementsAfterInterest", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		@SuppressWarnings("unchecked")
		Map<String, Object> modelMap = (Map<String, Object>) modelAndView
				.getModel().get("model");
		String nowValue = (String) modelMap.get("now");
		assertNotNull(nowValue);
	}

}
