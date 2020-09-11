package math.random.variables.discrete;

import math.functions.basic.BinomialIntFunction;
import math.functions.basic.IntegerFunction;

public class BinomialDiscreteRandomVariable extends DiscreteRandomVariable {

	private int    tries;
	private double successProbability;
	

	private IntegerFunction bin;
	private DiscreteRandomVariable bernoulliRV;
	
	
	/**
	 * Creates a new binomial distributed random variable.
	 * @param tries              total number of tries
	 * @param successProbability the probability for success in a try.
	 */
	public BinomialDiscreteRandomVariable(int tries, double successProbability) {
		this.name               = "discrete binomial";
		this.tries              = tries;
		this.successProbability = successProbability;
		this.bin                = new BinomialIntFunction(tries);
		this.bernoulliRV        = new BernoulliDiscreteRandomVariable(successProbability); 
	}
	
	/**
	 * Returns the success probability of this distribution.
	 * @return success probability
	 */
	public double getSuccessProbability() {
		return this.successProbability;
	}
	
	/**
	 * Returns the number of tries of this distribution.
	 * @return number of tries
	 */
	public int getNumberOfTries() {
		return this.tries;
	}
	
	
	
	@Override
	public double getExpectation() {
		return this.tries * this.successProbability;
	}

	@Override
	public double getVariance() {
		return tries * successProbability * (1 - successProbability);
	}
	
	@Override
	public double getProbability(int x) {
		if(x < 0 || x > tries) {
			return 0;
		}
		else {
			return  (double) bin.getYValue(x) * Math.pow(successProbability, x) * Math.pow(1-successProbability, tries-x);
		}
	}
	
	
	@Override
	public double getCumulativeProbability(int x) {
		if(x < 0) {
			return 0;
		}
		else if (x >= tries) {
			return 1;
		}
		else {
			double sum = 0.0;
			for (int i=0; i<=x; i++) {
				sum += getProbability(i);
			}
			return sum;
		}
	}

	
	@Override
	public int getRandomValue() {
		// create variable using inversion
		int counter = 0;
		for (int i=0; i<tries; i++) {
			counter += bernoulliRV.getRandomValue();
		}
		return counter;
	}

}
