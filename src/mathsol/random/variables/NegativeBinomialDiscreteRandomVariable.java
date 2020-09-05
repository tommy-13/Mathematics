package mathsol.random.variables;

import mathsol.functions.basic.BinomialIntFunction;

public class NegativeBinomialDiscreteRandomVariable extends DiscreteRandomVariable {

	private double successProbability;
	private int    numberSuccess;
	
	private GeometricDiscreteRandomVariable geo; 
	
	
	
	/**
	 * Creates a new geometric distributed random variable.
	 * Thereby the probability of some x describes the probability that the x-th try is the first successful one.
	 * @param successProbability the probability for success in a try
	 */
	public NegativeBinomialDiscreteRandomVariable(double successProbability, int numberSuccess) {
		this.name               = "discrete negative binomial";
		this.successProbability = successProbability;
		this.numberSuccess      = numberSuccess;
		
	    geo = new GeometricDiscreteRandomVariable(successProbability);
	}
	
	/**
	 * Returns the success probability of this distribution.
	 * @return success probability
	 */
	public double getSuccessProbability() {
		return this.successProbability;
	}
	
	/**
	 * Returns the number of successful attempts.
	 * @return successes
	 */
	public int getNumberOfSuccess() {
		return this.numberSuccess;
	}
		
	
	@Override
	public double getExpectation() {
		return ((double) numberSuccess) / successProbability;
	}

	@Override
	public double getVariance() {
		return numberSuccess * (1 - successProbability) / (successProbability * successProbability);
	}
	
	@Override
	public double getProbability(int x) {
		if (x < numberSuccess) {
			return 0;
		}
		else {
			double failorProb = 1-successProbability;
			BinomialIntFunction bin = new BinomialIntFunction(x-1);
			return bin.getYValue(numberSuccess-1) * Math.pow(successProbability, numberSuccess) * Math.pow(failorProb, x-numberSuccess);
		}
	}
	
	
	@Override
	public double getCumulativeProbability(int x) {
		if(x < numberSuccess) {
			return 0;
		}
		else {
			double sum = 0.0;
			for (int i=numberSuccess; i<=x; i++) {
				sum += getProbability(i);
			}
			return sum; 
		}
	}


	@Override
	public int getRandomValue() {
		// create variable using geometric distribution
		int sum = 0;
		for (int i=0; i<numberSuccess; i++) {
			sum += geo.getRandomValue();
		}
		return sum;
	}

}
