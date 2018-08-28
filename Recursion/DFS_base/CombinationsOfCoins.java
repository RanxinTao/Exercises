package DFS_base;

import java.util.ArrayList;
import java.util.List;

/**
 * Assumptions:
 * 1. coins is not null and is not empty, all the numbers in coins are positive and are sorted by descending order
 * 2. target >= 0
 * 3. have infinite number of coins for each of the denominations
 */
public class CombinationsOfCoins {
	public List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> res = new ArrayList<>();
		DFS(target, coins, 0, new ArrayList<>(), res);
		return res;
	}

	private void DFS(int target, int[] coins, int index, List<Integer> cur, List<List<Integer>> res) {
		if (index == coins.length - 1) {
			if (target % coins[coins.length - 1] == 0) {
				cur.add(target / coins[coins.length - 1]);
				res.add(new ArrayList<Integer>(cur));
				cur.remove(cur.size() - 1);
			}
			return;
		}
		int max = target / coins[index];
		for (int i = 0; i <= max; i++) {
			cur.add(i);
			DFS(target - i * coins[index], coins, index + 1, cur, res);
			cur.remove(cur.size() - 1);
		}
	}
}
