package math.cipher.string;

public interface StringCipher {

	/**
	 * Encodes the input string.
	 * @param str a word consisting of Latin letters.
	 * @return the encoded word
	 */
	public String encode(String str);
	
	/**
	 * Decodes the input string.
	 * @param str an encoded word consisting of Latin letters.
	 * @return the decoded word
	 */
	public String decode(String str);
	
}
