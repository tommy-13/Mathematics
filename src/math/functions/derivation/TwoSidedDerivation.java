package math.functions.derivation;

import math.functions.basic.DoubleFunction;

/**
 * The derivation is calculated by taking the y-values at <code>x - tolerance</code>
 * and <code>x + tolerance</code> and calculate the gradient between both.
 * @author tommy
 *
 */
public class TwoSidedDerivation extends DerivationCalculator {


	@Override
	public double getDerivation(DoubleFunction function, double x) {
		
		double left = function.getYValue(x - tolerance);
		double right = function.getYValue(x + tolerance);
		
		return (right - left) / (2*tolerance);
	}

}
