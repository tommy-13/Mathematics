package mathsol.functions.basic;

import java.util.HashMap;
import java.util.Map;

public class FactorialIntFunction implements IntegerFunction {
	
	private final int PRE_CALC = 5;
	
	private Map<Integer, Integer> numberToFValue;
	private int maxValue = 0;
	
	/**
	 * Creates a new <code>FactorialIntFunction</code> (integer).
	 */
	public FactorialIntFunction() {
		numberToFValue = new HashMap<Integer, Integer>();
		numberToFValue.put(0, 1);
		maxValue = 0;
		calcTo(PRE_CALC);
	}
	
	/**
	 * Calculates and saves all faculties up to <code>lastVal</code> (inclusively).
	 * @param lastVal the last faculty to calculate
	 */
	private void calcTo(int lastVal) {
		for (int i=maxValue+1; i<=lastVal; i++) {
			int next = i * numberToFValue.get(i-1);
			numberToFValue.put(i, next);
		}
		maxValue = lastVal;
	}
	

	@Override
	public int getYValue(int x) {
		if (x < 0) {
			throw new ArithmeticException("Input number is smaller then 0.");
		}
		else {
			if (x > maxValue) {
				calcTo(x);
			}
			return numberToFValue.get(x);
		}
	}

}
