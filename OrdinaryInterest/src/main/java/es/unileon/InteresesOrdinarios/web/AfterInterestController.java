package es.unileon.InteresesOrdinarios.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.InteresesOrdinarios.service.AccountManager;

/**
 * @author Paula
 *
 */


/**
 * 
 * Class taken of the 'springapp' example adapted to the application
 *
 */
@Controller
public class AfterInterestController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private AccountManager accountManager;

	/**
	 * 
	 * @param request
	 * @param response
	 * @return new ModelAndView("movementsAfterInterest", "model", myModel)
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/movementsAfterInterest.htm")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String now = (new Date()).toString();
		logger.info("Returning movements view with " + now);

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("account", this.accountManager.getAccount());

		return new ModelAndView("movementsAfterInterest", "model", myModel);
	}

	/**
	 * 
	 * @param accountManager
	 */
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

}
