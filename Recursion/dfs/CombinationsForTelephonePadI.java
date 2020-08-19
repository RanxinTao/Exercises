package dfs;

import impl.Utils;

/**
 * Given a telephone keypad, and an int number, print all words which are possible by pressing these numbers,
 * the output strings should be sorted.
 * {0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 : "pqrs", 8 : "tuv", 9 : "wxyz"} 
 * 
 * Assumptions: 
 * 1. The given number >= 0.
 * 
 * Examples:
 * 1. if input number is 231, possible words which can be formed are: [ad, ae, af, bd, be, bf, cd, ce, cf]
 * 
 * Time: O(3^n)
 * Space: O(n)
 */
public class CombinationsForTelephonePadI {
	private static final String[] telPad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public String[] combinations(int num) {
		if (num == 0) {
			return new String[] {""};
		}
		String[] subSolu = combinations(num / 10); // delete last digit
		String chs = telPad[num % 10]; // handle last digit
		if (chs.isEmpty()) {
			return subSolu;
		}
		String[] res = new String[chs.length() * subSolu.length];
		int index = 0;
		for (String s : subSolu) {
			for (char ch : chs.toCharArray()) {
				res[index++] = s + ch;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		CombinationsForTelephonePadI test = new CombinationsForTelephonePadI();
		Utils.printArray(test.combinations(231));
	}
}
