package mathsol.random.variables.discrete;

public class BernoulliDiscreteRandomVariable extends DiscreteRandomVariable {

	private double successProbability;
		
	
	/**
	 * Creates a new bernoulli distributed random variable.
	 * @param successProbability the probability for success in a try
	 */
	public BernoulliDiscreteRandomVariable(double successProbability) {
		this.name               = "discrete bernoulli";
		this.successProbability = successProbability;
	}
	
	/**
	 * Returns the success probability of this distribution.
	 * @return success probability
	 */
	public double getSuccessProbability() {
		return this.successProbability;
	}
		
	
	@Override
	public double getExpectation() {
		return this.successProbability;
	}

	@Override
	public double getVariance() {
		return successProbability * (1 - successProbability);
	}
	
	@Override
	public double getProbability(int x) {
		if(x < 0 || x > 1) {
			return 0;
		}
		else {
			return  (x == 1) ? successProbability : 1-successProbability;
		}
	}
	
	
	@Override
	public double getCumulativeProbability(int x) {
		if(x < 0) {
			return 0;
		}
		else {
			return (x == 0) ? 1-successProbability : 1; 
		}
	}

	
	@Override
	public int getRandomValue() {
		// create variable using inversion
		double rand = randomGenerator.nextDouble();
		return (rand < successProbability) ? 1 : 0;
	}

}
