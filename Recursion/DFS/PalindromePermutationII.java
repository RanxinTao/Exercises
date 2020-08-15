package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty
 * list if no palindromic permutation could be form.
 * 
 * Examples:
 * 1. Given s = "aabb", return ["abba", "baab"].
 * 2. Given s = "abc", return [].
 * 
 * Thoughts: First thought is constructing strings from middle, keep adding the same character to left and right
 * so it can be a palindrome. However, there is actually an easier solution: we already know how to check if a 
 * permutation of the string can form a palindrome (see problem Palindrome Permutation), so if it can, we only 
 * need to construct half of the strings based on the count map (similar to swap and swap method used in problem
 * All Permutations I and II), then flip it to form the other half.
 * 
 * Time: O(n!), where n is the length of the input string.
 * Space: O(n! * n), because a list of string builders is used, each builder's length is equal to the length of the
 * input string, and the size of the list is the number of permutations, which is (n/2)!.
 */
public class PalindromePermutationII {
	public List<String> generatePalindromes(String input) {
		List<String> res = new ArrayList<>();
		Map<Character, Integer> cnts = new HashMap<>();
	    for (int i = 0; i < input.length(); i++) {
	    	char cur = input.charAt(i);
	    	cnts.put(cur, cnts.getOrDefault(cur, 0) + 1);
	    }
	    char oddCh = 0;
	    int oddCnt = 0;
	    for (char key : cnts.keySet()) {
	    	int cnt = cnts.get(key);
	    	if (cnt % 2 != 0) {
	    		oddCh = key;
	    		oddCnt++;
	    	}
		}
	    if (oddCnt >= 2) { // no palindromic permutation can be form
	    	return res;
	    }
	    String mid = "";
	    if (oddCnt == 1) { // the length of input string is odd and only one character has odd count 
	    	int cnt = cnts.get(oddCh) - 1;
	    	if (cnt == 0) {
	    		cnts.remove(oddCh);
	    	} else {
	    		cnts.put(oddCh, cnt);
	    	}
	    	mid += oddCh;
	    }
	    List<StringBuilder> builders = new ArrayList<>();
	    addResult(cnts, new StringBuilder(), builders); // all string builders are ready after this statement
	    for (StringBuilder sb : builders) {
	    	res.add(sb.toString() + mid + sb.reverse().toString());
	    }
	    return res;
	}
	
	private void addResult(Map<Character, Integer> cnts, StringBuilder cur, List<StringBuilder> builders) {
		if (cnts.isEmpty()) {
			builders.add(new StringBuilder(cur)); // don't forget to create new string builder instance here
		}
		Set<Character> keySet = new HashSet<Character>(cnts.keySet()); // must create a new set, otherwise will throw ConcurrentModificationException
		for (char key : keySet) {
			cur.append(key);
			int cnt = cnts.get(key) - 2;
			if (cnt == 0) {
				cnts.remove(key);
			} else {
				cnts.put(key, cnt);
			}
			addResult(cnts, cur, builders);
			cur.deleteCharAt(cur.length() - 1);
			cnts.put(key, cnt + 2);
		}
	}
	
	public static void main(String[] args) {
		PalindromePermutationII test = new PalindromePermutationII();
		//String input = "aabb";
		String input = "carerac";
		System.out.println(test.generatePalindromes(input));
	}
}
