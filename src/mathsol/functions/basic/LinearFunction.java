package mathsol.functions.basic;

public class LinearFunction implements DoubleFunction {

	private double yCut;
	private double slope;
	
	/**
	 * Creates a new linear function with y-value <code>yCut</code> for an x-value
	 * of 0 and a slope <code>slope</code>.
	 * @param yCut
	 * @param slope
	 */
	public LinearFunction(double yCut, double slope) {
		this.yCut = yCut;
		this.slope = slope;
	}
	
	
	/**
	 * Returns the y-value at x-position 0.
	 * @return
	 */
	public double getYCut() {
		return yCut;
	}
	/**
	 * Returns the slope of this linear function.
	 * @return
	 */
	public double getSlope() {
		return slope;
	}
	
	
	@Override
	public double getYValue(double x) {
		return yCut + x * slope;
	}

}
