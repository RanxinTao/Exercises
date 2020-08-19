package dfs;

/**
 * Given a set of integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two
 * subsets is as minimum as possible.
 * Return the minimum difference (absolute value).
 * 
 * Assumptions: 
 * The given integer array is not null and it has length of >= 2.
 * Examples:
 * {1, 3, 2} can be divided into {1, 2} and {3}, the minimum difference is 0
 * 
 * Time: O(2^n)
 * Space: O(n)
 */
public class TwoSubsetsWithMinDifference {
	public int minDifference(int[] array) {
		int sum = 0;
		for (int num : array) {
			sum += num;
		}
		int[] minDiff = new int[1];
		minDiff[0] = Integer.MAX_VALUE;
		minDiff(array, 0, 0, 0, minDiff, sum);
		return minDiff[0];
	}
	
	private void minDiff(int[] array, int idx, int curHalf, int curCnt, int[] minDiff, int sum) {
		if (idx == array.length) {
			return;
		}	
		minDiff(array, idx + 1, curHalf, curCnt, minDiff, sum);
		curHalf += array[idx];
		curCnt++;
		int restHalf = sum - curHalf;
		if (curCnt == array.length / 2) {
			minDiff[0] = Math.min(minDiff[0], Math.abs(curHalf - restHalf));
		}
		minDiff(array, idx + 1, curHalf, curCnt, minDiff, sum);
	}
	
	public static void main(String[] args) {
		TwoSubsetsWithMinDifference test = new TwoSubsetsWithMinDifference();
		//int[] array = {1, 3, 2};
		int[] array = {5, -2, -10, 3}; //6
		System.out.println(test.minDifference(array));
	}
}
