package math.functions.basic;

public class HyperbelFunction implements DoubleFunction {
	
	private static final double TOL = Double.MIN_NORMAL;
	private double a;
	
	/**
	 * Creates a new hyperbel function of the form<br><br>
	 * 1 / (x - a).
	 * @param t
	 */
	public HyperbelFunction(double a) {
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
		if(Math.abs(x-a) < TOL) {
			return Double.POSITIVE_INFINITY;
		}
		if(x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY) {
			return 0;
		}
		return 1 / (x - a);
	}

}
