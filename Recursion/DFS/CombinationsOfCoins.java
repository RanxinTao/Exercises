package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible
 * ways to pay a target number of cents.
 * 
 * Assumptions: 
 * 1. coins is not null and is not empty, all the numbers in coins are positive and are sorted by descending order
 * 2. target >= 0
 * 3. have infinite number of coins for each of the denominations
 * Examples:
 * coins = {2, 1}, target = 4, the return should be:
 * 1. [0, 4] (0 * 2 cents + 4 * 1 cents)
 * 2. [1, 2] (1 * 2 cents + 2 * 1 cents)
 * 3. [2, 0] (2 * 2 cents + 0 * 1 cents)
 * 
 * Time: O(m^n) where m is the target (usually the minimum denomination is 1 cent) and n is the length of coins array.
 */
public class CombinationsOfCoins {
	public List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> res = new ArrayList<>();
		combinations(target, coins, 0, new ArrayList<>(), res);
		return res;
	}

	private void combinations(int target, int[] coins, int index, List<Integer> cur, List<List<Integer>> res) {
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
			combinations(target - i * coins[index], coins, index + 1, cur, res);
			cur.remove(cur.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int target = 4;
		int[] coins = new int[] {2, 1};
		CombinationsOfCoins test = new CombinationsOfCoins();
		System.out.println(test.combinations(target, coins));
	}
}
