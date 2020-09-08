package mathsol.functions.integral;

import mathsol.functions.basic.DoubleFunction;

/**
 * Implements an <code>IntegralCalculator</code> based on the TrapezeRule.
 * @author tommy
 *
 */
public class TrapezeRuleIntegralCalculator extends IntegralCalculator {

	@Override
	public double getIntegral(DoubleFunction function, double lowerX, double upperX) {
		
		int    sectors  = 1;
		double sum      = 0;
		double checkSum = 0;
		
		do {
			sum      = 0;
			checkSum = 0;

			double gap      = (upperX - lowerX) / sectors;
			
			for(int s=0; s<sectors; s++) {
				double lowerVal = lowerX + s * gap;
				double fLow     = function.getYValue(lowerVal);
				double fHigh    = function.getYValue(lowerVal + gap);
				double fMiddle  = function.getYValue(lowerVal + gap/2);
				
				// use simpson rule to approximate accuracy
				sum      += gap * (fLow + fHigh) / 2;
				checkSum += gap * (fLow + 4 * fMiddle + fHigh) / 6;
			}

			sectors *= 2;
		} while (Math.abs(sum - checkSum) > tolerance && sectors < Integer.MAX_VALUE / 2);
		
		// return result of simpson rule, which should be more accurate
		return checkSum;
	}

}
