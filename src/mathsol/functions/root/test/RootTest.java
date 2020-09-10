package mathsol.functions.root.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mathsol.functions.basic.DoubleFunction;
import mathsol.functions.basic.LinearFunction;
import mathsol.functions.basic.QuadraticFunction;
import mathsol.functions.root.RootCalculator;
import mathsol.functions.root.SecantRootCalculator;

public class RootTest {
	
	private RootCalculator secantRC;
	private RootCalculator secantRC2;
	
	private DoubleFunction f1 = new LinearFunction(1, -2);
	private DoubleFunction f2 = new QuadraticFunction(1, -1, -6);
	

	@Before
	public void setUpRootCalculators() throws Exception {
		secantRC  = new SecantRootCalculator(f1, 10);
		secantRC2 = new SecantRootCalculator(f2, -3);
	}
	

	@Test
	public void testSecantRootCalculator() {
		assertEquals(0.5, secantRC.getRoot(), 1e-3);
		assertEquals(-2.0, secantRC2.getRoot(), 1e-3);
		secantRC2.setStartingPoint(5);
		assertEquals(3.0, secantRC2.getRoot(), 1e-3);
	}
	
}
