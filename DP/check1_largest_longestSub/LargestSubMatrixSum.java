package check1_largest_longestSub;

/**
 * Given a matrix that contains integers, find the submatrix with the largest sum. Return the sum of the submatrix.
 * 
 * Assumptions: matrix is not null and has size of M * N, M >= 1 and N >= 1
 * Examples:
 * {{1, -2, -1, 4},
 *  {1, -1, 1, 1},
 *  {0, -1, -1, 1},
 *  {0, 0, 1, 1}}
 *  the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
 *  
 *  Time: O(mn^2 + mn) = O(mn^2)
 *  Space: O(mn)
 */
public class LargestSubMatrixSum {
	public int largest(int[][] matrix) {
		int[][] prefixSums = prefixSum(matrix);
		int maxSum = Integer.MIN_VALUE;
		for (int top = 0; top < matrix.length; top++) {
			for (int bottom = top; bottom < matrix.length; bottom++) {
				int[] cur = new int[matrix[0].length];
				for (int i = 0; i < cur.length; i++) {
					cur[i] = top == 0 ? prefixSums[bottom][i] : prefixSums[bottom][i] - prefixSums[top - 1][i];
				}
				maxSum = Math.max(maxSum, largestSubArraySum(cur));
			}
		}
		return maxSum;
	}

	private int[][] prefixSum(int[][] matrix) {
		int[][] prefixSums = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				prefixSums[i][j] = i == 0 ? matrix[i][j] : prefixSums[i - 1][j] + matrix[i][j];
			}
		}
		return prefixSums;
	}

	private int largestSubArraySum(int[] array) {
		int localMax = array[0];
		int globalMax = array[0];
		for (int i = 1; i < array.length; i++) {
			localMax = Math.max(array[i], array[i] + localMax);
			globalMax = Math.max(localMax, globalMax);
		}
		return globalMax;
	}
	
	public static void main(String[] args) {
		LargestSubMatrixSum test = new LargestSubMatrixSum();
		int[][] matrix = {{1,-2,-1,4}, {1,-1,1,1}, {0,-1,-1,1}, {0,0,1,1}};
		System.out.println(test.largest(matrix));
	}
}
