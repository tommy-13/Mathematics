package math.number.rational.test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;

import math.number.rational.RationalNumber;

public class RationalNumberTest {
	
	private RationalNumber rn1;
	private RationalNumber rn2;
	private RationalNumber rn3;
	

	@Before
	public void setUp() throws Exception {
		rn1 = new RationalNumber(3,2);
		rn2 = new RationalNumber(6,5);
		rn3 = new RationalNumber(-10, 100);
	}

	@Test
	public void test() {
		System.out.println("rn1:" + rn1.toString());
		System.out.println("rn2:" + rn2.toString());
		System.out.println("rn3:" + rn3.toString());
		
		RationalNumber rn = rn1.multiply(rn2);
		System.out.println("mul:" + rn.toString());
		assertEquals(BigInteger.valueOf(9), rn.getNumerator());
		assertEquals(BigInteger.valueOf(5), rn.getDenominator());
		
		rn = rn1.divide(rn2);
		System.out.println("div: " + rn.toString());
		assertEquals(BigInteger.valueOf(5), rn.getNumerator());
		assertEquals(BigInteger.valueOf(4), rn.getDenominator());
		
		rn = rn1.divide(rn3);
		System.out.println("div: " + rn.toString());
		assertEquals(BigInteger.valueOf(-15), rn.getNumerator());
		assertEquals(BigInteger.valueOf(1), rn.getDenominator());

		rn = rn1.add(rn2);
		System.out.println("add: " + rn.toString());
		assertEquals(BigInteger.valueOf(27), rn.getNumerator());
		assertEquals(BigInteger.valueOf(10), rn.getDenominator());

		rn = rn1.add(rn3);
		System.out.println("add: " + rn.toString());
		assertEquals(BigInteger.valueOf(-7), rn.getNumerator());
		assertEquals(BigInteger.valueOf(5), rn.getDenominator());
		
	}

}
