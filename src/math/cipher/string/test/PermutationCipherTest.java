package math.cipher.string.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import math.cipher.string.PermutationCipher;

public class PermutationCipherTest {
		
	private PermutationCipher cipher;
	private String            word;
	private String            encoded;
	

	@Before
	public void setUpCipher() throws Exception {
		String[] keys   = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String[] values = {"B","A","S","D","J","E","K","F","H","I","C","L","Z","P","X","R","G","O","Q","Y","U","M","W","N","T","V"};
		Map<String, String> map = new HashMap<String, String>();
		
		for (int i=0; i<keys.length; i++) {
			map.put(keys[i], values[i]);
		}
		
		cipher = new PermutationCipher(map);
	}

	@Before
	public void setUpStrings() throws Exception {
		word    = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		encoded = "BASDJEKFHICLZPXRGOQYUMWNTV";
	}
	
	

	@Test
	public void testEncode() {
		assertEquals(encoded, cipher.encode(word));
	}

	@Test
	public void testDecode() {
		assertEquals(word, cipher.decode(encoded));
	}
	
}
