package differentWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * There is a wooden stick with length L >= 1, we need to cut it into pieces, where the cutting positions are defined 
 * in an int array A. The positions are guaranteed to be in ascending order in the range of [1, L - 1]. The cost of 
 * each cut is the length of the stick segment being cut. Determine the minimum total cost to cut the stick into the 
 * defined pieces.
 * 
 * Assumptions: 
 * cuts is not null and has length >= 1 and all cuts are valid numbers
 * 
 * Examples: 
 * L = 10, A = {2, 4, 7}, the minimum total cost is 10 + 4 + 6 = 20 (cut at 4 first then cut at 2 and cut at 7)
 * 
 * Time: O(n^2)
 * Space: O(n^2)
 */
public class CuttingWoodI {
	public int minCost(int[] cuts, int length) {
		return minCost(cuts, length, new HashMap<>(), 0, length); // HashMap stores the min cost of cutting the partition(start, end)
	}
	
	private int minCost(int[] cuts, int length, Map<Integer, Integer> minCosts, int start, int end) { // return the min cost of cutting the partition(start, end)
		if (end - start <= 1) { // if a partition has length <= 1, then there can not be a cut in this partition
			return 0;
		}
		int key = start * length + end; // calculate a key using start and end
		Integer value = minCosts.get(key);
		if (value != null) {
			return value;
		} else {
			int minCost = Integer.MAX_VALUE;
			for (int i = 0; i < cuts.length && cuts[i] < end; i++) {
				if (cuts[i] > start) {
					minCost = Math.min(minCost, end - start + minCost(cuts, length, minCosts, start, cuts[i]) + 
							minCost(cuts, length, minCosts, cuts[i], end));
				}
			}
			if (minCost == Integer.MAX_VALUE) { // if there is no cut in this partition, set the min cost to 0
				minCost = 0;
			}
			minCosts.put(key, minCost);
			return minCost;
		}
	}
	
	/*public int minCost(int[] cuts, int length) {
		// First we need to pad the original array at leftmost and rightmost position.
		int[] helper = new int[cuts.length + 2];
		for (int i = 0; i < cuts.length; i++) {
			helper[i + 1] = cuts[i];
		}
		helper[helper.length - 1] = length;
		// minCost[i][j]: the min cost of cutting the partition(i,j).
		int[][] minCost = new int[helper.length][helper.length];
		for (int j = 1; j < helper.length; j++) {
			for (int i = j - 1; i >= 0; i--) {
				if (i + 1 == j) {
					minCost[i][j] = 0;
				} else {
					minCost[i][j] = Integer.MAX_VALUE;
					for (int k = i + 1; k <= j - 1; k++) {
						minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
					}
					minCost[i][j] += helper[j] - helper[i];
				}
			}
		}
		return minCost[0][helper.length - 1];
	}*/
}
