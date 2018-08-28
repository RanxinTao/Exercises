package largest_longestSub_2d;

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
 */
public class LargestSubMatrixSum {
	public int largest(int[][] matrix) {
		int[][] prefix_sum = prefix_sum(matrix);
		int max = Integer.MIN_VALUE;
		for (int top = 0; top < matrix.length; top++) {
			for (int bottom = top; bottom < matrix.length; bottom++) {
				int[] flattened = new int[matrix[0].length];
				for (int i = 0; i < flattened.length; i++) {
					flattened[i] = top == 0 ? prefix_sum[bottom][i] : prefix_sum[bottom][i] - prefix_sum[top - 1][i];
				}
				max = Math.max(max, largestSubArraySum(flattened));
			}
		}
		return max;
	}

	private int[][] prefix_sum(int[][] matrix) {
		int[][] prefix_sum = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				prefix_sum[i][j] = i == 0 ? matrix[i][j] : prefix_sum[i - 1][j] + matrix[i][j];
			}
		}
		return prefix_sum;
	}

	private int largestSubArraySum(int[] array) {
		int local_max = array[0];
		int global_max = array[0];
		for (int i = 1; i < array.length; i++) {
			local_max = Math.max(array[i], array[i] + local_max);
			global_max = Math.max(local_max, global_max);
		}
		return global_max;
	}
	
	public static void main(String[] args) {
		LargestSubMatrixSum test = new LargestSubMatrixSum();
		int[][] matrix = {{1,-2,-1,4}, {1,-1,1,1}, {0,-1,-1,1}, {0,0,1,1}};
		System.out.println(test.largest(matrix));
	}
}
