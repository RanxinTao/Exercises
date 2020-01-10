package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is k.
 * 
 * Assumptions: 
 * There are no duplicate characters in the original set
 * 
 * Examples:
 * 1. Set = "abc", K = 2, all the subsets are ["ab", "ac", "bc"].
 * 2. Set = "",  K = 0, all the subsets are [""].
 * 3. Set = "", K = 1, all the subsets are []
 * 
 * Time: O(2^k)
 * Space: O(k)
 */
public class AllSubsetsOfSizeK {
	public List<String> subSetsOfSizeK(String set, int k) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		subSetsOfSizeK(set, k, 0, res, new StringBuilder());
		return res;
	}

	private void subSetsOfSizeK(String set, int k, int index, List<String> res, StringBuilder cur) {
		if (cur.length() == k) {
			res.add(cur.toString());
			return;
		} 
		if (set.length() - index < k - cur.length() ) {
			return;
		}
		cur.append(set.charAt(index));
		subSetsOfSizeK(set, k, index + 1, res, cur);
		cur.deleteCharAt(cur.length() - 1);
		subSetsOfSizeK(set, k, index + 1, res, cur);
	}
	
	public static void main(String[] args) {
		AllSubsetsOfSizeK test = new AllSubsetsOfSizeK();
		String set = "kjpfe";
		int k = 3;
		System.out.println(test.subSetsOfSizeK(set, k));
	}
}
