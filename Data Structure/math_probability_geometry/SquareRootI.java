package math_probability_geometry;

/**
 * Given an integer number n, find its integer square root.
 * 
 * Assumptions:
 * n is guaranteed to be >= 0.
 * 
 * Examples:
 * 1. Input: 18, Return: 4
 * 2. Input: 4, Return: 2
 */
public class SquareRootI {
	public int sqrt(int x) {
		int left = 1;
		int right = x / 2;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
				return mid;
			} else if (mid > x / mid) {
				right = mid - 1;
			} else { // (mid+1) <= x/(mid+1)
				left = mid + 1;
			}
		}
		return x;
	}

	public static void main(String[] args) {
		SquareRootI test = new SquareRootI();
		int x = 4;
		System.out.println(test.sqrt(x));
	}
}
