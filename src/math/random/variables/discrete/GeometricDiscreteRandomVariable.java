package math.random.variables.discrete;

public class GeometricDiscreteRandomVariable extends DiscreteRandomVariable {

	private double successProbability;
		
	
	/**
	 * Creates a new geometric distributed random variable.
	 * Thereby the probability of some x describes the probability that the x-th try is the first successful one.
	 * @param successProbability the probability for success in a try
	 */
	public GeometricDiscreteRandomVariable(double successProbability) {
		this.name               = "discrete geometric";
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
		return 1.0 / this.successProbability;
	}

	@Override
	public double getVariance() {
		return (1 - successProbability) / (successProbability * successProbability);
	}
	
	@Override
	public double getProbability(int x) {
		if (x < 1) {
			return 0;
		}
		else {
			double failorProb = 1-successProbability;
			return  successProbability * Math.pow(failorProb, x-1);
		}
	}
	
	
	@Override
	public double getCumulativeProbability(int x) {
		if(x < 1) {
			return 0;
		}
		else {
			double failorProb = 1-successProbability;
			return 1 - Math.pow(failorProb, x); 
		}
	}

	
	@Override
	public int getRandomValue() {
		// create variable using inversion
		double rand = randomGenerator.nextDouble();
		
		int    tries          = 1;
		double cumulativeProb = successProbability;
		double failureProb    = 1 - successProbability;
		double probBefore     = successProbability; 
		
		while (cumulativeProb < rand) {
			tries++;
			probBefore     *= failureProb; // P[X=x] = (1-successProb)*P[X=x-1]
			cumulativeProb += probBefore;
		}
		
		return tries;
	}

}
