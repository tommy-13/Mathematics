package math.random.variables.continous;

import math.random.variables.RandomVariable;

/**
 * Class for a continous random variable.
 * @author tommy
 *
 */
public abstract class ContinousRandomVariable extends RandomVariable {
	
	/**
	 * Returns the probability mass of this distribution at position
	 * <code>x</code>.
	 * @param x
	 * @return probability mass of <code>x</code>
	 */
	public abstract double getProbabilityMass(double x);
	
	/**
	 * Returns the value of the cumulative probability mass function
	 * of this distribution at point <code>x</code>. 
	 * @param x
	 * @return cumulative probability mass
	 */
	public abstract double getCumulativeProbabilityMass(double x);
	
	/**
	 * Returns a randomly generated value of this distribution.
	 * @return random value
	 */
	public abstract double getRandomValue();
}
