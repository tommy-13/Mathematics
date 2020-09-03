package mathsol.random.variables;

public class UniformDiscreteRandomVariable extends DiscreteRandomVariable {

	private int lowerBound;
	private int upperBound;
	
	/**
	 * Creates a new uniformly distributed random variable with lower bound
	 * <code>lowerBound</code> and upper bound <code>upperBounde</code> (both
	 * inclusive).
	 * @param lowerBound
	 * @param upperBound
	 */
	public UniformDiscreteRandomVariable(int lowerBound, int upperBound) {
		this.name = "discrete uniform";
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	/**
	 * Returns the lower bound of this distribution.
	 * @return
	 */
	public int getLowerBound() {
		return lowerBound;
	}
	/**
	 * Returns the upper bound of this distribution.
	 * @return
	 */
	public int getUpperBound() {
		return upperBound;
	}
	
	
	
	
	@Override
	public double getExpectation() {
		return ((double) lowerBound + upperBound) / 2;
	}

	@Override
	public double getVariance() {
		return ((double) upperBound - lowerBound + 1) / 12;
	}
	
	@Override
	public double getProbability(int x) {
		if(x < lowerBound || x > upperBound) {
			return 0;
		}
		else {
			return 1.0 / (upperBound - lowerBound + 1);
		}
	}
	
	@Override
	public double getCumulativeProbability(int x) {
		if(x < lowerBound) {
			return 0;
		}
		else if(x >= upperBound) {
			return 1;
		}
		else {
			return ((double) (x - lowerBound + 1)) / (upperBound - lowerBound + 1);
		}
	}

	@Override
	public int getRandomValue() {
		int range = upperBound - lowerBound + 1;
		return lowerBound + randomGenerator.nextInt(range);
	}

}
