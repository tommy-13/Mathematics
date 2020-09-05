package mathsol.random.variables.continous;

public class ExponentialContinousRandomVariable extends ContinousRandomVariable {

	private double lambda;
	
	/**
	 * Creates a new exponentially distributed random variable with parameter <code>lambda</code>.
	 * @param lambda
	 */
	public ExponentialContinousRandomVariable(double lambda) {
		this.name = "continous exponential";
		if (lambda <= 0) {
			throw new ArithmeticException("The parameter lambda must be larger than 0.");
		}
		this.lambda = lambda;
	}
	
	/**
	 * Returns the parameter <code>lambda</code>.
	 * @return parameter lambda
	 */
	public double getLambda() {
		return lambda;
	}
	
	
	
	
	@Override
	public double getExpectation() {
		return 1.0 / lambda;
	}

	@Override
	public double getVariance() {
		return 1.0 / (lambda * lambda);
	}
	
	@Override
	public double getProbabilityMass(double x) {
		if(x < 0) {
			return 0;
		}
		else {
			return lambda * Math.exp(- lambda * x);
		}
	}
	
	@Override
	public double getCumulativeProbabilityMass(double x) {
		if(x < 0) {
			return 0;
		}
		else {
			return 1.0 - Math.exp(- lambda * x);
		}
	}

	@Override
	public double getRandomValue() {
		return - 1.0 / lambda * Math.log(randomGenerator.nextDouble());
	}

}
