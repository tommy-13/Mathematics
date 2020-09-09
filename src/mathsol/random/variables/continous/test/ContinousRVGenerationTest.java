package mathsol.random.variables.continous.test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import mathsol.random.variables.continous.ContinousRandomVariable;
import mathsol.random.variables.continous.GaussianContinousRandomVariable;
import mathsol.random.variables.continous.TriangleContinousRandomVariable;
import mathsol.random.variables.continous.UniformContinousRandomVariable;

public class ContinousRVGenerationTest {

	private static final int NUMBER = 100000;
	private static final int SEED   = 1;
	
	
	public static void main(String[] args) {
		
		ContinousRandomVariable[] randomVariables = {
				new UniformContinousRandomVariable(-1, 2),
				new GaussianContinousRandomVariable(0, 1),
				new GaussianContinousRandomVariable(1, 2),
				new TriangleContinousRandomVariable(0, 10, 8)
		};
		
		for (ContinousRandomVariable rv : randomVariables) {
			runTest(rv);
		}
	}
	
	
	private static void runTest(ContinousRandomVariable rv) {
		rv.setSeed(SEED);

		
		NumberFormat formatter = new DecimalFormat("#0.0000");
		
		
		// create many random values and check if the data correspond (approximately) to the distribution
		// in order to do this, save the number of occurences for unit intervals (= size 1 intervals)
		Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
		// also save the real probabilities
		Map<Integer, Double> probabilities = new HashMap<Integer, Double>();
		
		for (int i=0; i<NUMBER; i++) {
			double value = rv.getRandomValue();
			int    box   = getInterval(value);
			
			counter.put(box, counter.containsKey(box) ? counter.get(box)+1 : 1);
			
			if (!probabilities.containsKey(box)) {
				double prob = rv.getCumulativeProbabilityMass(box + 1) - rv.getCumulativeProbabilityMass(box);
				probabilities.put(box, prob);
			}
		}
		
		// print the result
		String str = "Result of " + rv.getName() + "\n";
		for (Entry<Integer, Integer> entry : counter.entrySet()) {
			str += entry.getKey() + " to " + (entry.getKey()+1) + ": \t";
			str += entry.getValue() + "\t - prob: " + formatter.format(((double) entry.getValue()) / NUMBER) + " ";
			str += "\t compared to actual prob: \t" + formatter.format(probabilities.get(entry.getKey())) + "\n";
		}
		str += "\n";
		System.out.println(str);
	}
	
	private static int getInterval(double value) {
		return (int) Math.floor(value);
	}
	
}
