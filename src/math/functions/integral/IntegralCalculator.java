package math.functions.integral;

import math.functions.basic.DoubleFunction;


/**
 * Class to calculate the integral of a function approximately.
 * The default error tolerance is 0.001. If possible the error tolerance
 * should be used to reach a certain accuracy in the calculation.
 * @author tommy
 *
 */
public abstract class IntegralCalculator {

	protected double tolerance = 1e-3;
	
	/**
	 * Sets the error tolerance for this integral calculation.
	 * @param tolerance
	 */
	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}
	
	/**
	 * Returns the error tolerance for this integral calculation.
	 * @return
	 */
	public double getTolerance() {
		return tolerance;
	}
	
	/**
	 * Returns the integral from <code>lowerX</code> to <code>upperX</code> of
	 * the given DoubleFunction <code>function</code>.
	 * @param function
	 * @param lowerX
	 * @param upperX
	 * @return
	 */
	public abstract double getIntegral(DoubleFunction function, double lowerX, double upperX);
	
}
