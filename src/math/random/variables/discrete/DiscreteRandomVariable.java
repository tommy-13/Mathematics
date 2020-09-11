package math.random.variables.discrete;

import math.random.variables.RandomVariable;

/**
 * Class for a discrete random variable.
 * @author tommy
 *
 */
public abstract class DiscreteRandomVariable extends RandomVariable {
	
	/**
	 * Returns the probability of <code>x</code>.
	 * @param x
	 * @return probability of <code>x</code>
	 */
	public abstract double getProbability(int x);
	
	/**
	 * Returns the value of the cumulative probability of this distribution
	 * at point <code>x</code>. 
	 * @param x
	 * @return cumulative probability
	 */
	public abstract double getCumulativeProbability(int x);
	
	/**
	 * Returns a randomly generated value of this distribution.
	 * @return random value
	 */
	public abstract int getRandomValue();
}
