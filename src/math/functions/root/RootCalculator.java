package math.functions.root;

import math.functions.basic.DoubleFunction;

public abstract class RootCalculator {
	
	protected DoubleFunction f;
	protected double         start = 0.0;
	protected double         tolerance = 1e-5;
	
	
	/**
	 * Creates a new RootCalculator for the function <code>f</code>.
	 * @param f function
	 */
	public RootCalculator(DoubleFunction f, double startingPoint) {
		this.f = f;
		this.start = startingPoint;
	}

	/**
	 * Calculates a root of <code>f</code>, that is, a value x such that f(x)=0
	 * @param f function
	 * @return a root of <code>f</code>
	 */
	public abstract double getRoot();
	
	/**
	 * Sets a new starting point.
	 * @param startingPoint new starting point
	 */
	public void setStartingPoint(double startingPoint) {
		this.start = startingPoint;
	}
	/**
	 * Returns the starting point.
	 * @return starting point
	 */
	public double getStartingPoint() {
		return start;
	}
	
	/**
	 * Returns the function.
	 * @return function
	 */
	public DoubleFunction getFunction() {
		return f;
	}
	
	/**
	 * Returns the tolerance for the root.
	 * @return tolerance
	 */
	public double getTolerance() {
		return tolerance;
	}
	/**
	 * Sets the tolerance for the root.
	 * @param tolerance
	 */
	public void setTolerance(double tolerance) {
		if (tolerance < 0) {
			throw new IllegalArgumentException("Tolerance must be a positiv number");
		}
		this.tolerance = tolerance;
	}
}
