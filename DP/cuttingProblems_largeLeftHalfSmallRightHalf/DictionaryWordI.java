package cuttingProblems_largeLeftHalfSmallRightHalf;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.
 * 
 * Assumptions:
 * 1. input is not null and not empty
 * 2. dict is not null and not empty and all the words in the dict are not null or empty
 * Examples: 
 * Dictionary: {¡°bob¡±, ¡°cat¡±, ¡°rob¡±}
 * Word: ¡°robob¡± return false
 * Word: ¡°robcatbob¡± return true since it can be composed by "rob", "cat", "bob"
 */
public class DictionaryWordI {
	public boolean canBreak(String input, String[] dict) {
		Set<String> dictSet = new HashSet<>();
		for (String word : dict) {
			dictSet.add(word);
		}
		// dp[n] represents if input.substring(0, i) can be composed by concatenating words from dict.
		boolean[] dp = new boolean[input.length() + 1];
		dp[0] = true;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && dictSet.contains(input.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[dp.length - 1];
	}
	
	public static void main(String[] args) {
		DictionaryWordI test = new DictionaryWordI();
		String input = "robcatbob";
		String[] dict = {"bob", "cat", "rob"};
		System.out.println(test.canBreak(input, dict));
	}
}
