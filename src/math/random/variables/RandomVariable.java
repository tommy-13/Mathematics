package math.random.variables;

import java.util.Random;

/**
 * Class for a random variable.
 * @author tommy
 *
 */
public abstract class RandomVariable {
	
	protected String name;
	protected Random randomGenerator = new Random(0);
	protected long seed;
	
	public String getName() {
		return name;
	}
	
	public void setSeed(long seed) {
		this.seed = seed;
		randomGenerator.setSeed(seed);
	}
	public long getSeed() {
		return seed;
	}
	
	/**
	 * Returns the expectation of this distribution.
	 * @return mean value
	 */
	public abstract double getExpectation();
	
	/**
	 * Returns the variance of this distribution.
	 * @return variance
	 */
	public abstract double getVariance();
	
}
