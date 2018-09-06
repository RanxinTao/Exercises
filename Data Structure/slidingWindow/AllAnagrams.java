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
		Map<Character, Integer> charToCount = buildCountMap(s);
		int num_to_match = charToCount.size();
		// move the sliding window by one step from left to right
		for (int i = 0; i < l.length(); i++) {
			// handle the new added character (rightmost) at the current sliding window
			char ch = l.charAt(i);
			Integer count = charToCount.get(ch);
			if (count != null) {
				charToCount.put(ch, count - 1);
				if (count == 1) {
					num_to_match--;
				}
			}
			// handle the leftmost character at the previous sliding window
			if (i >= s.length()) {
				ch = l.charAt(i - s.length());
				count = charToCount.get(ch);
				if (count != null) {
					charToCount.put(ch, count + 1);
					if (count == 0) {
						num_to_match++;
					}
				}
			}
			if (num_to_match == 0) {
				res.add(i - s.length() + 1);
			}
		}
		return res;
	}

	private Map<Character, Integer> buildCountMap(String s) {
		Map<Character, Integer> res = new HashMap<>();
		for (char ch : s.toCharArray()) {
			Integer count = res.get(ch);
			if (count == null) {
				res.put(ch, 1);
			} else {
				res.put(ch, count + 1);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		AllAnagrams test = new AllAnagrams();
		String s = "ab";
		String l = "abcbac";
		System.out.println(test.allAnagrams(s, l));
	}
}
