package math.functions.integral;

import math.functions.basic.DoubleFunction;

/**
 * Implements an <code>IntegralCalculator</code> based on the Simpson Rule,
 * also known as Gauss-Lobato-Integration with three positions (n=3).
 * @author tommy
 *
 */
public class SimpsonRuleIntegralCalculator extends IntegralCalculator {

	@Override
	public double getIntegral(DoubleFunction function, double lowerX, double upperX) {
		
		int    sectors  = 1;
		double sum      = 0;
		double checkSum = 0;
		double sqrt5    = Math.sqrt(1/5);
		
		do {
			sum      = 0;
			checkSum = 0;
			
			double gap      = (upperX - lowerX) / sectors;
			
			for(int s=0; s<sectors; s++) {
				double lowerVal   = lowerX + s * gap;
				double fLow       = function.getYValue(lowerVal);
				double fHigh      = function.getYValue(lowerVal + gap);
				double fMiddle    = function.getYValue(lowerVal + gap/2);
				double fCheckLow  = function.getYValue(lowerVal + (1-sqrt5)*gap/2);
				double fCheckHigh = function.getYValue(lowerVal + (1+sqrt5)*gap/2);

				
				// use Gauss-Lobato-Integration with four positions to approximate accuracy
				sum      += gap * (fLow + 4 * fMiddle + fHigh) / 6;
				checkSum += gap * (fLow + 5 * fCheckLow + 5 * fCheckHigh + fHigh) / 12;
			}

			sectors *= 2;
		} while (Math.abs(sum - checkSum) > tolerance && sectors < Integer.MAX_VALUE / 2);

		// return result of four positions integration, which should be more accurate
		return checkSum;
	}

}
