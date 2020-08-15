package hashMap_hashSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * 
 * Examples:
 * 1. "code" -> False
 * 2. "aab" -> True
 * 3. "carerac" -> True
 * 
 * Time: O(n)
 * Space: O(n) because a hash map is used.
 */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String input) {
	    Map<Character, Integer> cnts = new HashMap<>();
	    for (int i = 0; i < input.length(); i++) {
	    	char cur = input.charAt(i);
	    	cnts.put(cur, cnts.getOrDefault(cur, 0) + 1);
	    }
	    int oddCnt = 0;
	    for (int cnt : cnts.values()) {
	    	if (cnt % 2 != 0) {
	    		oddCnt++;
	    	}	    	
	    }
	    return oddCnt <= 1; // oddCnt == 0 means the length of input string is even, == 1 means there is only one character that has odd count
	}
	
	public static void main(String[] args) {
		PalindromePermutation test = new PalindromePermutation();
		String input = "carerac";
		System.out.println(test.canPermutePalindrome(input));
	}
}
