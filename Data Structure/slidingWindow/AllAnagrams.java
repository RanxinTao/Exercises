package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Assumptions:
 * 1. s is not null or empty
 * 2. l is not null
 * Examples:
 * l = "abcbac", s = "ab", return [0, 3]
 */
public class AllAnagrams {
	public List<Integer> allAnagrams(String s, String l) {
		List<Integer> res = new ArrayList<>();
		if (l.length() == 0) {
			return res;
		}
		Map<Character, Integer> freqMap = getFreqMap(s);
		int toMatch = freqMap.size();
		int left = 0;
		// move the sliding window by one step from left to right
		for (int right = 0; right < l.length(); right++) {
			// handle the new added character (rightmost) at the current sliding window
			toMatch = updateStatus(l, right, -1, freqMap, toMatch);
			// handle the leftmost character at the previous sliding window
			if (right >= s.length()) {
				toMatch = updateStatus(l, left, 1, freqMap, toMatch);
				left++;
			}
			if (toMatch == 0) {
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
	
	private int updateStatus(String l, int index, int change, Map<Character, Integer> freqMap, int toMatch) {
		char cur = l.charAt(index);
		Integer count = freqMap.get(cur);
		if (count != null) {
			if (count == 0) {
				toMatch++;
			}
			count += change;
			freqMap.put(cur, count);
			if (count == 0) {
				toMatch--;
			}
		}
		return toMatch;
	}
	
	public static void main(String[] args) {
		AllAnagrams test = new AllAnagrams();
		String s = "ab";
		String l = "abcbac";
		System.out.println(test.allAnagrams(s, l));
	}
}
