package mathsol.random.variables;

public class UniformContinousRandomVariable extends ContinousRandomVariable {

	private double lowerBound;
	private double upperBound;
	
	/**
	 * Creates a new uniformly distributed random variable with lower bound
	 * <code>lowerBound</code> and upper bound <code>upperBounde</code> (both
	 * inclusive).
	 * @param lowerBound
	 * @param upperBound
	 */
	public UniformContinousRandomVariable(double lowerBound, double upperBound) {
		this.name = "continous uniform";
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	/**
	 * Returns the lower bound of this distribution.
	 * @return
	 */
	public double getLowerBound() {
		return lowerBound;
	}
	/**
	 * Returns the upper bound of this distribution.
	 * @return
	 */
	public double getUpperBound() {
		return upperBound;
	}
	
	
	
	
	@Override
	public double getExpectation() {
		return (lowerBound + upperBound) / 2;
	}

	@Override
	public double getVariance() {
		return (upperBound - lowerBound) * (upperBound - lowerBound) / 12;
	}
	
	@Override
	public double getProbabilityMass(double x) {
		if(x < lowerBound || x > upperBound) {
			return 0;
		}
		else {
			return 1 / (upperBound - lowerBound);
		}
	}
	
	@Override
	public double getCumulativeProbabilityMass(double x) {
		if(x < lowerBound) {
			return 0;
		}
		else if(x >= upperBound) {
			return 1;
		}
		else {
			return (x - lowerBound) / (upperBound - lowerBound);
		}
	}

	@Override
	public double getRandomValue() {
		double range = upperBound - lowerBound;
		return lowerBound + randomGenerator.nextDouble() * range;
	}

}
