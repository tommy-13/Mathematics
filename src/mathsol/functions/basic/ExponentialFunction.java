package mathsol.functions.basic;

public class ExponentialFunction implements DoubleFunction {
	
	private double a;
	
	/**
	 * Creates a new exponential function of the form<br><br>
	 * e^{ax}.
	 * @param t
	 */
	public ExponentialFunction(double a) {
		this.a = a;
	}
	
	/**
	 * Returns the parameter of this exponential function.
	 * @return
	 */
	public double getA() {
		return a;
	}
	
	

	@Override
	public double getYValue(double x) {
		return Math.exp(a*x);
	}

}
