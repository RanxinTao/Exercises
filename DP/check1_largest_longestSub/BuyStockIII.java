package check1_largest_longestSub;

/**
 * Given an array of positive integers representing a stock's price on each day. On each day you can only make one 
 * operation: either buy or sell one unit of stock, at any time you can only hold at most one unit of stock, and you
 * can make at most 2 transactions in total. Determine the maximum profit you can make.
 * 
 * Assumptions: 
 * array is not null and has length >= 2
 * 
 * Examples:
 * {2, 3, 2, 1, 4, 5, 2, 11}, the maximum profit you can make is (5 - 1) + (11 - 2) = 13
 * 
 * Time: O(n)
 * Space: O(n)
 */
public class BuyStockIII {
	public int maxProfit(int[] array) {
		int[] globalMaxArr = new int[array.length - 1]; // globalMax[i] represents max profit for sub array 0 to i.
		int[] globalMaxReverse = new int[array.length - 1]; // globalMaxReverse[i] represents max profit for sub array i to array.length - 1.
		int localMax = 0;
		int globalMax = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int diff = array[i + 1] - array[i];
			localMax = Math.max(localMax + diff, 0);
			globalMax = Math.max(localMax, globalMax);
			globalMaxArr[i] = globalMax;	
		}
		
		
		int localMax = 0;
		int globalMax = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int diff = array[i + 1] - array[i];
			localMax = Math.max(localMax + diff, 0); // buy and hold until current profit becomes negative, start over if negative.
			globalMax = Math.max(localMax, globalMax);
		}
		return globalMax;
	}
}
