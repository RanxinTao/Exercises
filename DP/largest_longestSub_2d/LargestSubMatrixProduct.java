package largest_longestSub_2d;

/**
 * Given a matrix that contains doubles, find the submatrix with the largest product.
 * Return the product of the submatrix.
 * 
 * Assumptions:
 * The given double matrix is not null and has size of M * N, where M >= 1 and N >= 1
 * Examples:
 * {{1, -0.2, -1},
 *  {1, -1.5,  1},
 *  {0,    0,  1}}
 * the largest submatrix product is 1 * 1 = 1.
 */
public class LargestSubMatrixProduct {
	public double largest(double[][] matrix) {
		double res = 0;
		// product for each column from top to each row
		double[][] prefix_prod = new double[matrix.length][matrix[0].length];
		// how many zeros each column from top to each row
		int[][] prefix_zeros = new int[matrix.length][matrix[0].length];
		prefix(matrix, prefix_prod, prefix_zeros);
		for (int top = 0; top < matrix.length; top++) {
			for (int bot = top; bot < matrix.length; bot++) {
				double[] flattened = new double[matrix[0].length];
				for (int i = 0; i < matrix[0].length; i++) {
					if (top == 0) {
						flattened[i] = prefix_zeros[bot][i] > 0 ? 0 : prefix_prod[bot][i];
					} else {
						flattened[i] = prefix_zeros[bot][i] - prefix_zeros[top - 1][i] > 0 ? 
								0 : prefix_prod[bot][i] / prefix_prod[top - 1][i];
					}
				}
				res = Math.max(res, largestSubArrayProd(flattened));
			}
		}
		return res;
	}

	private void prefix(double[][] matrix, double[][] prefix_prod, int[][] prefix_zeros) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0) {
					prefix_prod[i][j] = matrix[i][j] == 0 ? 1 : matrix[i][j];
					prefix_zeros[i][j] = matrix[i][j] == 0 ? 1 : 0;
				} else {
					prefix_prod[i][j] = matrix[i][j] == 0 ? prefix_prod[i - 1][j] : prefix_prod[i - 1][j] * matrix[i][j];
					prefix_zeros[i][j] = matrix[i][j] == 0 ? prefix_zeros[i - 1][j] + 1 : prefix_zeros[i - 1][j];
				}
			}
		}
	}

	private double largestSubArrayProd(double[] array) {
		double local_max = array[0];
		double local_min = array[0];
		double global_max = array[0];
		for (int i = 1; i < array.length; i++) {
			double local_max_copy = local_max;
			local_max = Math.max(Math.max(array[i] * local_max, array[i]), array[i] * local_min);
			local_min = Math.min(Math.min(array[i] * local_max_copy, array[i]), array[i] * local_min);
			global_max = Math.max(global_max, local_max);
		}
		return global_max;
	}
	
	public static void main(String[] args) {
		LargestSubMatrixProduct test = new LargestSubMatrixProduct();
		 double[][] matrix = {{2.0, -1.0, 0.5, 1.0, -3.0}, {0.0, -2.0, -1.0, 2.0, 0.1}, {3.0, 0.2, 1.0, -3.0, -2.0}};
		//double[][] matrix = {{0.0, -0.2, 0.0, -1.0}, {-4.0, 0.0, -1.0, 0.0}};
		System.out.println(test.largest(matrix));
	}
}
