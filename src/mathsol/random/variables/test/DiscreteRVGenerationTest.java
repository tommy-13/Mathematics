package mathsol.random.variables.test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import mathsol.random.variables.DiscreteRandomVariable;
import mathsol.random.variables.PoissonDiscreteRandomVariable;
import mathsol.random.variables.UniformDiscreteRandomVariable;

public class DiscreteRVGenerationTest {

	private static final int NUMBER = 100000;
	
	public static void main(String[] args) {

		DiscreteRandomVariable uniformDiscreteRV = new UniformDiscreteRandomVariable(-1, 2);
		DiscreteRandomVariable poissonDiscreteRV = new PoissonDiscreteRandomVariable(1);
		
		// print the result
		runTest(uniformDiscreteRV);
		runTest(poissonDiscreteRV);
	}
	
	
	public static void runTest(DiscreteRandomVariable rv) {
		int seed = 1;
		rv.setSeed(seed);

		
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
