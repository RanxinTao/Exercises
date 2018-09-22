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
		double localMax = array[0];
		double localMin = array[0];
		double globalMax = array[0];
		for (int i = 1; i < array.length; i++) {
			double localMaxCopy = localMax;
			localMax = Math.max(Math.max(array[i] * localMax, array[i]), array[i] * localMin);
			localMin = Math.min(Math.min(array[i] * localMaxCopy, array[i]), array[i] * localMin);
			globalMax = Math.max(globalMax, localMax);
		}
		return globalMax;
	}
}
