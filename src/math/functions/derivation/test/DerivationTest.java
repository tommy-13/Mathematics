package math.functions.derivation.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import math.functions.basic.DoubleFunction;
import math.functions.basic.LinearFunction;
import math.functions.basic.QuadraticFunction;
import math.functions.derivation.DerivationCalculator;
import math.functions.derivation.TwoSidedDerivation;

public class DerivationTest {

	private DerivationCalculator derCalc;
	private DoubleFunction linearF1;
	private DoubleFunction linearF2;
	private DoubleFunction quadraticF1;

	@Before
	public void setUpCalculator() throws Exception {
		derCalc = new TwoSidedDerivation();
		derCalc.setTolerance(1e-5);
	}
	
	@Before
	public void setUpLinearFunctions() throws Exception {
		linearF1 = new LinearFunction(0, 1);
		linearF2 = new LinearFunction(1, 0.5);
	}
	
	@Before
	public void setUpQuadraticFunctions() throws Exception {
		quadraticF1 = new QuadraticFunction(1, 0, 0);
	}
	

	@Test
	public void testLinear() {
		assertEquals(1, derCalc.getDerivation(linearF1, 0), 1e-3);
		assertEquals(1, derCalc.getDerivation(linearF1, 1), 1e-3);
		assertEquals(0.5, derCalc.getDerivation(linearF2, 0), 1e-3);
		assertEquals(0.5, derCalc.getDerivation(linearF2, 1.3), 1e-3);
	}
	
	@Test
	public void testQuadratic() {
		assertEquals(0, derCalc.getDerivation(quadraticF1, 0), 1e-3);
		assertEquals(-2, derCalc.getDerivation(quadraticF1, -1), 1e-3);
		assertEquals(4, derCalc.getDerivation(quadraticF1, 2), 1e-3);
	}


}
