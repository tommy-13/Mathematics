package mathsol.functions.root;

import mathsol.functions.basic.DoubleFunction;

public class SecantRootCalculator extends RootCalculator {
	
	private final int MAX_STEPS = 10000;
	
	public SecantRootCalculator(DoubleFunction f, double startingPoint) {
		super(f, startingPoint);
	}
	

	@Override
	public double getRoot() {
		
		double x1 = start;
		double x0 = x1 - Math.max(0.1, tolerance + 1);
		
		int step = 0;
		while (step < MAX_STEPS && Math.abs(x1 - x0) > tolerance) {
			step++;
			
			double x2 = f.getYValue(x1) - f.getYValue(x0);
			if (x2 == 0) {
				return Double.POSITIVE_INFINITY;
			}
			
			x2 = x1 - f.getYValue(x1) * (x1 - x0) / x2;
			
			x0 = x1;
			x1 = x2;
		}
		
		if (step >= MAX_STEPS) {
			return Double.POSITIVE_INFINITY;
		}
		
		return x1;
	}
	
}

