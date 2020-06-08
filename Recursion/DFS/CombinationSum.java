package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ..., ak) must be in non-descending order.
 * The solution set must not contain duplicate combinations.
 * 
 * Examples:
 * 1. Given candidate set 2, 3, 6, 7 and target 7, A solution set is: [7], [2, 2, 3]
 * 
 * Time: O(n^(t/c[0])), where n is the number of candidate numbers, t is the target number, and c[0] is the minimal number in candidates
 * Space: O(t/c[0])
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Set<Integer> set = new HashSet<>();
		for (int candidate : candidates) {
			set.add(candidate);
		}
		List<Integer> c = new ArrayList<>(set);
		Collections.sort(c);
		List<List<Integer>> res = new ArrayList<>();
		combinationSum(c, target, 0, 0, new ArrayList<>(), res);
		return res;
	}
	
	private void combinationSum(List<Integer> candidates, int target, int idx, int sum, List<Integer> curRes, List<List<Integer>> res) {
		if (sum == target) {
			res.add(new ArrayList<Integer>(curRes));
			return;
		}
		if (sum < target) {
			for (int i = idx; i < candidates.size(); i++) {
				int cur = candidates.get(i);
				sum += cur;
				curRes.add(cur);
				combinationSum(candidates, target, i, sum, curRes, res); // pass i as the index, to ensure the result in non-descending order
				sum -= cur;
				curRes.remove(curRes.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationSum test = new CombinationSum();
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		System.out.println(test.combinationSum(candidates, target));
	}
}
