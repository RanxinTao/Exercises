package check1_other;

/**
 * Determine if the given integer array has three indices such that i < j < k and a[i] < a[j] < a[k].
 * 
 * Assumptions: 
 * 1. The given array is not null.
 * 
 * Examples: 
 * 1. {1, 5, 2, 4}, return true since i = 0, j = 2, k = 3
 * 2. {4, 3, 2, 1}, return false
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class AscendingTripleI {
	public boolean existIJK(int[] array) {
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		for (int num :  array) {
			if (num < smallest) {
				smallest = num;
			} else if (num < secondSmallest) { // current number > smallest but < second smallest
				secondSmallest = num;
			} else if (num > secondSmallest) { // current number > smallest and also > second smallest
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		AscendingTripleI test = new AscendingTripleI();
		System.out.println(test.existIJK(new int[] {1, 1, 1, 1}));
	}
}
