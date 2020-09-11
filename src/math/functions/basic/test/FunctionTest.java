package math.functions.basic.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import math.functions.basic.BinomialIntFunction;
import math.functions.basic.ConstantFunction;
import math.functions.basic.DoubleFunction;
import math.functions.basic.ExponentialFunction;
import math.functions.basic.FactorialIntFunction;
import math.functions.basic.GaussianDensityFunction;
import math.functions.basic.HyperbelFunction;
import math.functions.basic.IdentityFunction;
import math.functions.basic.IntegerFunction;
import math.functions.basic.LinearFunction;
import math.functions.basic.QuadraticFunction;

public class FunctionTest {

	private DoubleFunction constant;
	private DoubleFunction exponential;
	private DoubleFunction hyperbel;
	private DoubleFunction identity;
	private DoubleFunction linear;
	private DoubleFunction quadratic;
	private DoubleFunction gaussian;
	
	private IntegerFunction factorial;
	private IntegerFunction binomial;

	
	
	@Before
	public void setUpDoubleFunctions() throws Exception {
		constant    = new ConstantFunction(1);
		exponential = new ExponentialFunction(2);
		hyperbel    = new HyperbelFunction(1);
		identity    = new IdentityFunction();
		linear      = new LinearFunction(2, -1);
		quadratic   = new QuadraticFunction(1, 0, -1);
		gaussian    = new GaussianDensityFunction(1, 2);
	}
	
	@Before
	public void setUpIntegerFunctions() throws Exception {
		factorial = new FactorialIntFunction();
		binomial  = new BinomialIntFunction(6);
	}

	
	
	@Test
	public void testDouble() {
		assertEquals(1, constant.getYValue(1), 1e-3);
		assertEquals(1, constant.getYValue(0), 1e-3);
		assertEquals(1, constant.getYValue(-13), 1e-3);

		assertEquals(1/(Math.E*Math.E), exponential.getYValue(-1), 1e-3);
		assertEquals(1, exponential.getYValue(0), 1e-3);
		assertEquals(Math.E, exponential.getYValue(0.5), 1e-3);
		assertEquals(Math.E*Math.E*Math.E, exponential.getYValue(1.5), 1e-3);

		assertEquals(-1, hyperbel.getYValue(0), 1e-3);
		assertEquals(-0.5, hyperbel.getYValue(-1), 1e-3);
		assertEquals(0.1, hyperbel.getYValue(11), 1e-3);

		assertEquals(-2.3, identity.getYValue(-2.3), 1e-3);
		assertEquals(0, identity.getYValue(0), 1e-3);
		assertEquals(1.7, identity.getYValue(1.7), 1e-3);

		assertEquals(3, linear.getYValue(-1), 1e-3);
		assertEquals(2, linear.getYValue(0), 1e-3);
		assertEquals(-0.3, linear.getYValue(2.3), 1e-3);

		assertEquals(3, quadratic.getYValue(-2), 1e-3);
		assertEquals(0, quadratic.getYValue(-1), 1e-3);
		assertEquals(-1, quadratic.getYValue(0), 1e-3);
		assertEquals(0, quadratic.getYValue(1), 1e-3);

		assertEquals(1.0 / (Math.sqrt(4.0*Math.PI)), gaussian.getYValue(1), 1e-3);
		assertEquals(1.0 / (Math.sqrt(4.0*Math.PI) * Math.E), gaussian.getYValue(3), 1e-3);
	}
	
	@Test
	public void testInteger() {
		assertEquals(1, factorial.getYValue(0));
		assertEquals(1, factorial.getYValue(1));
		assertEquals(120, factorial.getYValue(5));
		assertEquals(720, factorial.getYValue(6));

		assertEquals(0, binomial.getYValue(-1));
		assertEquals(1, binomial.getYValue(0));
		assertEquals(6, binomial.getYValue(1));
		assertEquals(20, binomial.getYValue(3));
		assertEquals(1, binomial.getYValue(6));
		assertEquals(0, binomial.getYValue(7));
	}


}
