package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		if (phrase.isEmpty()) {
			return "";
		}
		
		String[] sArray = {" a "," an ", " the ", " for ", " and ", " nor ", " but ", " or ", " so " };
		String result = "";
		Pattern p;
		Matcher m;
		StringBuilder sb_in = new StringBuilder(phrase);
		StringBuilder sb_out = new StringBuilder("");
		
 		for (String s : sArray) {
			p = Pattern.compile(s.toString(), Pattern.CASE_INSENSITIVE);
			m = p.matcher(sb_in.toString());
			sb_in.replace(0, sb_in.toString().length(), m.replaceAll("  "));
		}
		
		String[] sArr = sb_in.toString().split("[\\W_]+");
		
		char[] cArr;
		for (String s : sArr) {
			cArr = s.toCharArray();
			sb_out.append(Character.toUpperCase(cArr[0]));
		}
		
		System.out.println(sb_out.toString());
		
		result = sb_out.toString();
		
		return result;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}
		
		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			
			if (sideOne == sideTwo && sideTwo == sideThree) {
				return true;
			}
			
			return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if (sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree) {
				return true;
			}
			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if (sideOne != sideTwo && sideTwo != sideThree && sideOne != sideThree) {
				return true;
			}
			return false;
		}
		
		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 =
	 * 3 + 2 + 6 + 3 =
	 * 5 + 9 = 
	 * 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>(52);
		
		hm.put('a', 1);hm.put('A', 1);
		hm.put('b', 3);hm.put('B', 3);
		hm.put('c', 3);hm.put('C', 3);
		hm.put('d', 2);hm.put('D', 2);
		hm.put('e', 1);hm.put('E', 1);
		hm.put('f', 4);hm.put('F', 4);
		hm.put('g', 2);hm.put('G', 2);
		hm.put('h', 4);hm.put('H', 4);
		hm.put('i', 1);hm.put('I', 1);
		hm.put('j', 8);hm.put('J', 8);
		hm.put('k', 5);hm.put('K', 5);
		hm.put('l', 1);hm.put('L', 1);
		hm.put('m', 3);hm.put('M', 3);
		hm.put('n', 1);hm.put('N', 1);
		hm.put('o', 1);hm.put('O', 1);
		hm.put('p', 3);hm.put('P', 3);
		hm.put('q', 10);hm.put('Q', 10);
		hm.put('r', 1);hm.put('R', 1);
		hm.put('s', 1);hm.put('S', 1);
		hm.put('t', 1);hm.put('T', 1);
		hm.put('u', 1);hm.put('U', 1);
		hm.put('v', 4);hm.put('V', 4);
		hm.put('w', 4);hm.put('W', 4);
		hm.put('x', 8);hm.put('X', 8);
		hm.put('y', 4);hm.put('Y', 4);
		hm.put('z', 10);hm.put('Z', 10);

		int score;
		Integer points;
		
		score = 0;
		
		char[] input = string.toCharArray();
		
		for (char cin : input) {
			points = hm.get(cin);
			if (points != null) {
				score += points;
			}
		}
		
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException{
		Pattern p = Pattern.compile("\\D+");
		Matcher m = p.matcher(string);
		
		String result = m.replaceAll("");
		
		if (result.length() == 11 || result.length() == 10) {
			return result;
		} else {
			throw new IllegalArgumentException("phone number has an invalid number of digits");	
		}
		
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		String[] sArr = string.split("[\\W_]+");
		
		HashMap<String, Integer> m = new HashMap<String, Integer>();
		
		Integer temp;
		
		for (String s : sArr) {
			temp = m.get(s);
			if (temp == null) {
				m.put(s, 1);
			} else {
				m.put(s, m.get(s)+1);
			}
		}
		
		
		
		return m;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) throws IllegalArgumentException{
			Integer index, lowerBound, upperBound;
			
			index = ((sortedList.size()-1)/2);
			lowerBound = 0;
			upperBound = sortedList.size()-1;
			
			for (;!(index == lowerBound && index == upperBound);) {
				
				if (sortedList.get(index).compareTo(t)==0) {
					return index;
				} else if (sortedList.get(index).compareTo(t)>0) {
					upperBound = index;
					index = (int)Math.floor(index - ((index - lowerBound)/2.0f));
				} else if (sortedList.get(index).compareTo(t)<0) {
					lowerBound = index;
					index = (int)Math.ceil(index + ((upperBound - index)/2.0f));
				} else {
					throw new IllegalArgumentException("Provided element not found in sorted list");
				}
			}
			
			return index;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		String[] sArr;
		char[] charArr;
		ArrayList<Character> tempChars;
		String temp;
		StringBuilder sb, sbResult;
		sArr = string.split(" +");
		sbResult = new StringBuilder("");
		sb = null;
		for (String s : sArr) {
			if (sb != null) {
				sbResult.append(' ');
			}
			
			sb = new StringBuilder();
			tempChars = new ArrayList<Character>();
			charArr = s.toCharArray();
			int i;
			for (i = 0; i < charArr.length; i++) {
				if (i == 0 && Pattern.matches("[wrtypsdfghjklzxcvbnm]", "" + charArr[i])) {
					tempChars.add(charArr[i]);
				} else if (i == 0 && Pattern.matches("[q]", "" + charArr[i])) {
					tempChars.add(charArr[i]);
					tempChars.add(charArr[i+1]);
					i++;
					i++;
					break;
				} else if (Pattern.matches("[qwrtpsdfghjklzxcvbnm]", "" + charArr[i])) {
					tempChars.add(charArr[i]);
				} else if (Pattern.matches("[aeiouy]", "" + charArr[i])) {
					break;
				}
			}
			
			sb.append(s.substring(i));
			for (Character c : tempChars) {
				sb.append(c);
			}
			sb.append("ay");
			
			sbResult.append(sb.toString());
		}
		
		return sbResult.toString();
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		int i = 0, sum = 0;
		String s = Integer.toString(input);
		char[] charArr = s.toCharArray();
		for (char c : charArr ) {
			i = Integer.valueOf("" + c);
			sum += (int)Math.pow(i, charArr.length);
		}
		if (sum == input) {
			return true;
		}
		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> factorList = new ArrayList<Long>();
		for (long factor = 2; factor <= l; factor++) {
			if (l%factor == 0) {
				l = l/factor;
				factorList.add(factor);
				factor--;
			}
		}
		return factorList;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			char[] charArr = string.toCharArray();
			StringBuilder sb = new StringBuilder();
			int i, z = 'z', Z = 'Z', a = 'a', A = 'A';
			for (char c : charArr) {
				if (Pattern.matches("[^\\W_\\d]", ""+c)) {
					i = c;
					i += key;
					if (((int)c) <= Z) {
						if (i > Z) {
							i = i - Z;
							i = i + A -1;
						}
					} else {
						if (i > z) {
							i = i - z;
							i = i + a -1;
						}
					}
					c = (char) i;
				}
				sb.append(c);
			}
			
			
			return sb.toString();
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) throws IllegalArgumentException {
		if (i <= 0) {throw new IllegalArgumentException("Parameter is zero or negative!");}
		Integer number = 1, factor = 2;
		boolean notPrime = false;
		ArrayList<Integer> primeList = new ArrayList<Integer>(i);
		for (;i > primeList.size();) {
			notPrime = false;
			number++;
			for (Integer I : primeList) {
				factor = I;
				if (number%factor == 0) {
					notPrime = true;
					break;
				}
			}
			
			if (!notPrime) {
				primeList.add(number);
			}
			
		}
		return primeList.get(primeList.size()-1);
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {
		static StringBuilder sb;
		static int i, a = 'a', A = 'A', z = 'z', Z = 'Z'; 
		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			sb = new StringBuilder("");
			char[] charArr = string.toCharArray();
			for (char c : charArr) {
				if (c == ' ') {continue;}
				if (Pattern.matches("[^\\W_\\d]", ""+c)) {
					i = c;
					if (i <= Z) {
						i += 32;
						i = z - i;
						i = a + i;
					} else {
						i = z - i;
						i = a + i;
					}
					c = (char) i;
					sb.append(c);
					if ((sb.length()+1)%6 == 0) {
						sb.append(' ');
					}
				} else if (Pattern.matches("\\d", ""+c)) {
					sb.append(c);
					if ((sb.length()+1)%6 == 0) {
						sb.append(' ');
					}
				}
			}
			if (sb.charAt(sb.length() - 1) == ' ') {
				sb.deleteCharAt(sb.length() - 1);
			}
			return sb.toString();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			sb = new StringBuilder("");
			char[] charArr = string.toCharArray();
			for (char c : charArr) {
				if (c == ' ') {continue;}
				if (Pattern.matches("[^\\W_\\d]", ""+c)) {
					i = c;
					if (i <= Z) {
						i = Z - i;
						i = A + i;
					} else {
						i = z - i;
						i = a + i;
					}
					c = (char) i;
					sb.append(c);
				} else if (Pattern.matches("\\d", ""+c)) {
					sb.append(c);
				}
			}
			
			return sb.toString();
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		Pattern p = Pattern.compile("[^\\dxX]+");
		Matcher m = p.matcher(string);
		string = m.replaceAll("");
		
		if (string.length() != 10) {
			return false;
		}
		char[] charArr = string.toCharArray();
		Integer temp = 0, sum = 0;
		for (int i = 0; i < 10; i++) {
			if (charArr[i] == 'x' || charArr[i] == 'X') {
				temp = 10;
			} else {
				temp = Integer.valueOf(""+charArr[i]);
			}
			sum += temp * (10-i);
		}
		if (sum%11 == 0) {
			return true;
		}
		
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		char[] charArr = string.toCharArray();
		String[] charCheck = new String[26];
		int i, a='a', A='A', z='z', Z='Z';
		if (charArr.length == 0) {
			return false;
		}
		for (char c : charArr) {
			i=c;
			if ((i>=A&&i<=Z)||(i>=a&&i<=z)) {
				if (i - 90 > 0) {
					charCheck[i-97] = ""+c;
				} else {
					charCheck[i-65] = ""+c;
				}
			}
		}
		for (int j = 0; j < charCheck.length; j++) {
			if (charCheck[j]==null) {
				return false;
			}
		}
		
		return true;
	}

	/**		SKIP THIS
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		int mult, sum = 0;
		HashSet<Integer> mults = new HashSet<Integer>();
		for (int j : set) {
			mult = j;
			for (;mult < i; mult += j) {
				mults.add(mult);
			}
		}
		for (Integer j : mults) {
			sum += j;
		}
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		
		Pattern p = Pattern.compile(" +");
		Matcher m = p.matcher(string);
		string = m.replaceAll("");
		
		int sum = 0, holder;
		char[] charArr = string.toCharArray();
		boolean second = false;
		for (int i = charArr.length-1; i >= 0; i--) {
			if (Pattern.matches("\\D", ""+charArr[i]))
			{
				return false;
			}
			holder = Integer.valueOf(""+charArr[i]);
			if (second) {
				holder *= 2;
				if (holder > 9) {
					holder -= 9;
				}
				sum += holder;
				second = false;
			} else {
				sum += holder;
				second = true;
			}
		}
		
		if (sum%10 == 0) {
			return true;
		}
		
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) throws IllegalArgumentException{
		int result = 0, num1, num2;
		ArrayList<Integer> numList = new ArrayList<Integer>();
		boolean add = false, subtract = false, multiply = false, divide = false;
		
		Pattern p = Pattern.compile("[^\\d\\w -]+");
		Matcher m = p.matcher(string);
		string = m.replaceAll("");
		
		String[] sArr = string.split(" ");
		
		for(String s : sArr) {
			if (Pattern.matches("[\\d-]+", s)) {
				numList.add(Integer.valueOf(s));
			} else if (Pattern.matches("plus", s)) {
				add = true;
			} else if (Pattern.matches("minus", s)) {
				subtract = true;
			} else if (Pattern.matches("divided", s)) {
				divide = true;
			} else if (Pattern.matches("multiplied", s)) {
				multiply = true;
			}
		}
		
		if (numList.size() != 2) {
			throw new IllegalArgumentException();
		}
		
		num1 = numList.get(0); 
		num2 = numList.get(1);
		
		if (add) {
			result = num1 + num2;
		} else if (subtract) {
			result = num1 - num2;
		} else if (multiply) {
			result = num1 * num2;
		} else if (divide) {
			result = num1 / num2;
		}
		
		
		return result;
	}

}


