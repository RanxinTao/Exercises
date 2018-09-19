package largest_longestSub_check1;

/**
 * Given an array of positive integers representing a stock¡¯s price on each day. On each day you can only make one operation: 
 * either buy or sell one unit of stock and you can make at most 1 transaction. Determine the maximum profit you can make.
 * 
 * Assumptions: 
 * array is not null and has length >= 2
 * Examples:
 * {2, 3, 2, 1, 4, 5}, the maximum profit you can make is 5 - 1 = 4
 */
public class BuyStockI {
	public int maxProfit(int[] array) {
		int local_max = 0;
		int global_max = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int diff = array[i + 1] - array[i];
			local_max = Math.max(local_max + diff, 0);
			global_max = Math.max(local_max, global_max);
		}
		return global_max;
	}
	
	public static void main(String[] args) {
		BuyStockI test = new BuyStockI();
		int[] array = {2, 3, 2, 1, 4, 5};
		System.out.println(test.maxProfit(array));
	}
}
