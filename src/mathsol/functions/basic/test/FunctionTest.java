package mathsol.functions.basic.test;

import static org.junit.Assert.*;

import mathsol.functions.basic.ConstantFunction;
import mathsol.functions.basic.DoubleFunction;
import mathsol.functions.basic.ExponentialFunction;
import mathsol.functions.basic.FactorialIntFunction;
import mathsol.functions.basic.HyperbelFunction;
import mathsol.functions.basic.IdentityFunction;
import mathsol.functions.basic.IntegerFunction;
import mathsol.functions.basic.LinearFunction;
import mathsol.functions.basic.QuadraticFunction;
import org.junit.Before;
import org.junit.Test;

public class FunctionTest {

	private DoubleFunction constant;
	private DoubleFunction exponential;
	private DoubleFunction hyperbel;
	private DoubleFunction identity;
	private DoubleFunction linear;
	private DoubleFunction quadratic;
	
	private IntegerFunction factorial;

	
	
	@Before
	public void setUpDoubleFunctions() throws Exception {
		constant    = new ConstantFunction(1);
		exponential = new ExponentialFunction(2);
		hyperbel    = new HyperbelFunction(1);
		identity    = new IdentityFunction();
		linear      = new LinearFunction(2, -1);
		quadratic   = new QuadraticFunction(1, 0, -1);
	}
	
	@Before
	public void setUpIntegerFunctions() throws Exception {
		factorial = new FactorialIntFunction();
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
	}
	
	@Test
	public void testInteger() {
		assertEquals(1, factorial.getYValue(0), 1e-3);
		assertEquals(1, factorial.getYValue(1), 1e-3);
		assertEquals(120, factorial.getYValue(5), 1e-3);
		assertEquals(720, factorial.getYValue(6), 1e-3);
	}


}
