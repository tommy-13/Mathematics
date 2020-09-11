package math.cipher.string;

import java.util.HashMap;
import java.util.Map;

public class PermutationCipher implements StringCipher {
	
	private Map<String,String> encodeMap;
	private Map<String,String> decodeMap;
		
	
	/**
	 * Creates a Permutation Cipher where each letter is replaced by another letter.
	 * @param encodeMap the mapping of the letters
	 */
	public PermutationCipher(Map<String,String> encodeMap) {
		this.encodeMap = encodeMap;
		createDecodeMap();
	}
	
	/**
	 * Creates a hash map to decode letters fast.
	 */
	private void createDecodeMap() {
		decodeMap = new HashMap<String, String>();
		encodeMap.forEach((key,value) -> decodeMap.put(value, key));
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
		
		Map<String,String> map = encode ? encodeMap : decodeMap;
		
		// map strings
		String result = "";
		for (int i=0; i<str.length(); i++) {
			String s = str.substring(i, i+1);
			result  += map.get(s);
		}
		
		return result;
	}

}
