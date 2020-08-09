package memorizedRecursion;

import java.util.Arrays;

/**
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with 
 * a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n * k cost matrix. For example, costs[0][0]
 * is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... 
 * Find the minimum cost to paint all houses.
 * Note: All costs are positive integers.
 * 
 * Time: O(n), where n is the number of houses to be painted
 * Space: O(n)
 */
public class PaintHouseII {
	public int minCostII(int[][] costs) {
		int n = costs.length;
		int k = costs[0].length;
		if (n == 0) {
			return 0;
		}
		int[] mem = new int[n * k];
		Arrays.fill(mem, -1);
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			res = Math.min(res, minCost(costs, 0, i, mem));
		}
		return res;
	}
	
	private int minCost(int[][] costs, int idx, int curColor, int[] mem) { // returns the min cost painting from the current house to the last house, when the current house is painted with a certain color
		int n = costs.length;
		int k = costs[0].length;
		if (idx == n - 1) { // The current house being painted is the last house in the row
			return costs[n - 1][curColor]; 
		}
		int encode = idx * k + curColor;
		if (mem[encode] != -1) {
			return mem[encode];
		}
		int restMin = Integer.MAX_VALUE; // The min cost of painting the rest houses (from curIdx + 1 to the last one)
		for (int color = 0; color < k; color++) { // 0 means red, 1 means blue, and 2 means green
			if (color != curColor) { // the next color and the current color cannot be same
				restMin = Math.min(restMin, minCost(costs, idx + 1, color, mem));
			}
		}
		int minCost = costs[idx][curColor] + restMin;
		mem[encode] = minCost;
		return minCost;
	}
	
	public static void main(String[] args) {
		PaintHouseII test = new PaintHouseII();
		int[][] costs = {{15, 11, 4, 5, 7, 19, 10, 14, 5, 1, 5, 20, 3, 10, 14, 8, 5, 13, 5, 14},
				         {11, 18, 18, 11, 7, 16, 19, 8, 18, 4, 12, 20, 12, 17, 11, 16, 11, 2, 13, 7},
				         {11, 14, 17, 16, 7, 6, 20, 2, 16, 8, 20, 7, 20, 19, 9, 18, 16, 15, 20, 7},
				         {17, 10, 14, 2, 2, 7, 4, 14, 10, 18, 9, 19, 14, 16, 1, 4, 14, 17, 15, 6},
				         {17, 19, 6, 3, 12, 13, 19, 14, 18, 12, 14, 3, 17, 20, 1, 1, 4, 6, 5, 7},
				         {17, 4, 12, 20, 1, 13, 19, 10, 6, 11, 1, 12, 4, 7, 3, 18, 20, 8, 13, 9},
				         {16, 19, 9, 16, 7, 1, 11, 19, 4, 20, 17, 18, 16, 7, 4, 8, 5, 1, 18, 12},
				         {12, 9, 5, 15, 10, 7, 3, 12, 3, 17, 20, 20, 7, 12, 9, 6, 14, 13, 7, 14},
				         {2, 16, 8, 4, 6, 19, 19, 20, 13, 6, 6, 19, 3, 18, 18, 9, 15, 7, 15, 8},
				         {2, 3, 14, 3, 19, 4, 19, 4, 11, 9, 12, 11, 3, 11, 17, 9, 11, 13, 19, 4},
				         {2, 2, 10, 7, 16, 10, 10, 16, 2, 20, 5, 20, 12, 14, 9, 2, 19, 6, 9, 20},
				         {10, 3, 16, 2, 10, 19, 18, 1, 13, 16, 14, 11, 15, 20, 12, 8, 10, 10, 8, 1}};
		System.out.println(test.minCostII(costs));
	}
}
