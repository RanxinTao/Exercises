package memorizedRecursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to the number of different
 * combinations that can sum up to that amount.
 * 
 * Assumptions:
 * 1. You may assume that you have an infinite number of each kind of coin.
 * 
 * Examples:
 * 1. coins = [1, 2], amount = 5, return 3
 * Explanation: 5 = 1 + 1 + 1 + 1 + 1 = 1 + 1 + 1 + 2 = 1 + 2 + 2
 * 
 * Thoughts: think about the way we used to solve problem "Combinations of coins", the idea is same in this problem. And the way we use memo 
 * in this problem is same to that we used in problem "Target sum".
 * 
 * Time: O(mn), where n is the length of the coins array, and m is amount
 * Space: O(mn)
 */
public class CoinChangeII {
	public int coinChange(int amount, int[] coins) {
		if (amount == 0) {
			return 1;
		}
		if (coins == null || coins.length == 0) {
			return 0;
		}
		Arrays.sort(coins); 
		return coinChange(amount, coins, coins.length - 1, new HashMap<>());
	}
	
	private int coinChange(int amt, int[] coins, int idx, Map<List<Integer>, Integer> memo) { // return the number of combinations to make up a certain amount by using the first idx coins
		if (idx == 0) {
			return amt % coins[0] == 0 ? 1 : 0;
		}
		List<Integer> key = Arrays.asList(idx, amt);
		Integer value = memo.get(key);
		if (value != null) {
			return value;
		}
		int nCombo = 0;
		while (amt >= 0) {
			nCombo += coinChange(amt, coins, idx - 1, memo);
			amt -= coins[idx];
		}
		memo.put(key, nCombo);
		return nCombo;
	}
	
	/*public int coinChange(int amount, int[] coins) { // can not be simply derived from this way, because it counts combinations repeatedly
		int[] combo = new int[amount + 1];
		combo[0] = 1;
		for (int i = 1; i < combo.length; i++) {
			int nCombo = 0;
			for (int coin : coins) {
				int remain = i - coin;
				if (remain >= 0) {
					nCombo += combo[remain];
				}
			}
			combo[i] = nCombo;
		}
		return combo[amount];
	}*/
	
	public static void main(String[] args) {
		CoinChangeII test = new CoinChangeII();
		int amount = 63;
		int[] coins = {5, 12, 19, 9, 2, 7, 15, 14, 20, 21}; //1092
		System.out.println(test.coinChange(amount, coins));
	}
}
