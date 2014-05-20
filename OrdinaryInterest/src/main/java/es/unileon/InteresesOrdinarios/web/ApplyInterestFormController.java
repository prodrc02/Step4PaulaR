package es.unileon.InteresesOrdinarios.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.InteresesOrdinarios.service.*;

/**
 * @author Paula
 *
 */

/**
 * Class taken of the 'springapp' example adapted to the application Represents
 * the form for apply the ordinary interest
 */
@Controller
@RequestMapping(value = "/applyinterest.htm")
public class ApplyInterestFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private AccountManager accountManager;

	/**
	 * 
	 * @param applyInterest
	 * @param result
	 * @return "redirect:/movementsAfterInterest.htm"
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid ApplyInterest applyInterest,
			BindingResult result) {
		if (result.hasErrors()) {
			return "applyinterest";
		}

		int increase = applyInterest.getPercentage();
		logger.info("Increasing balance by " + increase + "%.");

		accountManager.applyInterest(increase);

		return "redirect:/movementsAfterInterest.htm";
	}

	/**
	 * 
	 * @param request
	 * @return applyInterest
	 * @throws ServletException
	 */
	@RequestMapping(method = RequestMethod.GET)
	protected ApplyInterest formBackingObject(HttpServletRequest request)
			throws ServletException {
		ApplyInterest applyInterest = new ApplyInterest();
		applyInterest.setPercentage(0);
		return applyInterest;
	}

	/**
	 * 
	 * @param accountManager
	 */
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	/**
	 * 
	 * @return accountManager
	 */
	public AccountManager getAccountManager() {
		return accountManager;
	}

}
