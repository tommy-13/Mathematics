package math.number.complex;

public class ComplexNumber {

	private double real;
	private double imaginary;

	/**
	 * Creates a new complex number <code>real + i * imaginary</code>.
	 * @param real
	 * @param imaginary
	 */
	public ComplexNumber(double real, double imaginary) {
		this.real		= real;
		this.imaginary	= imaginary;
	}
	
	/**
	 * Creates a copy of <code>complexNumber</code>.
	 * @param complexNumber
	 */
	public ComplexNumber(ComplexNumber complexNumber) {
		real      = complexNumber.getReal();
		imaginary = complexNumber.getImaginary();
	}
	
	
	/**
	 * Returns the real part of this complex number.
	 * @return real part
	 */
	public double getReal() {
		return real;
	}
	
	/**
	 * Returns the imaginary part of this complex number.
	 * @return denominator
	 */
	public double getImaginary() {
		return imaginary;
	}
	
	
	
	/**
	 * Multiplies this complex number with <code>cn</code> and returns the result.
	 * @param cn
	 * @return result of the multiplication
	 */
	public ComplexNumber multiply(ComplexNumber cn) {
		double re = real * cn.getReal();
		re = re - imaginary * cn.getImaginary();
		double im = real * cn.getImaginary();
		im = im + imaginary * cn.getReal();
		return new ComplexNumber(re, im);
	}
	
	/**
	 * Divides this complex number through <code>cn</code> and returns the result.
	 * @param cn
	 * @return result of the division
	 */
	public ComplexNumber divide(ComplexNumber cn) {
		ComplexNumber res = this.multiply(cn.conjugate());
		double factor = cn.abs() * cn.abs();
		res = res.multiply(new ComplexNumber(1/factor, 0));
		return res;
	}
	
	/** 
	 * Adds this complex number and <code>cn</code> and returns the result.
	 * @param cn
	 * @return result of the addition
	 */
	public ComplexNumber add(ComplexNumber cn) {
		double re = real + cn.getReal();
		double im = imaginary + cn.getImaginary();
		return new ComplexNumber(re, im);
	}
	
	/**
	 * Returns the negation of this complex number. 
	 * @return negation
	 */
	public ComplexNumber negate() {
		return new ComplexNumber(-real, -imaginary);
	}
	
	/**
	 * Returns the conjugate of this complex number.
	 * @return conjugate
	 */
	public ComplexNumber conjugate() {
		return new ComplexNumber(real, -imaginary);
	}
	
	/**
	 * Subtracts <code>cn</code> of this complex number and returns the result.
	 * @param cn
	 * @return result of subtraction
	 */
	public ComplexNumber subtract(ComplexNumber cn) {
		return add(cn.negate());
	}
	
	/**
	 * Inverts this complex number and returns the result - if possible.
	 * If this complex number is 0, an <code>ArithmeticException</code> will be thrown.
	 * @return result of inversion
	 */
	public ComplexNumber invert() {
		if(abs() == 0) {
			throw new ArithmeticException();
		}
		return (new ComplexNumber(1, 0)).divide(this);
	}
	
	/**
	 * Returns the absolute value of this complex number.
	 * @return absolute value
	 */
	public double abs() {
		double temp = real * real;
		temp = temp + imaginary * imaginary;
		return StrictMath.sqrt(temp);
	}
	

	@Override
	public String toString() {
		return real + " + " + imaginary + "i";
	}
}
