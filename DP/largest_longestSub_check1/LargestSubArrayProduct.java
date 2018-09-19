package largest_longestSub_check1;

/**
 * Given an unsorted array of doubles, find the subarray that has the greatest product. Return the product.
 * 
 * Assumptions: 
 * array is not null and has length >= 1
 * Examples:
 * {2.0, -0.1, 4, -2, -1.5}, the largest subarray product is 4 * (-2) * (-1.5) = 12
 */
public class LargestSubArrayProduct {
	public double largestProduct(double[] array) {
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
}
