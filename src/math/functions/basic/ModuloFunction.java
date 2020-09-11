package math.functions.basic;

public class ModuloFunction implements IntegerFunction {

	private int modul;
	
	/**
	 * Creates a new <code>FactorialIntFunction</code> (integer).
	 */
	public ModuloFunction(int modul) {
		setModul(modul);
	}
	

	public int getModul() {
		return modul;
	}
	
	public void setModul(int modul) {
		if (modul <= 0) {
			throw new IllegalArgumentException("The modul must be a positive integer.");
		}
		this.modul = modul;
	}
	

	@Override
	public int getYValue(int x) {
		int y = x % modul; // y might be negative due to the calculation of % -> correct it
		return (y + modul) % modul;
	}

}
