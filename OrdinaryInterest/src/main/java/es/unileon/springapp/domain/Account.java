package es.unileon.springapp.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Paula
 *
 */

/**
 * 
 * Account class contains the movements of an account, the account has a
 * description, every movement has assigned a date and a final balance of the
 * account
 * 
 */

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	private String accountDescription;
	private Double movementBalance1;
	private Double movementBalance2;
	private Double movementBalance3;
	private Double movementBalance4;
	private Double movementBalance5;
	private Double movementWithIncrease;
	private Double amountToIncrease;
	private Date dateMov1;
	private Date dateMov2;
	private Date dateMov3;
	private Date dateMov4;
	private Date dateMov5;

	/**
	 * 
	 * @return accountDescription
	 */
	public String getAccountDescription() {
		return accountDescription;
	}

	/**
	 * 
	 * @param accountDescription
	 */
	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

	/**
	 * 
	 * @return movementBalance1
	 */
	public Double getMovementBalance1() {
		return movementBalance1;
	}

	/**
	 * 
	 * @param movementBalance1
	 */
	public void setMovementBalance1(Double movementBalance1) {
		this.movementBalance1 = movementBalance1;
	}

	/**
	 * 
	 * @return movementBalance2
	 */
	public Double getMovementBalance2() {
		return movementBalance2;
	}

	/**
	 * 
	 * @param movementBalance2
	 */
	public void setMovementBalance2(Double movementBalance2) {
		this.movementBalance2 = movementBalance2;
	}

	/**
	 * 
	 * @return movementBalance3
	 */
	public Double getMovementBalance3() {
		return movementBalance3;
	}

	/**
	 * 
	 * @param movementBalance3
	 */
	public void setMovementBalance3(Double movementBalance3) {
		this.movementBalance3 = movementBalance3;
	}

	/**
	 * 
	 * @return movementBalance4
	 */
	public Double getMovementBalance4() {
		return movementBalance4;
	}

	/**
	 * 
	 * @param movementBalance4
	 */
	public void setMovementBalance4(Double movementBalance4) {
		this.movementBalance4 = movementBalance4;
	}

	/**
	 * 
	 * @return movementBalance5
	 */
	public Double getMovementBalance5() {
		return movementBalance5;
	}

	/**
	 * 
	 * @param movementBalance5
	 */
	public void setMovementBalance5(Double movementBalance5) {
		this.movementBalance5 = movementBalance5;
	}

	/**
	 * 
	 * @return movementWithIncrease
	 */
	public Double getMovementWithIncrease() {
		return movementWithIncrease;
	}

	/**
	 * 
	 * @param movementWithIncrease
	 */
	public void setMovementWithIncrease(Double movementWithIncrease) {
		this.movementWithIncrease = round(movementWithIncrease, 2);
	}

	/**
	 * 
	 * @return amountToIncrease
	 */
	public Double getAmountToIncrease() {
		return amountToIncrease;
	}

	/**
	 * 
	 * @param amountToIncrease
	 */
	public void setAmountToIncrease(Double amountToIncrease) {
		this.amountToIncrease = round(amountToIncrease, 2);
	}

	/**
	 * 
	 * @return dateMov1
	 */
	public Date getDateMov1() {
		return dateMov1;
	}

	/**
	 * 
	 * @param dateMov1
	 */
	public void setDateMov1(Date dateMov1) {
		this.dateMov1 = dateMov1;
	}

	/**
	 * 
	 * @return dateMov2
	 */
	public Date getDateMov2() {
		return dateMov2;
	}

	/**
	 * 
	 * @param dateMov2
	 */
	public void setDateMov2(Date dateMov2) {
		this.dateMov2 = dateMov2;
	}

	/**
	 * 
	 * @return dateMov3
	 */
	public Date getDateMov3() {
		return dateMov3;
	}

	/**
	 * 
	 * @param dateMov3
	 */
	public void setDateMov3(Date dateMov3) {
		this.dateMov3 = dateMov3;
	}

	/**
	 * 
	 * @return dateMov4
	 */
	public Date getDateMov4() {
		return dateMov4;
	}

	/**
	 * 
	 * @param dateMov4
	 */
	public void setDateMov4(Date dateMov4) {
		this.dateMov4 = dateMov4;
	}

	/**
	 * 
	 * @return dateMov5
	 */
	public Date getDateMov5() {
		return dateMov5;
	}

	/**
	 * 
	 * @param dateMov5
	 */
	public void setDateMov5(Date dateMov5) {
		this.dateMov5 = dateMov5;
	}

	/**
	 * Method that rounds to so many decimals since let's we want
	 * 
	 * @param number
	 * @param decimals
	 * @return roundNumber
	 */
	public double round(double number, int decimals) {
		double roundNumber = Math.round(number * Math.pow(10, decimals))
				/ Math.pow(10, decimals);
		return roundNumber;
	}

	/**
	 * Method that calculates the average balance of the account
	 * 
	 * @return balanceAverage
	 */
	public double getBalanceAverage() {
		double balanceAverage = (this.movementBalance1 + this.movementBalance2
				+ this.movementBalance3 + this.movementBalance4 + this.movementBalance5) / 5;
		balanceAverage = round(balanceAverage, 2);
		return balanceAverage;

	}

	/**
	 * Method that calculates the difference in days between two dates, dateMov5
	 * refers to the date on which the last movement was made dateMov1 refers to
	 * the date on which the first movement was made
	 * 
	 * @return days
	 */
	public int daysBetweenTwoDates() {
		int days = (int) ((dateMov5.getTime() - dateMov1.getTime()) / (1000 * 60 * 60 * 24));
		return days;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Account: " + accountDescription + ";");
		buffer.append("Movement1: " + movementBalance1 + ";");
		buffer.append("Movement2: " + movementBalance2 + ";");
		buffer.append("Movement3: " + movementBalance3 + ";");
		buffer.append("Movement4: " + movementBalance4 + ";");
		buffer.append("Movement5: " + movementBalance5 + ";");
		buffer.append("Movement with increase: " + movementWithIncrease);
		return buffer.toString();
	}

}
