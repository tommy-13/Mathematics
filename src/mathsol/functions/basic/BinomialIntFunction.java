package mathsol.functions.basic;

public class BinomialIntFunction implements IntegerFunction {
	
	private int     n;
	private int[][] coefficients;
	
	/**
	 * Creates a new <code>BinomialIntFunction</code>.
	 * @param n
	 */
	public BinomialIntFunction(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Negative values are not valid.");
		}
		this.n = n;
		coefficients = new int[n+1][n+1];
		calculateCoefficients();
	}
	
	/**
	 * Calculates and saves all faculties up to <code>lastVal</code> (inclusively).
	 * @param lastVal the last faculty to calculate
	 */
	private void calculateCoefficients() {
		coefficients[0][0] = 1;
		for (int i=1; i<=n; i++) {
			
			coefficients[i][0] = 1;
			coefficients[i][i] = 1;
			
			for (int k=1; k<i; k++) {
				coefficients[i][k] = coefficients[i-1][k-1] + coefficients[i-1][k];
			}
		}
	}
	

	@Override
	public int getYValue(int k) {
		if (k < 0 || k > n) {
			return 0;
		}
		else {
			return coefficients[n][k];
		}
	}

}
