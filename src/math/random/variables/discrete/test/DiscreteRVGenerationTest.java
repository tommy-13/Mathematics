package math.random.variables.discrete.test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import math.random.variables.discrete.BernoulliDiscreteRandomVariable;
import math.random.variables.discrete.BinomialDiscreteRandomVariable;
import math.random.variables.discrete.DiscreteRandomVariable;
import math.random.variables.discrete.GeometricDiscreteRandomVariable;
import math.random.variables.discrete.NegativeBinomialDiscreteRandomVariable;
import math.random.variables.discrete.PoissonDiscreteRandomVariable;
import math.random.variables.discrete.UniformDiscreteRandomVariable;

public class DiscreteRVGenerationTest {

	private static final int NUMBER = 100000;
	private static final int SEED   = 1;
	
	
	public static void main(String[] args) {
		
		DiscreteRandomVariable[] randomVariables = {
				new UniformDiscreteRandomVariable(-1, 2),
				new PoissonDiscreteRandomVariable(1),
				new BernoulliDiscreteRandomVariable(0.8),
				new BinomialDiscreteRandomVariable(7, 0.5),
				new GeometricDiscreteRandomVariable(0.5),
				new NegativeBinomialDiscreteRandomVariable(0.8,5)
		};
		
		for (DiscreteRandomVariable rv : randomVariables) {
			runTest(rv);
		}
	}
	
	
	private static void runTest(DiscreteRandomVariable rv) {
		rv.setSeed(SEED);

		
		NumberFormat formatter = new DecimalFormat("#0.0000");
		
		
		// create many random values and check if the data correspond (approximately) to the distribution
		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
		
		for (int i=0; i<NUMBER; i++) {
			int value = rv.getRandomValue();
			counter.put(value, counter.containsKey(value) ? counter.get(value)+1 : 1);
		}
		
		// print the result
		String str = "Result of " + rv.getName() + "\n";
		for (Entry<Integer, Integer> entry : counter.entrySet()) {
			str += entry.getKey() + ": \t";
			str += entry.getValue() + "\t - prob: " + formatter.format(((double) entry.getValue()) / NUMBER) + " ";
			str += "\t compared to actual prob: \t" + formatter.format(rv.getProbability(entry.getKey())) + "\n";
		}
		str += "\n";
		System.out.println(str);
	}
	
}
