package largest_longestSub_check1;

/**
 * Given an array of positive integers representing a stock¡¯s price on each day. On each day you can only make one operation: 
 * either buy or sell one unit of stock, you can make as many transactions you want, but at any time you can only hold 
 * at most one unit of stock. Determine the maximum profit you can make.
 * 
 * Assumptions: 
 * array is not null and has length >= 2
 * Examples:
 * {2, 3, 2, 1, 4, 5}, the maximum profit you can make is (3 - 2) + (5 - 1) = 5
 */
public class BuyStockII {
	public int maxProfit(int[] array) {
		int res = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int diff = array[i + 1] - array[i];
			if (diff > 0) {
				res += diff;
			}
		}
		return res;
	}
}
