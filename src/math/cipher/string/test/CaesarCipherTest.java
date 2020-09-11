package math.cipher.string.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import math.cipher.string.CaesarCipher;

public class CaesarCipherTest {
		
	private CaesarCipher cipher1, cipher2, cipher3;
	private String       word;
	private String       encoded1, encoded2, encoded3;
	

	@Before
	public void setUpCipher() throws Exception {
		cipher1 = new CaesarCipher(0);
		cipher2 = new CaesarCipher(5);
		cipher3 = new CaesarCipher(27);
	}

	@Before
	public void setUpStrings() throws Exception {
		word     = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		encoded1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		encoded2 = "FGHIJKLMNOPQRSTUVWXYZABCDE";
		encoded3 = "BCDEFGHIJKLMNOPQRSTUVWXYZA";
	}
	
	

	@Test
	public void testEncode() {
		assertEquals(encoded1, cipher1.encode(word));
		assertEquals(encoded2, cipher2.encode(word));
		assertEquals(encoded3, cipher3.encode(word));
	}

	@Test
	public void testDecode() {
		assertEquals(word, cipher1.decode(encoded1));
		assertEquals(word, cipher2.decode(encoded2));
		assertEquals(word, cipher3.decode(encoded3));
	}
	
}
