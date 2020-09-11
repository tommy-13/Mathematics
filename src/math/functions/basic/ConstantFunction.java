package math.functions.basic;

public class ConstantFunction implements DoubleFunction {
	
	private double yValue;
	
	/**
	 * Creates a new constant function with y-value <code>yValue</code>
	 * @param yValue
	 */
	public ConstantFunction(double yValue) {
		this.yValue = yValue;
	}

	
	@Override
	public double getYValue(double x) {
		return yValue;
	}

}
