package mathsol.random.variables.continous.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mathsol.random.variables.continous.ExponentialContinousRandomVariable;
import mathsol.random.variables.continous.GaussianContinousRandomVariable;
import mathsol.random.variables.continous.TriangleContinousRandomVariable;
import mathsol.random.variables.continous.UniformContinousRandomVariable;

public class ContinousRVTest {
	
	private UniformContinousRandomVariable     uniformContinousRV;
	private ExponentialContinousRandomVariable exponentialContinousRV;
	private GaussianContinousRandomVariable    gaussianContinousRV;
	private TriangleContinousRandomVariable    triangleContinousRV;
	

	@Before
	public void setUpRandomVariables() throws Exception {
		uniformContinousRV     = new UniformContinousRandomVariable(-3, 2);
		exponentialContinousRV = new ExponentialContinousRandomVariable(2);
		gaussianContinousRV    = new GaussianContinousRandomVariable(1, 2);
		triangleContinousRV    = new TriangleContinousRandomVariable(-1, 1, 0);
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


	@Test
	public void testGaussianContinous() {
		// probabilities
		assertEquals(1.0 / (Math.sqrt(2*Math.PI*4)), gaussianContinousRV.getProbabilityMass(1), 1e-3);
		assertEquals(1.0 / (Math.sqrt(2*Math.PI*4)*Math.E*Math.E), gaussianContinousRV.getProbabilityMass(5), 1e-3);
		
		// cumulative probabilities
		assertEquals(0.3085, gaussianContinousRV.getCumulativeProbabilityMass(0), 1e-3);
		assertEquals(0.5, gaussianContinousRV.getCumulativeProbabilityMass(1), 1e-3);
		assertEquals(0.6915, gaussianContinousRV.getCumulativeProbabilityMass(2), 1e-3);

		// expectation
		assertEquals(1, gaussianContinousRV.getExpectation(), 1e-3);
		
		// variance
		assertEquals(4, gaussianContinousRV.getVariance(), 1e-3);
	}
	

	@Test
	public void testTriangleContinous() {
		// probabilities
		assertEquals(0.0, triangleContinousRV.getProbabilityMass(-1.1), 1e-3);
		assertEquals(0.5, triangleContinousRV.getProbabilityMass(-0.5), 1e-3);
		assertEquals(1.0, triangleContinousRV.getProbabilityMass(0.0), 1e-3);
		assertEquals(0.2, triangleContinousRV.getProbabilityMass(0.8), 1e-3);
		assertEquals(0.0, triangleContinousRV.getProbabilityMass(1.0), 1e-3);
		
		// cumulative probabilities
		assertEquals(0.0, triangleContinousRV.getCumulativeProbabilityMass(-1.1), 1e-3);
		assertEquals(0.125, triangleContinousRV.getCumulativeProbabilityMass(-0.5), 1e-3);
		assertEquals(0.5, triangleContinousRV.getCumulativeProbabilityMass(0.0), 1e-3);
		assertEquals(0.98, triangleContinousRV.getCumulativeProbabilityMass(0.8), 1e-3);
		assertEquals(1.0, triangleContinousRV.getCumulativeProbabilityMass(1.0), 1e-3);

		// expectation
		assertEquals(0, triangleContinousRV.getExpectation(), 1e-3);
		
		// variance
		assertEquals(1.0/6.0, triangleContinousRV.getVariance(), 1e-3);
	}
}
