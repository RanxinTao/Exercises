package check2d;

/**
 * Given an array of positive integers representing a stock's price on each day. On each day you can only make one 
 * operation: either buy or sell one unit of stock, at any time you can only hold at most one unit of stock, and you
 * can make at most K transactions in total. Determine the maximum profit you can make.
 * 
 * Assumptions: 
 * array is not null and has length >= 2
 * 
 * Examples:
 * {2, 3, 2, 1, 4, 5, 2, 11}, K = 3, the maximum profit you can make is (3 - 2) + (5 - 1) + (11 - 2) = 14
 * 
 * Depends on whether or not we will sell on the last day, we have two conditions:
 * 1. if we are going to sell on the last day, we have k - 1 transactions before the last day, total profit =
 * the profit earned during k - 1 transactions + the profit made by the last day sell.
 * 2. if we are not going to sell on the last day, our max profit = max profit we can make by k transactions on
 * all days expect the last day. Therefore, we can derive the following induction rule:
 * Induction rule:
 * dp[k][i] = 0 (k = 0 or i = 0)
 * 		    = max(dp[k][i - 1], max(array[i] - array[j] + dp[k - 1][j])) (for all j in range [0, i - 1])
 * A better solution can be found: 
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
 * 
 * Time: O(kn^2) for this algorithm, best solution gives O(kn)
 * Space: O(kn)
 */
public class BuyStockIV {
	public int maxProfit(int[] array, int k) {
		int[][] dp = new int[k + 1][array.length];
		for (k = 0; k < dp.length; k++) {
			for (int i = 0; i < dp[0].length; i++) {
				if (k == 0 || i == 0) {
					dp[k][i] = 0;
				} else {
					int maxProfit = dp[k][i - 1];
					for (int j = 0; j < i; j++) {
						maxProfit = Math.max(maxProfit, array[i] - array[j] + dp[k - 1][j]);
					}
					dp[k][i] = maxProfit;
				}
			}
		}
		return dp[dp.length - 1][array.length - 1];
	}
	
	public static void main(String[] args) {
		BuyStockIV test = new BuyStockIV();
		int[] array = {2, 3, 2, 1, 4, 5, 2, 11};
		int k = 3;
		System.out.println(test.maxProfit(array, k));
	}
}
