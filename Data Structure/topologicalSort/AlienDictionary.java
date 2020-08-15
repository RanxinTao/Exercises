package topologicalSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive
 * a list of non-empty words from the dictionary, where words are sorted lexicograhically by the rules of this new language. Derive
 * order of letters in this language.
 * 
 * Assumptions:
 * 1. You may assume all letters are in lowercase.
 * 2. You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * 3. If the order is invalid, return an empty string.
 * 4. There maybe multiple valid order of letters, return any one of them is fine.
 * 
 * Example:
 * 1. Given the following words in dictionary, ["wrt", "wrf", "er", "ett", "rftt"], the correct order is: "wertf".
 * 2. Given the following words in dictionary, ["z", "x"], the correct order is: "zx".
 * 3. Given the following words in dictionary, ["z", "x", "z"], the order is invalid, so return "".
 *  
 * Algorithm: topological sort
 * 
 * Thoughts: Remember there are two cases where the topological sort will return an empty result: 1. we cannot derive any order based on the
 * input, e.g., "w", "wt"; 2. The order is invalid, e.g., "z", "x", "z". These two cases should return different final results. In first case,
 * we still need to give "wt" as output, while in the second one, we should return an empty string.
 *  
 * Time: O(mn), where m is the average length of words, and n is the number of words
 * Space: O(n)
 */
public class AlienDictionary {
	public String alienOrder(String[] words) {
		List<char[]> edges = new ArrayList<>();
		for (int i = 0; i < words.length - 1; i++) {
			addEdges(edges, words[i], words[i + 1]);
		}
		String res = tpSort(edges);
		if (res == null) {
			return "";
		}
		Set<Character> remains = new HashSet<>();
		for (String word : words) {
			for (char ch : word.toCharArray()) {
				remains.add(ch);
			}
		}
		for (char ch : res.toCharArray()) {
			remains.remove(ch);
		}
		StringBuilder sb = new StringBuilder();
		for (char ch : remains) {
			sb.append(ch);
		}
		return res + sb.toString();
	}
	
	private void addEdges(List<char[]> edges, String word1, String word2) {
		int len = Math.min(word1.length(), word2.length());
		for (int i = 0; i < len; i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				edges.add(new char[] {word2.charAt(i), word1.charAt(i)});
				break;
			}
		}
	}
	
	private String tpSort(List<char[]> edges) {
		if (edges.isEmpty()) { // no edge means we cannot derive any order
			return "";
		}
		int[] indegrees = new int[26];
		for (int i = 0; i < 26; i++) {
			indegrees[i] = -1;
		}
		for (char[] edge : edges) {
			char prev = edge[1];
			char next = edge[0];
			indegrees[next - 'a'] = indegrees[next - 'a'] == -1 ? 1 : indegrees[next - 'a'] + 1;
			if (indegrees[prev - 'a'] == -1) {
				indegrees[prev - 'a'] = 0;
			}
		}
		List<Character> order = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			if (indegrees[i] == 0) {
				order.add((char) (i + 'a'));
			}
		}
		int idx = 0;
		while (idx < order.size()) {
			char ch = order.get(idx++);
			for (char[] edge : edges) {
				if (ch == edge[1]) {
					indegrees[edge[0] - 'a']--;
					if (indegrees[edge[0] - 'a'] == 0) {
						order.add(edge[0]);
					}
				}
			}
		}
		for (int indegree : indegrees) { // There is edge, but the order is invalid, here we return null instead of an empty string to mark it.
			if (indegree > 0) {
				return null;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char ch : order) {
			sb.append(ch);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		AlienDictionary test = new AlienDictionary();
		//String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
		//String[] words = {"bsusz","rhn","gfbrwec","kuw","qvpxbexnhx","gnp","laxutz","qzxccww"};
		//String[] words = {"wrt", "wrtkj", "wrtkjd"};
		String[] words = {"z"};
		System.out.println(test.alienOrder(words));
	}
}
