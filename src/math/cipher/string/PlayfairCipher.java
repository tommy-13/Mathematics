package math.cipher.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import math.functions.basic.ModuloFunction;
import math.helper.Tuple;

public class PlayfairCipher implements StringCipher {
	
	// This values should not be changed!
	private final int squareSize = 5;
	private final char[] charSet = {
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

	private final ModuloFunction mod = new ModuloFunction(squareSize);
	
	private char[][] playfairSquare;
	
	private Map<Character, Tuple<Integer>> charToPos;
	
			
	
	/**
	 * Creates a Playfair Cipher where each pair of letters is replaced by another pair of letters.
	 * @param key a keyword consisting of letters (invalid characters will be removed)
	 */
	public PlayfairCipher(String key) {
		char[] charKey;
		if (key == null) {
			charKey = new char[1];
			charKey[0] = 'A';
		}
		else {
			charKey = makeValid(key);
		}
		
		// create the square
		createPlayfairSquare(charKey);
		
		//printPlayfairSquare();
		
		// create the mapping of characters to positions in the square
		createMapping();
	}
	
	/**
	 * Creates a mapping from each character to its position in the playfair square.
	 */
	private void createMapping() {
		
		charToPos = new HashMap<Character, Tuple<Integer>>();
		
		for (int row=0; row<squareSize; row++) {
			for (int col=0; col<squareSize; col++) {
				charToPos.put(playfairSquare[row][col], new Tuple<Integer>(row, col));
			}
		}	
	}
	
	
	/**
	 * Removes invalid characters from the string.
	 * @param str the string
	 * @return a valid array of characters
	 */
	private char[] makeValid(String str) {
		str = str.toUpperCase();
		char[]    inputCharStr  = str.toCharArray();
		boolean[] useChar       = new boolean[inputCharStr.length];
		int       newSize       = 0;
		
		for (int i=0; i<inputCharStr.length; i++) {
			char currentChar = inputCharStr[i];
			useChar[i] = (currentChar >= 'A' && currentChar <= 'Z');
			if (useChar[i]) {
				newSize++;
			}
			
			if (currentChar == 'J') {
				inputCharStr[i] = 'I';
			}
		}
		
		
		char[] outputCharStr = new char[newSize];
		int pos = 0;
		for (int i=0; i<inputCharStr.length; i++) {
			if (useChar[i]) {
				outputCharStr[pos] = inputCharStr[i];
				pos++;
			}
		}
		
		return outputCharStr;
	}
	
	/**
	 * Creates the playfair square for the given keyword.
	 */
	private void createPlayfairSquare(char[] charKey) {
		playfairSquare = new char[squareSize][squareSize];
		
		Set<Character> usedChars = new HashSet<Character>();
		int row = 0;
		int col = 0;
		
		// write key: fill from top left to bottom right, every letter only once
		Tuple<Integer> pos = fillSquare(charKey, new Tuple<Integer>(row, col), usedChars);
		
		// write other letters: fill the remaining space
		fillSquare(charSet, pos, usedChars);
	}
	
	/**
	 * Prints the playfair square (for debugging).
	 */
	private void printPlayfairSquare() {
		System.out.println("Square:");
		for (int row=0; row<squareSize; row++) {
			for (int col=0; col<squareSize; col++) {
				System.out.print(playfairSquare[row][col]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Fills the square starting at position <code>pos</code>.
	 * @param characterList the list of characters that should be filled in the square
	 * @param pos           the position to start from
	 * @param usedChars     the characters already used
	 * @return              the next available position
	 */
	private Tuple<Integer> fillSquare(char[] characterList, Tuple<Integer> pos, Set<Character> usedChars) {
		// fill the square from the top left to the bottom right, starting with pos (row, col)
		// every letter should appear only once in the square
		int row = pos.getFirst();
		int col = pos.getSecond();
		
		for (int i = 0; i < characterList.length; i++) {
			char currentChar = characterList[i];
			if (usedChars.contains(currentChar)) {
				continue;
			}
			usedChars.add(currentChar);
			playfairSquare[row][col] = currentChar;
			col++;
			if (col >= squareSize) {
				col =0;
				row++;
			}
		}
		return new Tuple<Integer>(row, col);
	}
	

	
	@Override
	public String encode(String str) {
		
		if (str == null) {
			return null;
		}
		if (str.isEmpty()) {
			return "";
		}
		
		
		// preprocessing: remove invalid characters
		char[] preprocessedChars = makeValid(str);
		
		// preprocessing: add letters such that each bigramm consists of two different letters
		//                and the length of the character sequence is even
		List<Tuple<Character>> bigramms = makeValidPlaintext(preprocessedChars);
		
		return enDeCode(bigramms, true);
	}
	
	/**
	 * Pair up the characters; if a pair would contain a character twice, add an X in between.
	 * @param chars plaintext as an character array
	 * @return the (possibly changed) plaintext as a list of bigramms
	 */
	private List<Tuple<Character>> makeValidPlaintext(char[] chars) {
		
		List<Tuple<Character>> bigramms = new ArrayList<Tuple<Character>>();
		
		int pos = 0;
		while (true) {
			// get next two chars (if possible)
			char c1, c2;
			if (pos < chars.length) {
				c1 = chars[pos];
				pos++;
			} else {
				break;
			}
			
			if (pos < chars.length) {
				c2 = chars[pos];
				// test if letters are the same
				if (c1 == c2) {
					c2 = (c1 == 'X') ? 'Q' : 'X';
				}
				else {
					pos++;
				}
			} else {
				// the word has an odd length, fill it with X (or Q if the last letter is an X)
				c2 = (c1 == 'X') ? 'Q' : 'X';
			}
			
			// now we have our two letters
			bigramms.add(new Tuple<Character>(c1,c2));
		}
		
		return bigramms;
	}

	
	
	
	
	
	@Override
	public String decode(String str) {
		return enDeCode(makeCiffreDigrams(str), false);
	}
	
	private List<Tuple<Character>> makeCiffreDigrams(String str) {
		str = str.toUpperCase();
		List<Tuple<Character>> digrams = new ArrayList<Tuple<Character>>();
		char[] chars = str.toCharArray();
		
		for (int i=0; i<chars.length; i+=2) {
			char c1 = chars[i];
			char c2 = chars[i+1];
			digrams.add(new Tuple<Character>(c1,c2));
		}
		
		return digrams;
	}
	
	
	/**
	 * Calculates the encoding / decoding of the input string.
	 * @param str    the string to encode / decode
	 * @param encode true, if the string should be encoded, false otherwise
	 * @return       the encoded / decoded string
	 */
	private String enDeCode(List<Tuple<Character>> digrams, boolean encode) {

		String result = "";
		
		for (Tuple<Character> tChar : digrams) {
			result += enDeCodePair(tChar, encode);
		}
		
		return result;
	}
	
	
	private String enDeCodePair(Tuple<Character> pair, boolean encode) {
				
		char leftChar  = pair.getFirst();
		char rightChar = pair.getSecond();
		
		Tuple<Integer> leftPos  = charToPos.get(leftChar);
		Tuple<Integer> rightPos = charToPos.get(rightChar);
		
		int leftRow  = leftPos.getFirst();
		int rightRow = rightPos.getFirst();
		int leftCol  = leftPos.getSecond();
		int rightCol = rightPos.getSecond();
		
		
		if (leftRow == rightRow) {
			// the same row
			leftCol  = mod.getYValue(leftCol + (encode ? 1 : -1));
			rightCol = mod.getYValue(rightCol + (encode ? 1 : -1));
		}
		else if (leftCol == rightCol) {
			// the same column
			leftRow  = mod.getYValue(leftRow + (encode ? 1 : -1));
			rightRow = mod.getYValue(rightRow + (encode ? 1 : -1));
			
		}
		else {
			// different row and column
			int saveColLeft = leftCol;
			leftCol  = rightCol;
			rightCol = saveColLeft;
		}
		
		/*
		System.out.print(pair.getFirst());
		System.out.print(pair.getSecond());
		System.out.print(" --> ");
		System.out.print(playfairSquare[leftRow][leftCol]);
		System.out.println(playfairSquare[rightRow][rightCol]);
		*/
		
		return Character.toString(playfairSquare[leftRow][leftCol]) + Character.toString(playfairSquare[rightRow][rightCol]);
	}

}
