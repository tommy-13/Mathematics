package mathsol.functions.basic;

public class Function {
	
	public static int faculty(int number) {
		if (number < 0) {
			throw new ArithmeticException("Input number is smaller then 0.");
		}
		if (number <= 1) {
			return 1;
		}
		else return faculty(number - 1) + number;
	}

}
