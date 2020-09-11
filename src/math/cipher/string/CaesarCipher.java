package math.cipher.string;

import math.functions.basic.ModuloFunction;

public class CaesarCipher implements StringCipher {
	
	private int shift, shiftBack;
	
	private int            numberLetters;
	private ModuloFunction modulo;
	
	
	/**
	 * Creates a Caesar Cipher where the letters are shifted by <code>shift</code> positions.
	 * @param shift
	 */
	public CaesarCipher(int shift) {
		this.numberLetters = LetterMap.getInstance().getStandandSize();
		this.modulo        = new ModuloFunction(numberLetters);
		
		this.shift     = modulo.getYValue(shift);
		this.shiftBack = modulo.getYValue(-shift);
	}
	
	
	/**
	 * Returns the shift of this Caesar Cipher.
	 * @return shift
	 */
	public int getShift() {
		return shift;
	}
	
	public int getShiftBack() {
		return shiftBack;
	}
	

	
	@Override
	public String encode(String str) {
		return enDeCode(str, true);
	}

	
	@Override
	public String decode(String str) {
		return enDeCode(str, false);
	}
	
	
	/**
	 * Calculates the encoding / decoding of the input string.
	 * @param str    the string to encode / decode
	 * @param encode true, if the string should be encoded, false otherwise
	 * @return       the encoded / decoded string
	 */
	private String enDeCode(String str, boolean encode) {

		if (str.isEmpty()) {
			return str;
		}
		
		
		LetterMap letterMap = LetterMap.getInstance();
		
		// translate string to integer
		int[] intCodes = new int[str.length()];
		for (int i=0; i<str.length(); i++) {
			String s = str.substring(i, i+1);
			intCodes[i] = letterMap.getStandardNumber(s);
		}
		
		// shift integers
		int currentShift = encode ? shift : shiftBack; 
		for (int i=0; i<intCodes.length; i++) {
			intCodes[i] = modulo.getYValue(intCodes[i] + currentShift);
		}
		
		// translate shifted integers to encoded string
		String result = "";
		for (int i=0; i<intCodes.length; i++) {
			result += letterMap.getStandardString(intCodes[i]);
		}
		
		return result;
	}

}
