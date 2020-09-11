package math.functions.derivation;

import math.functions.basic.DoubleFunction;


/**
 * Class to calculate the derivation of a function approximately.
 * The default error tolerance is 0.001. If possible the error tolerance
 * should be used to reach a certain accuracy in the calculation.
 * @author tommy
 *
 */
public abstract class DerivationCalculator {
	
	protected double tolerance = 1e-3;
	
	/**
	 * Sets the error tolerance for this derivation calculation.
	 * @param tolerance
	 */
	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}
	
	/**
	 * Returns the error tolerance for this derivation calculation.
	 * @return
	 */
	public double getTolerance() {
		return tolerance;
	}
	
	/**
	 * Returns the derivation of the given DoubleFunction <code>function</code>
	 * at position <code>x</code>.
	 * @param function
	 * @param x
	 * @return
	 */
	public abstract double getDerivation(DoubleFunction function, double x);
	
}
