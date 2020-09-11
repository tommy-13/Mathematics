package math.random.variables.continous;

import math.functions.basic.GaussianDensityFunction;
import math.functions.integral.IntegralCalculator;
import math.functions.integral.TrapezeRuleIntegralCalculator;

public class GaussianContinousRandomVariable extends ContinousRandomVariable {

	private final double INTEGRAL_TOLERANCE = 1e-5;
	
	
	private double mu;
	private double sigma;
	private double variance;
	
	private GaussianDensityFunction gdf;
	private IntegralCalculator      integralCalc = new TrapezeRuleIntegralCalculator();
	
	
	/**
	 * Creates a new gaussian distributed random variable with expectation <code>mu</code>
	 * and variance <code>sigma<code>².
	 * inclusive).
	 * @param mu
	 * @param sigma
	 */
	public GaussianContinousRandomVariable(double mu, double sigma) {
		this.name = "continous gaussian";
		if (sigma == 0.0) {
			throw new IllegalArgumentException("Sigma must not be 0.");
		}
		if (sigma < 0.0) {
			this.sigma = -sigma;
			System.out.println("Auto-correction: changed sigma to its absolut value.");
		}
		else {
			this.sigma = sigma;
		}
		this.mu = mu;
		this.variance = this.sigma * this.sigma;
		
		gdf = new GaussianDensityFunction(mu, variance);
		integralCalc.setTolerance(INTEGRAL_TOLERANCE);
	}
	
	/**
	 * Returns mu.
	 * @return
	 */
	public double getMu() {
		return this.mu;
	}
	/**
	 * Returns the standard deviation.
	 * @return
	 */
	public double getSigma() {
		return this.sigma;
	}
	
	
	
	
	@Override
	public double getExpectation() {
		return mu;
	}

	@Override
	public double getVariance() {
		return variance;
	}
	
	
	@Override
	public double getProbabilityMass(double x) {
		return gdf.getYValue(x);
	}


	@Override
	public double getCumulativeProbabilityMass(double x) {

		// use symmetry of gaussian function
		
		if(x < mu) {
			double integralDif = integralCalc.getIntegral(gdf, x, mu);
			
			return 0.5 - integralDif;
		}
		else {
			
			double integralDif = integralCalc.getIntegral(gdf, mu, x);
			
			return 0.5 + integralDif;
		}
	}

	
	
	@Override
	public double getRandomValue() {
		// use polar method by George Marsaglia to create gaussian distribution
		
		double q = 10;
		double u1 = 0, u2 = 0;
		
		while (q >= 1.0 || q == 0.0) {
			// 1. two independent numbers in [-1,1]
			u1 = randomGenerator.nextDouble() * 2 - 1;
			u2 = randomGenerator.nextDouble() * 2 - 1;

			// 2. calculate q = u1^2 + u2^2
			q = u1*u1 + u2*u2;
		}
		
		// 3. calculate p = sqrt(-2 ln q / q)
		double p = Math.sqrt(-2 * Math.log(q) / q);
		
		// 4. xi = ui * p are gaussian with mu=0 and variance=1
		double x1 = u1 * p;
		
		
		return sigma * x1 + mu;
	}

}
