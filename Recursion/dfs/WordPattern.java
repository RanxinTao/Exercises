package dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty
 * substring in str.
 * 
 * Assumptions:
 * 1. You may assume both pattern and str contains only lowercase letters.
 * 
 * Examples:
 * 1. pattern = "abab", str = "redblueredblue" should return true.
 * 2. pattern = "aaaa", str = "asdasdasdasd" should return true.
 * 3. pattern = "aabb", str = "xyzabcxyzabc" should return false.
 * 
 * Thoughts: one character can only be mapped to one string, and one string can only be mapped by one character.
 * 
 * Time: O(m^n), where m is the length of the input string, and n is the length of the pattern string. Because
 * the height of the recursion tree is at most n.
 * Space: O(n), because we have at most n mapping
 */
public class WordPattern {
	public boolean wordPatternMatch(String pattern, String input) {
	    return patternMatch(pattern, input, 0, 0, new HashMap<>(), new HashSet<>());
	}
	
	private boolean patternMatch(String pattern, String str, int pi, int si, Map<Character, String> map, Set<String> mapStrs) {
		if (pi == pattern.length() && si == str.length()) {
			return true;
		} else if (pi == pattern.length() || si == str.length()) {
			return false;
		}
		char ch = pattern.charAt(pi);
		String mapStr = map.get(ch);
		if (mapStr != null) { // there is already a mapping from the character to a string
			int ei = si + mapStr.length(); // ei: end index (exclusive)
			return ei <= str.length() && mapStr.equals(str.substring(si, ei)) ? patternMatch(pattern, str, pi + 1, si + mapStr.length(), map, mapStrs) : false; // if not match, return false, otherwise match next
		}
		for (int ei = si + 1; ei <= str.length(); ei++) { 
			mapStr = str.substring(si, ei); 
			if (mapStrs.contains(mapStr)) {
				continue;
			}
			map.put(ch, mapStr);
			mapStrs.add(mapStr);
			if (patternMatch(pattern, str, pi + 1, si + mapStr.length(), map, mapStrs)) { // as long as one substring works, we can return true
				return true;
			}
			map.remove(ch); // don't forget to remove!
			mapStrs.remove(mapStr);
		}
		return false;
	}
	
	public static void main(String[] args) {
		WordPattern test = new WordPattern();
		//String pattern = "abab";
		//String input = "redblueredblue";
		//String pattern = "aaaa";
		//String input = "asdasdasdasd";
		//String pattern = "aabb";
		//String input = "xyzabcxyzabc";
		//String pattern = "abba";
		//String input = "dogcatcatdog";
		//String input = "ef";
		//String pattern = "d";
		String input = "";
		String pattern = "";
		System.out.println(test.wordPatternMatch(pattern, input));
	}
}
