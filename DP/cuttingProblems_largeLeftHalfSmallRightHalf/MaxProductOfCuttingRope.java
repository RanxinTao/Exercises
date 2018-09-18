package cuttingProblems_largeLeftHalfSmallRightHalf;

/**
 * Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length 
 * p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? 
 * m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.
 * 
 * Assumptions: n >= 2 (length >= 2)
 * Examples: n = 12, the max product is 3 * 3 * 3 * 3 = 81 (cut the rope into 4 pieces with length of each is 3).
 */
public class MaxProductOfCuttingRope {
	public int maxProduct(int length) {
		int[] maxProducts = new int[length + 1]; // maxProducts[n] represents the max product of cutting length n (at least one cut)
		for (int i = 2; i <= length; i++) {
			for (int j = 1; j < i; j++) {
				// consider both no cut case and cut case in the left half
				int curMax = Math.max(j, maxProducts[j]) * (i - j);
				maxProducts[i] = Math.max(maxProducts[i], curMax);
			}
		}
		return maxProducts[length];
	}
	
	public static void main(String[] args) {
		MaxProductOfCuttingRope test = new MaxProductOfCuttingRope();
		int length = 12;
		System.out.println(test.maxProduct(length));
	}
}
