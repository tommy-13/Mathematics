package mathsol.random.variables.discrete.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mathsol.random.variables.discrete.BernoulliDiscreteRandomVariable;
import mathsol.random.variables.discrete.BinomialDiscreteRandomVariable;
import mathsol.random.variables.discrete.DiscreteRandomVariable;
import mathsol.random.variables.discrete.GeometricDiscreteRandomVariable;
import mathsol.random.variables.discrete.NegativeBinomialDiscreteRandomVariable;
import mathsol.random.variables.discrete.PoissonDiscreteRandomVariable;
import mathsol.random.variables.discrete.UniformDiscreteRandomVariable;

public class DiscreteRVTest {
	
	private DiscreteRandomVariable uniformDiscreteRV;
	private DiscreteRandomVariable poissonDiscreteRV;
	private DiscreteRandomVariable bernoulliDiscreteRV;
	private DiscreteRandomVariable binomialDiscreteRV;
	private DiscreteRandomVariable geometricDiscreteRV;
	private DiscreteRandomVariable negativeBinomialDiscreteRV;

	@Before
	public void setUpRandomVariables() throws Exception {
		uniformDiscreteRV          = new UniformDiscreteRandomVariable(-1, 2);
		poissonDiscreteRV          = new PoissonDiscreteRandomVariable(1);
		bernoulliDiscreteRV        = new BernoulliDiscreteRandomVariable(0.4);
		binomialDiscreteRV         = new BinomialDiscreteRandomVariable(5, 0.2);
		geometricDiscreteRV        = new GeometricDiscreteRandomVariable(0.1);
		negativeBinomialDiscreteRV = new NegativeBinomialDiscreteRandomVariable(0.2, 10);
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

	
	@Test
	public void testBernoulli() {
		// probabilities
		assertEquals(0.6, bernoulliDiscreteRV.getProbability(0), 1e-3);
		assertEquals(0.4, bernoulliDiscreteRV.getProbability(1), 1e-3);
		assertEquals(0.0, bernoulliDiscreteRV.getProbability(2), 1e-3);
		assertEquals(0.0, bernoulliDiscreteRV.getProbability(-1), 1e-3);
		
		// cumulative probabilities
		assertEquals(0.0, bernoulliDiscreteRV.getCumulativeProbability(-1), 1e-3);
		assertEquals(0.6, bernoulliDiscreteRV.getCumulativeProbability(0), 1e-3);
		assertEquals(1.0, bernoulliDiscreteRV.getCumulativeProbability(1), 1e-3);
		assertEquals(1.0, bernoulliDiscreteRV.getCumulativeProbability(2), 1e-3);

		// expectation
		assertEquals(0.4, bernoulliDiscreteRV.getExpectation(), 1e-3);
		
		// variance
		assertEquals(0.24, bernoulliDiscreteRV.getVariance(), 1e-3);
	}
	
	@Test
	public void testBinomial() {
		// probabilities
		assertEquals(0.0, binomialDiscreteRV.getProbability(-1), 1e-3);
		assertEquals(0.32768, binomialDiscreteRV.getProbability(0), 1e-3);
		assertEquals(0.4096, binomialDiscreteRV.getProbability(1), 1e-3);
		assertEquals(0.2048, binomialDiscreteRV.getProbability(2), 1e-3);
		assertEquals(0.0512, binomialDiscreteRV.getProbability(3), 1e-3);
		assertEquals(0.0064, binomialDiscreteRV.getProbability(4), 1e-3);
		assertEquals(0.00032, binomialDiscreteRV.getProbability(5), 1e-3);
		assertEquals(0.0, binomialDiscreteRV.getProbability(6), 1e-3);
		
		// cumulative probabilities
		assertEquals(0.0, binomialDiscreteRV.getCumulativeProbability(-1), 1e-3);
		assertEquals(0.32768, binomialDiscreteRV.getCumulativeProbability(0), 1e-3);
		assertEquals(0.73728, binomialDiscreteRV.getCumulativeProbability(1), 1e-3);
		assertEquals(0.94208, binomialDiscreteRV.getCumulativeProbability(2), 1e-3);
		assertEquals(1.0, binomialDiscreteRV.getCumulativeProbability(5), 1e-3);
		assertEquals(1.0, binomialDiscreteRV.getCumulativeProbability(6), 1e-3);

		// expectation
		assertEquals(1, binomialDiscreteRV.getExpectation(), 1e-3);
		
		// variance
		assertEquals(0.8, binomialDiscreteRV.getVariance(), 1e-3);
	}
	

	
	@Test
	public void testGeometric() {
		// probabilities
		assertEquals(0.0, geometricDiscreteRV.getProbability(0), 1e-3);
		assertEquals(0.1, geometricDiscreteRV.getProbability(1), 1e-3);
		assertEquals(0.09, geometricDiscreteRV.getProbability(2), 1e-3);
		assertEquals(0.081, geometricDiscreteRV.getProbability(3), 1e-3);
		
		// cumulative probabilities
		assertEquals(0.0, geometricDiscreteRV.getCumulativeProbability(0), 1e-3);
		assertEquals(0.1, geometricDiscreteRV.getCumulativeProbability(1), 1e-3);
		assertEquals(0.19, geometricDiscreteRV.getCumulativeProbability(2), 1e-3);
		assertEquals(0.271, geometricDiscreteRV.getCumulativeProbability(3), 1e-3);

		// expectation
		assertEquals(10, geometricDiscreteRV.getExpectation(), 1e-3);
		
		// variance
		assertEquals(90, geometricDiscreteRV.getVariance(), 1e-3);
	}
	
	@Test
	public void testNegativeBinomial() {
		// probabilities
		assertEquals(0.0, negativeBinomialDiscreteRV.getProbability(9), 1e-3);
		assertEquals(Math.pow(0.2, 10), negativeBinomialDiscreteRV.getProbability(10), 1e-3);
		assertEquals(0.001016, negativeBinomialDiscreteRV.getProbability(20), 1e-3);
		assertEquals(0.0118, negativeBinomialDiscreteRV.getProbability(30), 1e-3);
		
		// cumulative probabilities
		assertEquals(0.0, negativeBinomialDiscreteRV.getCumulativeProbability(9), 1e-3);
		assertEquals(Math.pow(0.2, 10), negativeBinomialDiscreteRV.getCumulativeProbability(10), 1e-3);
		assertEquals(Math.pow(0.2, 10) + Math.pow(0.2, 11), negativeBinomialDiscreteRV.getCumulativeProbability(11), 1e-3);

		// expectation
		assertEquals(50, negativeBinomialDiscreteRV.getExpectation(), 1e-3);
		
		// variance
		assertEquals(200, negativeBinomialDiscreteRV.getVariance(), 1e-3);
	}
}
