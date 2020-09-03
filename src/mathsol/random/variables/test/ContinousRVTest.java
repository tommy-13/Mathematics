package mathsol.random.variables.test;

import static org.junit.Assert.*;

import mathsol.random.variables.ExponentialContinousRandomVariable;
import mathsol.random.variables.UniformContinousRandomVariable;
import org.junit.Before;
import org.junit.Test;

public class ContinousRVTest {
	
	private UniformContinousRandomVariable uniformContinousRV;
	private ExponentialContinousRandomVariable exponentialContinousRV;
	

	@Before
	public void setUpRandomVariables() throws Exception {
		uniformContinousRV = new UniformContinousRandomVariable(-3, 2);
		exponentialContinousRV = new ExponentialContinousRandomVariable(2);
	}
	

	@Test
	public void testUniformContinous() {
		// probabilities
		assertEquals(0.2, uniformContinousRV.getProbabilityMass(0), 1e-3);
		assertEquals(0.2, uniformContinousRV.getProbabilityMass(-3), 1e-3);
		assertEquals(0.2, uniformContinousRV.getProbabilityMass(2), 1e-3);
		assertEquals(0, uniformContinousRV.getProbabilityMass(-3.1), 1e-3);
		assertEquals(0, uniformContinousRV.getProbabilityMass(2.05), 1e-3);
		
		// cumulative probabilities
		assertEquals(0, uniformContinousRV.getCumulativeProbabilityMass(-3), 1e-3);
		assertEquals(0.4, uniformContinousRV.getCumulativeProbabilityMass(-1), 1e-3);
		assertEquals(0.6, uniformContinousRV.getCumulativeProbabilityMass(0), 1e-3);
		assertEquals(1, uniformContinousRV.getCumulativeProbabilityMass(2), 1e-3);
		assertEquals(1, uniformContinousRV.getCumulativeProbabilityMass(2.2), 1e-3);

		// expectation
		assertEquals(-0.5, uniformContinousRV.getExpectation(), 1e-3);
		
		// variance
		assertEquals(25.0/12.0, uniformContinousRV.getVariance(), 1e-3);
	}

	

	@Test
	public void testExponentialContinous() {
		// probabilities
		assertEquals(2.0, exponentialContinousRV.getProbabilityMass(0), 1e-3);
		assertEquals(2.0/Math.E, exponentialContinousRV.getProbabilityMass(0.5), 1e-3);
		assertEquals(2.0/(Math.E*Math.E), exponentialContinousRV.getProbabilityMass(1), 1e-3);
		
		// cumulative probabilities
		assertEquals(0, exponentialContinousRV.getCumulativeProbabilityMass(0), 1e-3);
		assertEquals(1-1.0/Math.E, exponentialContinousRV.getCumulativeProbabilityMass(0.5), 1e-3);
		assertEquals(1-1.0/(Math.E*Math.E), exponentialContinousRV.getCumulativeProbabilityMass(1), 1e-3);

		// expectation
		assertEquals(0.5, exponentialContinousRV.getExpectation(), 1e-3);
		
		// variance
		assertEquals(0.25, exponentialContinousRV.getVariance(), 1e-3);
	}
	
}
