package math.functions.basic;

public class GaussianDensityFunction implements DoubleFunction {
	
	private double mu, sigma2;
	
	
	private double factor;
	
	
	
	/**
	 * Creates a new gaussian function of the form<br><br>
	 * 1 / (sqrt(2pi * sigma2) * exp( - (x-mu)^2 / (2 * sigma2) ),<br><br>
	 * where <code>mu</code> is the mean and <code>sigma2</code> is the variance.
	 * @param mu
	 * @param sigma2
	 */
	public GaussianDensityFunction(double mu, double sigma2) {
		this.mu     = mu;
		this.sigma2 = sigma2;
		
		factor = 1.0 / Math.sqrt(2.0*Math.PI*sigma2);
	}
	
	/**
	 * Returns mu (the mean).
	 * @return
	 */
	public double getMu() {
		return this.mu;
	}
	
	/**
	 * Returns the variance. 
	 * @return
	 */
	public double getVariance() {
		return this.getVariance();
	}
	
	

	@Override
	public double getYValue(double x) {
		double exp = x - mu;
		exp = exp * exp;
		exp = exp / (2.0*sigma2);
		return factor * Math.pow(Math.E, -exp);
	}

}
