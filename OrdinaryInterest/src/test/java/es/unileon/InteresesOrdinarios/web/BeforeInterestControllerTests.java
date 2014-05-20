package es.unileon.InteresesOrdinarios.web;

import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.InteresesOrdinarios.service.SimpleAccountManager;
import es.unileon.InteresesOrdinarios.web.BeforeInterestController;

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
		controller.setAccountManager(new SimpleAccountManager());
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