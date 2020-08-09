package memorizedRecursion;

import java.util.Arrays;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of
 * painting each house with a certain color is different. You have to paint all the houses such that no two adjacent
 * houses have the same color.
 * The cost of painting each house with a certain color is represented by a n * 3 cost matrix. For example, costs[0][0]
 * is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so
 * on... Find the minimum cost to paint all houses.
 * Note: All costs are positive integers.
 * 
 * Time: O(n), where n is the number of houses to be painted
 * Space: O(n)
 */
public class PaintHouse {
	public int minCost(int[][] costs) {
		if (costs.length == 0) {
			return 0;
		}
		int[] mem = new int[costs.length * 3];
		Arrays.fill(mem, -1);
		return Math.min(Math.min(minCost(costs, 0, 0, mem), minCost(costs, 0, 1, mem)), minCost(costs, 0, 2, mem));
	}
	
	private int minCost(int[][] costs, int curIdx, int curColor, int[] mem) { // returns the min cost painting from the current house to the last house, when the current house is painted with a certain color
		if (curIdx == costs.length - 1) { // The current house being painted is the last house in the row
			return costs[costs.length - 1][curColor]; 
		}
		int encode = curIdx * 3 + curColor;
		if (mem[encode] != -1) {
			return mem[encode];
		}
		int restMin = Integer.MAX_VALUE; // The min cost of painting the rest houses (from curIdx + 1 to the last one)
		for (int color = 0; color < 3; color++) { // 0 means red, 1 means blue, and 2 means green
			if (color != curColor) { // the next color and the current color cannot be same
				restMin = Math.min(restMin, minCost(costs, curIdx + 1, color, mem));
			}
		}
		int minCost = costs[curIdx][curColor] + restMin;
		mem[encode] = minCost;
		return minCost;
	}
	
	public static void main(String[] args) {
		PaintHouse test = new PaintHouse();
		int[][] costs = {{8, 9, 9}, {13, 11, 7}, {9, 5, 10}, {9, 12, 19}, {19, 10, 20}, {2, 2, 8}, {9, 2, 18}, {4, 1, 4}, {17, 13, 5}, {8, 3, 18}, {18, 20, 11}};
		System.out.println(test.minCost(costs));
	}
}
