package mathsol.random.variables.test;

import static org.junit.Assert.*;

import mathsol.random.variables.PoissonDiscreteRandomVariable;
import mathsol.random.variables.UniformDiscreteRandomVariable;

import org.junit.Before;
import org.junit.Test;

public class DiscreteRVTest {
	
	private UniformDiscreteRandomVariable uniformDiscreteRV;
	private PoissonDiscreteRandomVariable poissonDiscreteRV;

	@Before
	public void setUpRandomVariables() throws Exception {
		uniformDiscreteRV = new UniformDiscreteRandomVariable(-1, 2);
		poissonDiscreteRV = new PoissonDiscreteRandomVariable(1);
	}
	

	@Test
	public void testUniformDiscrete() {
		// probabilities
		assertEquals(0.25, uniformDiscreteRV.getProbability(0), 1e-3);
		assertEquals(0.25, uniformDiscreteRV.getProbability(-1), 1e-3);
		assertEquals(0.25, uniformDiscreteRV.getProbability(2), 1e-3);
		assertEquals(0, uniformDiscreteRV.getProbability(-2), 1e-3);
		assertEquals(0, uniformDiscreteRV.getProbability(3), 1e-3);
		
		// cumulative probabilities
		assertEquals(0.5, uniformDiscreteRV.getCumulativeProbability(0), 1e-3);
		assertEquals(0.25, uniformDiscreteRV.getCumulativeProbability(-1), 1e-3);
		assertEquals(1, uniformDiscreteRV.getCumulativeProbability(2), 1e-3);
		assertEquals(0, uniformDiscreteRV.getCumulativeProbability(-2), 1e-3);
		assertEquals(1, uniformDiscreteRV.getCumulativeProbability(3), 1e-3);

		// expectation
		assertEquals(0.5, uniformDiscreteRV.getExpectation(), 1e-3);
		
		// variance
		assertEquals(0.33333, uniformDiscreteRV.getVariance(), 1e-3);
	}
	
	@Test
	public void testPoisson() {
		// probabilities
		assertEquals(0.36788, poissonDiscreteRV.getProbability(0), 1e-3);
		assertEquals(0.36788, poissonDiscreteRV.getProbability(1), 1e-3);
		assertEquals(0.18394, poissonDiscreteRV.getProbability(2), 1e-3);
		assertEquals(0.06131, poissonDiscreteRV.getProbability(3), 1e-3);
		assertEquals(0, poissonDiscreteRV.getProbability(-1), 1e-3);
		
		// cumulative probabilities
		assertEquals(0.36788, poissonDiscreteRV.getCumulativeProbability(0), 1e-3);
		assertEquals(0.73576, poissonDiscreteRV.getCumulativeProbability(1), 1e-3);
		assertEquals(0.9197, poissonDiscreteRV.getCumulativeProbability(2), 1e-3);
		assertEquals(0.98101, poissonDiscreteRV.getCumulativeProbability(3), 1e-3);
		assertEquals(0, poissonDiscreteRV.getCumulativeProbability(-1), 1e-3);

		// expectation
		assertEquals(1, poissonDiscreteRV.getExpectation(), 1e-3);
		
		// variance
		assertEquals(1, poissonDiscreteRV.getVariance(), 1e-3);
	}

}
