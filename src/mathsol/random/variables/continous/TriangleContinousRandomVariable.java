package mathsol.random.variables.continous;

public class TriangleContinousRandomVariable extends ContinousRandomVariable {

	private double lowerBound;
	private double upperBound;
	private double maximalProb;
	
	/**
	 * Creates a new uniformly distributed random variable with lower bound
	 * <code>lowerBound</code> and upper bound <code>upperBounde</code> (both
	 * inclusive).
	 * @param lowerBound
	 * @param upperBound
	 * @param maximalProb value where the density f is maximal, i. e. f(maximalProb) is maximal 
	 */
	public TriangleContinousRandomVariable(double lowerBound, double upperBound, double maximalProb) {
		this.name = "continous triangle";
		
		if (!(lowerBound <= maximalProb && maximalProb <= upperBound && lowerBound < upperBound)) {
			throw new IllegalArgumentException("The following is requiered: lowerBound < upperBound and lowerBound <= maximalProb <= upperBound");
		}
		
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.maximalProb = maximalProb;
	}
	
	/**
	 * Returns the lower bound of this distribution.
	 * @return lower bound
	 */
	public double getLowerBound() {
		return lowerBound;
	}
	/**
	 * Returns the upper bound of this distribution.
	 * @return upper bound
	 */
	public double getUpperBound() {
		return upperBound;
	}
	/**
	 * Returns the value where the density function is maximal.
	 * @return maximal probability x-value
	 */
	public double getMaximalProbabilityValue() {
		return maximalProb;
	}
	
	
	
	
	@Override
	public double getExpectation() {
		return (lowerBound + upperBound + maximalProb) / 3;
	}

	@Override
	public double getVariance() {
		double summand1 = upperBound - lowerBound;
		summand1 *= summand1;
		double summand2 = upperBound - maximalProb;
		summand2 *= summand2;
		double summand3 = maximalProb - lowerBound;
		summand3 *= summand3;
		return (summand1 + summand2 + summand3)  / 36;
	}
	
	@Override
	public double getProbabilityMass(double x) {
		if (x < lowerBound || x > upperBound) {
			return 0;
		}
		else if (x < maximalProb) {
			double numerator   = 2 * (x - lowerBound);
			double denominator = (upperBound - lowerBound) * (maximalProb - lowerBound);
			return numerator / denominator;
		}
		else if (x == maximalProb) {
			return 2.0 / (upperBound - lowerBound);
		}
		else {
			double numerator   = 2 * (upperBound - x);
			double denominator = (upperBound - lowerBound) * (upperBound - maximalProb);
			return numerator / denominator;
		}
	}
	
	@Override
	public double getCumulativeProbabilityMass(double x) {
		if (x <= lowerBound) {
			return 0;
		}
		else if (x >= upperBound) {
			return 1;
		}
		else if (x < maximalProb) {
			double numerator   = x - lowerBound;
			numerator *= numerator;
			double denominator = (upperBound - lowerBound) * (maximalProb - lowerBound);
			return numerator / denominator;
		}
		else if (x == maximalProb) {
			return (maximalProb - lowerBound) / (upperBound - lowerBound);
		}
		else {
			double numerator   = upperBound - x;
			numerator *= numerator;
			double denominator = (upperBound - lowerBound) * (upperBound - maximalProb);
			return 1.0 - numerator / denominator;
		}
	}

	@Override
	public double getRandomValue() {
		// inversion
		double range = upperBound-lowerBound;
		double rand = randomGenerator.nextDouble();
		if (rand <= (maximalProb - lowerBound) / range) {
			return lowerBound + Math.sqrt(rand * range * (maximalProb - lowerBound));
		}
		else {
			return upperBound - Math.sqrt((1 - rand) * range * (upperBound - maximalProb));
		}
	}

}
