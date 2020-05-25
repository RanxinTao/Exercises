package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer number, return all possible combinations of the factors that can multiply to the target number.
 * 
 * Examples:
 * Give A = 24
 * since 24 = 2 * 2 * 2 * 3
 *          = 2 * 2 * 6
 *          = 2 * 3 * 4
 *          = 2 * 12
 *          = 3 * 8
 *          = 4 * 6
 * your solution should return
 * {{2, 2, 2, 3}, {2, 2, 6}, {2, 3, 4}, {2, 12}, {3, 8}, {4, 6}}
 * note: duplicate combination is not allowed.
 */
public class FactorCombinations {
	public List<List<Integer>> combinations(int target) {
		List<List<Integer>> res = new ArrayList<>();
		combinations(target, 2, new ArrayList<>(), res);
		// res.add(Arrays.asList(target)); // depends on if target itself counts towards a factor
		return res;
	}
	
	private void combinations(int target, int start, List<Integer> cur, List<List<Integer>> res) {
		if (target == 1 && cur.size() > 1) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int i = start; i <= target; i++) {
			if (target % i == 0) {
				cur.add(i);
				combinations(target / i, i, cur, res); // pass i as the new start value to avoid duplicate
				cur.remove(cur.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		FactorCombinations test = new FactorCombinations();
		int target = 24;
		System.out.println(test.combinations(target));
	}	
}
