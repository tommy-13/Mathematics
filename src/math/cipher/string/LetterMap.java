package math.cipher.string;

import java.util.HashMap;
import java.util.Map;

public class LetterMap {
	
	// implement the Singleton Pattern
	private static LetterMap uniqueInstance = new LetterMap();
	public static LetterMap getInstance() {
		return uniqueInstance;
	}
	
	
	
	private String[] chars = {
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",	"M",
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

	
	private Map<String, Integer> standardStr2Number = new HashMap<String, Integer>();
	private Map<Integer, String> standardNumber2Str = new HashMap<Integer, String>();
	
	
	/**
	 * Creates a new (the unique) Letter Map.
	 */
	private LetterMap() {
		createStandardLetterMap();
	}
	
	
	/**
	 * Creates the standard letter map. That is, the mapping from letters to numbers is:
	 * A->0, B->1, C->2, ... Z->26.
	 */
	private void createStandardLetterMap() {
		
		for (int i=0; i<chars.length; i++) {
			standardStr2Number.put(chars[i], i);
			standardNumber2Str.put(i, chars[i]);
		}
		
	}
	
	
	/**
	 * Returns the standard mapping of letters to integer. 
	 * @return standard mapping
	 */
	public Map<String, Integer> getStandardString2Number() {
		return standardStr2Number;
	}

	/**
	 * Returns the standard mapping of integers to letters.
	 * @return standard mapping
	 */
	public Map<Integer, String> getStandardNumber2String() {
		return standardNumber2Str;
	}
	
	/**
	 * Returns the standard mapping for the input number.
	 * @param number the number between 0 and 25 to map
	 * @return the corresponding letter
	 */
	public String getStandardString(int number) {
		if (!standardNumber2Str.containsKey(number)) {
			throw new IllegalArgumentException("Number out of range.");
		}
		return standardNumber2Str.get(number);
	}
	
	/**
	 * Returns the standard mapping for the input letter.
	 * @param str a letter between A and Z
	 * @return the corresponding number
	 */
	public int getStandardNumber(String str) {
		if (!standardStr2Number.containsKey(str)) {
			throw new IllegalArgumentException("Letter out of range.");
		}
		return standardStr2Number.get(str);
	}
	
	public int getStandandSize() {
		return standardStr2Number.size();
	}
}
