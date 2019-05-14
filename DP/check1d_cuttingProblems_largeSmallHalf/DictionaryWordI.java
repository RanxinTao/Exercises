package check1d_cuttingProblems_largeSmallHalf;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.
 * 
 * Assumptions:
 * 1. input is not null and is not empty
 * 2. dict is not null and is not empty and all the words in the dict are not null or empty
 * Examples: 
 * Dictionary: {"bob", "cat", "rob"}
 * 1. Word: "robob" return false
 * 2. Word: "robcatbob" return true since it can be composed by "rob", "cat", "bob"
 * 
 * Time: O(n^2) where n is the length of the word
 * Space: O(n)
 */
public class DictionaryWordI {
	public boolean canBreak(String input, String[] dict) {
		Set<String> dictSet = new HashSet<>();
		for (String word : dict) {
			dictSet.add(word);
		}
		boolean[] canBreak = new boolean[input.length() + 1]; // canBreak[i] represents if input.substring(0, i) can be composed by concatenating words from dict.
		canBreak[0] = true; // handle corner case: endIndex = 0 (empty string)
		for (int i = 1; i <= input.length(); i++) { // i is the endIndex of substring, starting from 1 to input length
			for (int j = 0; j < i; j++) { // calculate canBreak[i] using canBreak[0], ..., canBreak[i - 1]
				if (canBreak[j] && dictSet.contains(input.substring(j, i))) {
					canBreak[i] = true;
					break;
				}
			}
		}
		return canBreak[input.length()];
	}
	
	/*public boolean canBreak(String input, String[] dict) {
		Set<String> dictSet = new HashSet<>();
		for (String word : dict) {
			dictSet.add(word);
		}
		// canBreak[n] represents if substring starts from index 0 to i (inclusive) can be composed by concatenating words from dict.
		boolean[] canBreak = new boolean[input.length()];
		for (int i = 0; i < canBreak.length; i++) {
			// if the word is in the dict, done
			if (dictSet.contains(input.substring(0, i + 1))) {
				canBreak[i] = true;
				continue;
			}
			for (int j = 0; j < i; j++) {
				if (canBreak[j] && dictSet.contains(input.substring(j + 1, i + 1))) {
					canBreak[i] = true;
					break;
				}
			}
		}
		return canBreak[canBreak.length - 1];
	}*/
	
	public static void main(String[] args) {
		DictionaryWordI test = new DictionaryWordI();
		String input = "robcatbob";
		String[] dict = {"bob", "cat", "rob"};
		System.out.println(test.canBreak(input, dict));
	}
}
