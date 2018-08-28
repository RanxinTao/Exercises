package differentWeight;

/**
 * We have a list of piles of stones, each pile of stones has a certain weight, represented by an array of integers. 
 * In each move, we can merge two adjacent piles into one larger pile, the cost is the sum of the weights of the two piles. 
 * We merge the piles of stones until we have only one pile left. Determine the minimum total cost.
 * 
 * Assumptions: stones is not null and has length >= 1
 * Examples: 
 * {4, 3, 3, 4}, the minimum cost is 28
 * 1. merge first 4 and first 3, cost 7
 * 2. merge second 3 and second 4, cost 7
 * 3. merge two 7s, cost 14
 * 4. total cost = 7 + 7 + 14 = 28   
 */
public class MergeStones {
	public int minCost(int[] stones) {
		int len = stones.length;
		// minCosts[i][j]: the minimum total cost of partition(i, j)
		int[][] minCosts = new int[len][len];
		// sums[i][j]: the weight sum of partition(i, j)
		int[][] sums = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = i; j >= 0; j--) {
				if (i == j) {
					sums[j][i] = stones[i];
					minCosts[j][i] = 0;
				} else {
					sums[j][i] = sums[j][i - 1] + stones[i];
					minCosts[j][i] = Integer.MAX_VALUE;
					for (int k = j; k < i; k++) {
						minCosts[j][i] = Math.min(minCosts[j][i], minCosts[j][k] + minCosts[k + 1][i] + sums[j][i]);
					}
				}
			}
		}
		return minCosts[0][len - 1];
	}
}
