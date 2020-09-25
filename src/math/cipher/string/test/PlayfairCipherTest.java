package math.cipher.string.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import math.cipher.string.PlayfairCipher;

public class PlayfairCipherTest {
		
	private PlayfairCipher cipher1, cipher2, cipher3;
	private String         key1, key2, key3;
	private String         word1, word2, word3;
	private String         encoded1, encoded2, encoded3;
	private String         decoded1, decoded2, decoded3;
	

	@Before
	public void setUpCipher() throws Exception {

		key1  = "death";
		key2  = "GEHEIM";
		key3  = "ABC";
		
		cipher1 = new PlayfairCipher(key1);
		cipher2 = new PlayfairCipher(key2);
		cipher3 = new PlayfairCipher(key3);
	}

	@Before
	public void setUpStrings() throws Exception {
		
		word1 = "Laboulaye lady will lead to Cibola temples of gold";
		word2 = "Butterbrote";
		word3 = "MIX";
		
		encoded1 = "MEIKQOTXCQTEZXCOMWQCTEHNFBIKMEHAKRQCUNGIKMAV";
		encoded2 = "FRSYRIWLTLRI";
		encoded3 = "OGVS";
		
		decoded1 = "LABOULAYELADYWILLXLEADTOCIBOLATEMPLESOFGOLDX";
		decoded2 = "BUTXTERBROTE";
		decoded3 = "MIXQ";
	}
	
	

	@Test
	public void testEncode() {
		assertEquals(encoded1, cipher1.encode(word1));
		assertEquals(encoded2, cipher2.encode(word2));
	}

	@Test
	public void testDecode() {
		assertEquals(decoded1, cipher1.decode(encoded1));
		assertEquals(decoded2, cipher2.decode(encoded2));
	}
	
}
