package mathsol.random.variables;

import java.util.HashMap;
import java.util.Map;

public class PoissonDiscreteRandomVariable extends DiscreteRandomVariable {

	private double lambda;
	
	/**
	 * Creates a new poisson distributed random variable with parameter <code>lambda</code>.
	 * @param lambda
	 */
	public PoissonDiscreteRandomVariable(int lambda) {
		this.name = "discrete poisson";
		this.lambda = lambda;
	}
	
	/**
	 * Returns the parameter lambda of this distribution.
	 * @return lambda
	 */
	public double getLambda() {
		return lambda;
	}
	
	
	
	
	@Override
	public double getExpectation() {
		return lambda;
	}

	@Override
	public double getVariance() {
		return lambda;
	}
	
	@Override
	public double getProbability(int x) {
		if(x < 0) {
			return 0;
		}
		else {
			return getProbHelper(x);
		}
	}
	
	private int maxCalc = -1;
	private Map<Integer, Double> probValues = new HashMap<Integer, Double>();
	private double getProbHelper(int x) {
		// assume x is at least 0
		if (x <= maxCalc) {
			return probValues.get(x);
		}
		else {
			if (maxCalc == -1) {
				probValues.put(0, Math.exp(-lambda));
				maxCalc = 0;
			}
			double current = probValues.get(maxCalc);
			for (int i=maxCalc+1; i<=x; i++) {
				current = current * lambda / i;
				probValues.put(i, current);
			}
			maxCalc = x;
			return current;
		}
	}
	
	
	@Override
	public double getCumulativeProbability(int x) {
		if(x < 0) {
			return 0;
		}
		else {
			double sum = 0;
			for (int i=0; i<=x; i++) {
				sum += getProbability(i);
			}
			return sum;
		}
	}

	@Override
	public int getRandomValue() {
		// create variable using inversion
		double rand = randomGenerator.nextDouble();
		int counter = 0;
		while (rand > getCumulativeProbability(counter)) {
			counter++;
		}
		return counter;
	}

}
