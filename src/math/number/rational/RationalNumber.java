package math.number.rational;

import java.math.BigInteger;

public class RationalNumber {

	private BigInteger numerator;
	private BigInteger denominator;

	/**
	 * Creates a new rational number <code>numerator</code> / <code>denominator</code>.
	 * @param numerator
	 * @param denominator
	 */
	public RationalNumber(BigInteger numerator, BigInteger denominator) {
		this.numerator		= numerator;
		this.denominator	= denominator;
		reduce();
	}
	
	/**
	 * Creates a new rational number <code>num</code> / <code>denominator</code>.
	 * @param num
	 * @param denom
	 */
	public RationalNumber(long num, long denom) {
		this(BigInteger.valueOf(num), BigInteger.valueOf(denom));
	}
	
	/**
	 * Creates a copy of <code>rationalNumber</code>.
	 * @param rationalNumber
	 */
	public RationalNumber(RationalNumber rationalNumber) {
		numerator = rationalNumber.getNumerator();
		denominator = rationalNumber.getDenominator();
		reduce();
	}
	
	
	/**
	 * Returns the numerator of this rational number.
	 * @return numerator
	 */
	public BigInteger getNumerator() {
		return new BigInteger(numerator.toByteArray());
	}
	
	/**
	 * Returns the denominator of this rational number.
	 * @return denominator
	 */
	public BigInteger getDenominator() {
		return new BigInteger(denominator.toByteArray());
	}
	
	
	/**
	 * Reduces this rational number as far as possible.
	 */
	private void reduce() {
		BigInteger bi = numerator.gcd(denominator);
		numerator	= numerator.divide(bi);
		denominator = denominator.divide(bi);
		if(denominator.signum() == -1) {
			denominator = denominator.negate();
			numerator   = numerator.negate();
		}
		else if(denominator.signum() == 0) {
			numerator = BigInteger.ZERO;
			denominator = BigInteger.ONE;
		}
	}
	
	
	/**
	 * Multiplies this rational number with <code>rn</code> and returns the result.
	 * @param rn
	 * @return result of the multiplication
	 */
	public RationalNumber multiply(RationalNumber rn) {
		BigInteger num = numerator.multiply(rn.getNumerator());
		BigInteger den = denominator.multiply(rn.getDenominator());
		return new RationalNumber(num, den);
	}
	
	/**
	 * Divides this rational number through <code>rn</code> and returns the result.
	 * @param rn
	 * @return result of the division
	 */
	public RationalNumber divide(RationalNumber rn) {
		BigInteger num = numerator.multiply(rn.getDenominator());
		BigInteger den = denominator.multiply(rn.getNumerator());
		return new RationalNumber(num, den);
	}
	
	/** 
	 * Adds this rational number and <code>rn</code> and returns the result.
	 * @param rn
	 * @return result of the addition
	 */
	public RationalNumber add(RationalNumber rn) {
		BigInteger den = denominator.multiply(rn.getDenominator());
		BigInteger num = numerator.multiply(rn.getDenominator());
		num = num.add(rn.getNumerator().multiply(denominator));
		int sig = numerator.signum() * rn.getNumerator().signum();
		if(sig == -1) {
			num = num.negate();
		}
		return new RationalNumber(num, den);
	}
	
	/**
	 * Returns the negation of this rational number. 
	 * @return negation
	 */
	public RationalNumber negate() {
		return new RationalNumber(numerator.negate(), denominator);
	}
	
	/**
	 * Subtracts <code>rn</code> of this rational number and returns the result.
	 * @param rn
	 * @return result of subtraction
	 */
	public RationalNumber subtract(RationalNumber rn) {
		return add(rn.negate());
	}
	
	/**
	 * Inverts this rational number and returns the result - if possible.
	 * If the numerator is 0, an <code>ArithmeticException</code> will be thrown.
	 * @return result of inversion
	 */
	public RationalNumber invert() {
		if(numerator.signum() == 0) {
			throw new ArithmeticException();
		}
		return new RationalNumber(denominator, numerator);
	}
	
	
	/**
	 * Tests if this rational number is 0.
	 * @return <code>true</code> if zero
	 */
	public boolean isZero() {
		return denominator.signum() == 0;
	}
	
	/**
	 * Tests if this rational number is negativ.
	 * @return <code>true</code> if negativ
	 */
	public boolean isNegativ() {
		return numerator.signum() < 0;
	}
	

	@Override
	public String toString() {
		return numerator + " / " + denominator;
	}
}
