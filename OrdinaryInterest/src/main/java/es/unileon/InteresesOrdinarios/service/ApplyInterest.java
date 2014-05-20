package es.unileon.InteresesOrdinarios.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Paula
 *
 */

/**
 * 
 * Class that applies the interest
 *
 */
public class ApplyInterest {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Min(0)
	@Max(100)
	private int percentage;

	/**
	 * 
	 * @param i
	 */
	public void setPercentage(int i) {
		percentage = i;
		logger.info("Percentage set to " + i);
	}

	/**
	 * 
	 * @return percentage
	 */
	public int getPercentage() {
		return percentage;
	}
}
