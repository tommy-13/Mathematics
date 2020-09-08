package mathsol.random.variables.estimator.test;

import static org.junit.Assert.*;

import org.junit.Test;

import mathsol.random.variables.continous.GaussianContinousRandomVariable;
import mathsol.random.variables.continous.UniformContinousRandomVariable;
import mathsol.random.variables.discrete.PoissonDiscreteRandomVariable;
import mathsol.random.variables.discrete.UniformDiscreteRandomVariable;
import mathsol.random.variables.estimator.MLEEstimator;

public class MLETest {
	
	private double[] data1 = {1.1};
	private double[] data2 = {1, 3};
	private double[] data3 = {-3, -1};
	private double[] data4 = {0, 1, 2, 3, 4};
	private int[] data5 = {1};
	private int[] data6 = {1,2,3};
	private int[] data7 = {-4,-4};
	
	

	@Test
	public void testUniformDiscrete() {
		UniformDiscreteRandomVariable rv1 = MLEEstimator.estimateUniformDiscreteRV(data5);
		UniformDiscreteRandomVariable rv2 = MLEEstimator.estimateUniformDiscreteRV(data6);
		UniformDiscreteRandomVariable rv3 = MLEEstimator.estimateUniformDiscreteRV(data7);
		
		// probabilities
		assertEquals(1, rv1.getLowerBound(), 1e-3);
		assertEquals(1, rv1.getUpperBound(), 1e-3);
		assertEquals(1, rv2.getLowerBound(), 1e-3);
		assertEquals(3, rv2.getUpperBound(), 1e-3);
		assertEquals(-4, rv3.getLowerBound(), 1e-3);
		assertEquals(-4, rv3.getUpperBound(), 1e-3);
	}
	
	@Test
	public void testPoisson() {
		PoissonDiscreteRandomVariable rv1 = MLEEstimator.estimatePoissonRV(data5);
		PoissonDiscreteRandomVariable rv2 = MLEEstimator.estimatePoissonRV(data6);
		// probabilities
		assertEquals(1.0, rv1.getExpectation(), 1e-3);
		assertEquals(2.0, rv2.getExpectation(), 1e-3);
	}

	
	
	@Test
	public void testContinousUniform() {
		UniformContinousRandomVariable rv1 = MLEEstimator.estimateUniformContinousRV(data1);
		UniformContinousRandomVariable rv2 = MLEEstimator.estimateUniformContinousRV(data2);
		UniformContinousRandomVariable rv3 = MLEEstimator.estimateUniformContinousRV(data3);
		UniformContinousRandomVariable rv4 = MLEEstimator.estimateUniformContinousRV(data4);
		
		// probabilities
		assertEquals(1.1, rv1.getLowerBound(), 1e-3);
		assertEquals(1.1, rv1.getUpperBound(), 1e-3);
		assertEquals(1, rv2.getLowerBound(), 1e-3);
		assertEquals(3, rv2.getUpperBound(), 1e-3);
		assertEquals(-3, rv3.getLowerBound(), 1e-3);
		assertEquals(-1, rv3.getUpperBound(), 1e-3);
		assertEquals(0, rv4.getLowerBound(), 1e-3);
		assertEquals(4, rv4.getUpperBound(), 1e-3);
	}
	
	@Test
	public void testGaussian() {
		GaussianContinousRandomVariable rv2 = MLEEstimator.estimateGaussianRV(data2);
		GaussianContinousRandomVariable rv3 = MLEEstimator.estimateGaussianRV(data3);
		GaussianContinousRandomVariable rv4 = MLEEstimator.estimateGaussianRV(data4);
		
		// probabilities
		assertEquals(2.0, rv2.getExpectation(), 1e-3);
		assertEquals(1.0, rv2.getVariance(), 1e-3);
		assertEquals(-2.0, rv3.getExpectation(), 1e-3);
		assertEquals(1.0, rv3.getVariance(), 1e-3);
		assertEquals(2.0, rv4.getExpectation(), 1e-3);
		assertEquals(2.0, rv4.getVariance(), 1e-3);
	}
	

}
