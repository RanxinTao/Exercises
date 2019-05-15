package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find all occurrence of anagrams of a given string s in a given string I.
 * Return the list of starting indices.
 * 
 * Assumptions: 
 * 1. s is not null or empty
 * 2. l is not null
 * 
 * Examples:
 * l = "abcbac", s = "ab", return [0, 3]
 * 
 * Time: O(s + l)
 * Space: O(s)
 */
public class AllAnagrams {
	public List<Integer> allAnagrams(String s, String l) {
		List<Integer> res = new ArrayList<>();
		Map<Character, Integer> chsToMatch = getFreqMap(s);
		int totalToMatch = chsToMatch.size();
		int left = 0;	
		for (int right = 0; right < l.length(); right++) { // move the sliding window by one step from left to right
			totalToMatch = updateStatus(l, right, -1, chsToMatch, totalToMatch); // handle the new added character (rightmost) at the current sliding window
			if (right >= s.length()) { // handle the leftmost character at the previous sliding window
				totalToMatch = updateStatus(l, left, 1, chsToMatch, totalToMatch);
				left++;
			}
			if (totalToMatch == 0) {
				res.add(left);
			}
		}
		return res;
	}

	private Map<Character, Integer> getFreqMap(String s) {
		Map<Character, Integer> res = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			res.put(cur, res.getOrDefault(cur, 0) + 1);
		}
		return res;
	}
	
	private int updateStatus(String l, int index, int change, Map<Character, Integer> chsToMatch, int totalToMatch) {
		char cur = l.charAt(index);
		Integer count = chsToMatch.get(cur);
		if (count != null) {
			if (count == 0) {
				totalToMatch++;
			}
			count += change;
			if (count == 0) {
				totalToMatch--;
			}
			chsToMatch.put(cur, count);		
		}
		return totalToMatch;
	}
	
	public static void main(String[] args) {
		AllAnagrams test = new AllAnagrams();
		String s = "ab";
		String l = "abcbac";
		System.out.println(test.allAnagrams(s, l));
	}
}
