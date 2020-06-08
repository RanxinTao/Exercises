package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ..., ak) must be in non-descending order.
 * The solution set must not contain duplicate combinations.
 * 
 * Examples:
 * 1. Given candidate set 10, 1, 2, 7, 6, 1, 5 and target 8, A solution set is: [1, 7], [1, 2, 5], [2, 6], [1, 1, 6]
 * 
 * Time: O(n^(t/c[0])), where n is the number of candidate numbers, t is the target number, and c[0] is the minimal number in candidates
 * Space: O(t/c[0])
 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		combinationSum(candidates, target, 0, 0, new ArrayList<>(), res);
		return res;
	}
	
	private void combinationSum(int[] candidates, int target, int idx, int sum, List<Integer> curRes, List<List<Integer>> res) {
		if (sum == target) {
			res.add(new ArrayList<Integer>(curRes));
			return;
		}
		if (sum < target) {
			for (int i = idx; i < candidates.length; i++) {
				int cur = candidates[i];
				sum += cur;
				curRes.add(cur);
				combinationSum(candidates, target, i + 1, sum, curRes, res); // pass i as the index, to ensure the result in non-descending order
				sum -= cur;
				curRes.remove(curRes.size() - 1);
				while (i + 1 < candidates.length && candidates[i + 1] == cur) { // must have this after recursion, otherwise some results will be missing
					i++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationSumII test = new CombinationSumII();
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		System.out.println(test.combinationSum2(candidates, target));
	}
}
