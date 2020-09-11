package math.random.variables.estimator;

import math.random.variables.continous.GaussianContinousRandomVariable;
import math.random.variables.continous.UniformContinousRandomVariable;
import math.random.variables.discrete.PoissonDiscreteRandomVariable;
import math.random.variables.discrete.UniformDiscreteRandomVariable;

/**
 * Maximum likelihood estimators for random variables
 * @author tommy
 *
 */
public class MLEEstimator {

	
	// ******************************************************* //
	// ******************* HELPER *}************************** //
	// ******************************************************* //
	
	
	/**
	 * Calculates the mean value of data sample.
	 * @param data data set
	 * @return mean value
	 */
	private static double getMean(double[] data) {
		double sum = 0.0;
		for (int i=0; i<data.length; i++) {
			sum += data[i];
		}
		return sum / data.length;
	}
	
	/**
	 * Calculates the variance of the data sample.
	 * @param data data set
	 * @return variance
	 */
	private static double getDataVariance(double[] data) {
		double mean = getMean(data);
		double sum  = 0.0;
		for (int i=0; i<data.length; i++) {
			sum += (data[i] - mean) * (data[i] - mean); 
		}
		return sum / data.length;
	}
	
	
	/**
	 * Calculates the minimum and maximum of the given data set.
	 * @param data data set
	 * @return [minimum, maximum]
	 */
	private static double[] getMinMax(double[] data) {
		double min 	 = data[0];
		double max 	 = data[0];
		int    start = 1;
		
		if(data.length % 2 == 0) {
			// even length
			if(data[1] >= data[0]) {
				max = data[1];
			}
			else {
				min = data[1];
			}
			start	= 2;
		}
		
		for(int i=start; i<data.length; i=i+2) {
			// compare two successive array elements
			if(data[i] < data[i+1]) {
				min = data[i] < min ? data[i] : min;
				max = data[i+1] > max ? data[i+1] : max;
			}
			else {
				min = data[i+1] < min ? data[i+1] : min;
				max = data[i] > max ? data[i] : max;
			}
		}
		
		return new double[] {min, max};
	}
	
	
	
	
	// ******************************************************* //
	// ******************* DISCRETE ************************** //
	// ******************************************************* //
	
	
	/**
	 * Estimates a random variable with poisson distribution.
	 * @param data poisson-distributed data
	 * @return random variable with poisson distribution
	 */
	public static PoissonDiscreteRandomVariable estimatePoissonRV(int[] data) {
		
		if (data == null) {
			throw new IllegalArgumentException("The input array is null.");
		}		
		if (data.length == 0) {
			throw new IllegalArgumentException("The input array is empty.");
		}
		
		double[] dData = new double[data.length];
		for (int i=0; i<data.length; i++) {
			if (data[i] < 0) {
				throw new IllegalArgumentException("All input data must be at least 0.");
			}
			dData[i] = (double) data[i];
		}
		
		double lambda = getMean(dData);
				
		PoissonDiscreteRandomVariable poissonRV = new PoissonDiscreteRandomVariable(lambda);
		return poissonRV;
	}
	

	/**
	 * Estimates a random variable with discrete uniform distribution.
	 * @param data uniform-distributed data
	 * @return random variable with uniform distribution
	 */
	public static UniformDiscreteRandomVariable estimateUniformDiscreteRV(int[] data) {
		
		if (data == null) {
			throw new IllegalArgumentException("The input array is null.");
		}		
		if (data.length == 0) {
			throw new IllegalArgumentException("The input array is empty.");
		}
		

		double[] dData = new double[data.length];
		for (int i=0; i<data.length; i++) {
			dData[i] = (double) data[i];
		}
		
		
		double[] minMax = getMinMax(dData);
		int      min    = (int) minMax[0];
		int      max    = (int) minMax[1];
		
		UniformDiscreteRandomVariable uniformRV = new UniformDiscreteRandomVariable(min, max);
		return uniformRV;
	}
	

	
	
	
	// ******************************************************* //
	// ******************* CONTINOUS ************************* //
	// ******************************************************* //
	
	
	/**
	 * Estimates a random variable with gaussion distribution.
	 * @param data gaussian-distributed data
	 * @return random variable with gaussian distribution
	 */
	public static GaussianContinousRandomVariable estimateGaussianRV(double[] data) {
		
		if (data == null) {
			throw new IllegalArgumentException("The input array is null.");
		}		
		if (data.length == 0) {
			throw new IllegalArgumentException("The input array is empty.");
		}
		if (data.length == 1) {
			throw new IllegalArgumentException("For this distribution at least two sample points are needed.");
		}
		
		double mu  = getMean(data);
		double var = getDataVariance(data);
		
		GaussianContinousRandomVariable gaussianRV = new GaussianContinousRandomVariable(mu, Math.sqrt(var));
		return gaussianRV;
	}

	
	/**
	 * Estimates a random variable with discrete uniform distribution.
	 * @param data uniform-distributed data
	 * @return random variable with uniform distribution
	 */
	public static UniformContinousRandomVariable estimateUniformContinousRV(double[] data) {
		
		if (data == null) {
			throw new IllegalArgumentException("The input array is null.");
		}		
		if (data.length == 0) {
			throw new IllegalArgumentException("The input array is empty.");
		}
		
		double[] minMax = getMinMax(data);
		double   min    = minMax[0];
		double   max    = minMax[1];
		
		UniformContinousRandomVariable uniformRV = new UniformContinousRandomVariable(min, max);
		return uniformRV;
	}
	
}
