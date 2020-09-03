package mathsol.functions.integral.test;

import static org.junit.Assert.*;

import mathsol.functions.basic.DoubleFunction;
import mathsol.functions.basic.LinearFunction;
import mathsol.functions.basic.QuadraticFunction;
import mathsol.functions.integral.IntegralCalculator;
import mathsol.functions.integral.MonteCarloIntegralCalculator;
import mathsol.functions.integral.TrapezeRuleIntegralCalculator;

import org.junit.Before;
import org.junit.Test;

public class IntegralTest {
	
	private final double MONTE_CARLO_ERROR = 0.01;
	
	
	private IntegralCalculator trapezRuleCalc;
	private IntegralCalculator monteCarloCalc;
	private DoubleFunction linearF1;
	private DoubleFunction linearF2;
	private DoubleFunction quadraticF1;

	@Before
	public void setUpCalculator() throws Exception {
		trapezRuleCalc = new TrapezeRuleIntegralCalculator();
		trapezRuleCalc.setTolerance(1e-5);
		monteCarloCalc = new MonteCarloIntegralCalculator();
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
		// trapez rule
		assertEquals(0.5, trapezRuleCalc.getIntegral(linearF1, 0, 1), 1e-3);
		assertEquals(4, trapezRuleCalc.getIntegral(linearF1, 1, 3), 1e-3);
		assertEquals(0, trapezRuleCalc.getIntegral(linearF1, -1, 1), 1e-3);
		assertEquals(0, trapezRuleCalc.getIntegral(linearF2, 0, 0), 1e-3);
		assertEquals(0.0625 + 0.75, trapezRuleCalc.getIntegral(linearF2, 1, 1.5), 1e-3);
		
		// monte carlo
		assertEquals(0.5, monteCarloCalc.getIntegral(linearF1, 0, 1), MONTE_CARLO_ERROR);
		assertEquals(4, monteCarloCalc.getIntegral(linearF1, 1, 3), MONTE_CARLO_ERROR);
		assertEquals(0, monteCarloCalc.getIntegral(linearF1, -1, 1), MONTE_CARLO_ERROR);
		assertEquals(0, monteCarloCalc.getIntegral(linearF2, 0, 0), MONTE_CARLO_ERROR);
		assertEquals(0.0625 + 0.75, monteCarloCalc.getIntegral(linearF2, 1, 1.5), MONTE_CARLO_ERROR);
	}
	
	@Test
	public void testQuadratic() {
		// trapez rule
		assertEquals(0.333, trapezRuleCalc.getIntegral(quadraticF1, 0, 1), 1e-3);
		assertEquals(0.667, trapezRuleCalc.getIntegral(quadraticF1, -1, 1), 1e-3);
		assertEquals(8.667, trapezRuleCalc.getIntegral(quadraticF1, 1, 3), 1e-3);

		// monte carlo
		assertEquals(0.333, monteCarloCalc.getIntegral(quadraticF1, 0, 1), MONTE_CARLO_ERROR);
		assertEquals(0.667, monteCarloCalc.getIntegral(quadraticF1, -1, 1), MONTE_CARLO_ERROR);
		assertEquals(8.667, monteCarloCalc.getIntegral(quadraticF1, 1, 3), MONTE_CARLO_ERROR);
	}

}
