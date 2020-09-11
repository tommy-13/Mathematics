package math.functions.basic;

public class QuadraticFunction implements DoubleFunction {
	
	private double a,b,c;
	
	/**
	 * Creates a new quadratic function of the form<br><br>
	 * ax^2 + bx + c,<br><br>
	 * where <code>a</code> is the quadratic parameter, <code>b</code> is the linear
	 * parameter and <code>c</code> is the constant parameter.
	 * @param a
	 * @param b
	 * @param c
	 */
	public QuadraticFunction(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/**
	 * Returns the quadratic parameter of this quadratic function.
	 * @return
	 */
	public double getA() {
		return a;
	}
	
	/**
	 * Returns the linear parameter of this quadratic function. 
	 * @return
	 */
	public double getB() {
		return b;
	}
	
	/**
	 * Returns the constant parameter of this quadratic function.
	 * @return
	 */
	public double getC() {
		return c;
	}
	
	
	public double getDeterminante() {
		return 4*b*b - 4*a*c;
	}
	
	

	@Override
	public double getYValue(double x) {
		return a*x*x + b*x + c;
	}

}
