package math.functions.integral.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import math.functions.basic.DoubleFunction;
import math.functions.basic.GaussianDensityFunction;
import math.functions.basic.LinearFunction;
import math.functions.basic.QuadraticFunction;
import math.functions.integral.IntegralCalculator;
import math.functions.integral.MonteCarloIntegralCalculator;
import math.functions.integral.SimpsonRuleIntegralCalculator;
import math.functions.integral.TrapezeRuleIntegralCalculator;

public class IntegralTest {
	
	private final double MONTE_CARLO_ERROR = 0.01;
		
	private IntegralCalculator trapezRuleCalc;
	private IntegralCalculator monteCarloCalc;
	private IntegralCalculator simpsonRuleCalc;
	private DoubleFunction linearF1;
	private DoubleFunction linearF2;
	private DoubleFunction quadraticF1;
	private DoubleFunction gaussian;

	@Before
	public void setUpCalculator() throws Exception {
		trapezRuleCalc = new TrapezeRuleIntegralCalculator();
		trapezRuleCalc.setTolerance(1e-5);
		simpsonRuleCalc = new SimpsonRuleIntegralCalculator();
		simpsonRuleCalc.setTolerance(1e-5);
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
	
	@Before
	public void setUpGaussianFunctions() throws Exception {
		gaussian = new GaussianDensityFunction(0, 1);
	}
	

	@Test
	public void testLinear() {
		// trapez rule
		assertEquals(0.5, trapezRuleCalc.getIntegral(linearF1, 0, 1), 1e-3);
		assertEquals(4, trapezRuleCalc.getIntegral(linearF1, 1, 3), 1e-3);
		assertEquals(0, trapezRuleCalc.getIntegral(linearF1, -1, 1), 1e-3);
		assertEquals(0, trapezRuleCalc.getIntegral(linearF2, 0, 0), 1e-3);
		assertEquals(0.0625 + 0.75, trapezRuleCalc.getIntegral(linearF2, 1, 1.5), 1e-3);
		
		// simpson rule
		assertEquals(0.5, simpsonRuleCalc.getIntegral(linearF1, 0, 1), 1e-3);
		assertEquals(4, simpsonRuleCalc.getIntegral(linearF1, 1, 3), 1e-3);
		assertEquals(0, simpsonRuleCalc.getIntegral(linearF1, -1, 1), 1e-3);
		assertEquals(0, simpsonRuleCalc.getIntegral(linearF2, 0, 0), 1e-3);
		assertEquals(0.0625 + 0.75, simpsonRuleCalc.getIntegral(linearF2, 1, 1.5), 1e-3);
		
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
		
		// simpson rule
		assertEquals(0.333, simpsonRuleCalc.getIntegral(quadraticF1, 0, 1), 1e-3);
		assertEquals(0.667, simpsonRuleCalc.getIntegral(quadraticF1, -1, 1), 1e-3);
		assertEquals(8.667, simpsonRuleCalc.getIntegral(quadraticF1, 1, 3), 1e-3);

		// monte carlo
		assertEquals(0.333, monteCarloCalc.getIntegral(quadraticF1, 0, 1), MONTE_CARLO_ERROR);
		assertEquals(0.667, monteCarloCalc.getIntegral(quadraticF1, -1, 1), MONTE_CARLO_ERROR);
		assertEquals(8.667, monteCarloCalc.getIntegral(quadraticF1, 1, 3), MONTE_CARLO_ERROR);
	}
	
	@Test
	public void testGaussian() {
		double thirdValue = 0.99865-0.84134;
		// trapez rule
		assertEquals(0.34134, trapezRuleCalc.getIntegral(gaussian, 0, 1), 1e-3);
		assertEquals(0.68268, trapezRuleCalc.getIntegral(gaussian, -1, 1), 1e-3);
		assertEquals(thirdValue, trapezRuleCalc.getIntegral(gaussian, 1, 3), 1e-3);
		
		// simpson rule
		assertEquals(0.34134, simpsonRuleCalc.getIntegral(gaussian, 0, 1), 1e-3);
		assertEquals(0.68268, simpsonRuleCalc.getIntegral(gaussian, -1, 1), 1e-3);
		assertEquals(thirdValue, simpsonRuleCalc.getIntegral(gaussian, 1, 3), 1e-3);

		// monte carlo
		assertEquals(0.34134, monteCarloCalc.getIntegral(gaussian, 0, 1), MONTE_CARLO_ERROR);
		assertEquals(0.68268, monteCarloCalc.getIntegral(gaussian, -1, 1), MONTE_CARLO_ERROR);
		assertEquals(thirdValue, monteCarloCalc.getIntegral(gaussian, 1, 3), MONTE_CARLO_ERROR);
	}

}
