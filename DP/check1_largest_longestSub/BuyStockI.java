package check1_largest_longestSub;

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
		int localMax = 0;
		int globalMax = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int diff = array[i + 1] - array[i];
			localMax = Math.max(localMax + diff, 0);
			globalMax = Math.max(localMax, globalMax);
		}
		return globalMax;
	}
	
	public static void main(String[] args) {
		BuyStockI test = new BuyStockI();
		int[] array = {2, 3, 2, 1, 4, 5};
		System.out.println(test.maxProfit(array));
	}
}
