package mathsol.functions.integral;

import mathsol.functions.basic.DoubleFunction;
import mathsol.random.variables.continous.UniformContinousRandomVariable;

/**
 * Implements an <code>IntegralCalculator</code> based on the law of large numbers (probability theory).
 * @author tommy
 *
 */
public class MonteCarloIntegralCalculator extends IntegralCalculator {
	
	private int samples = 100000;

	/**
	 * Creates a new <code>MonteCarloIntegralCalculater</code>.
	 */
	public MonteCarloIntegralCalculator() {}
	
	/**
	 * Creates a new <code>MonteCarloIntegralCalculater</code>.
	 * @param number of samples
	 */
	public MonteCarloIntegralCalculator(int samples) {
		checkSamples(samples);
	}
	
	/**
	 * Returns the number of samples this calculator uses.
	 * @return number of samples
	 */
	public int getNumberOfSamples() {
		return this.samples;
	}
	
	/**
	 * Sets the number of samples this calculator uses.
	 * @param samples number of samples
	 */
	public void setNumberOfSamples(int samples) {
		checkSamples(samples);
	}
	
	private void checkSamples(int samples) {
		if (samples <= 0) {
			throw new IllegalArgumentException("The number of samples must be at least 1");
		}
		this.samples = samples;
	}

	
	@Override
	public double getIntegral(DoubleFunction function, double lowerX, double upperX) {
		
		double intervalLength = upperX - lowerX;
		
		UniformContinousRandomVariable rand = new UniformContinousRandomVariable(lowerX, upperX);
		
		double sum      = 0.0;
		
		for (int i=0; i<samples; i++) {
			sum += function.getYValue(rand.getRandomValue());
		}
		
		return sum / samples * intervalLength;
	}

}
