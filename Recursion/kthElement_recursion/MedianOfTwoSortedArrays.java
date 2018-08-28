package kthElement_recursion;

/**
 * Given two sorted arrays of integers in ascending order, find the median value.
 * 
 * Assumptions:
 * The two given array are not null and at least one of them is not empty
 * The two given array are guaranteed to be sorted
 * 
 * Examples:
 * A = {1, 4, 6}, B = {2, 3}, median is 3
 * A = {1, 4}, B = {2, 3}, median is 2.5
 */
public class MedianOfTwoSortedArrays {
	public double median(int[] a, int[] b) {
		if ((a.length + b.length) % 2 == 1) {
			return kth(a, 0, a.length - 1, b, 0, b.length - 1, (a.length + b.length) / 2);
		} else {
			return (kth(a, 0, a.length - 1, b, 0, b.length - 1, (a.length + b.length) / 2) 
					+ kth(a, 0, a.length - 1, b, 0, b.length - 1, (a.length + b.length) / 2 - 1)) / 2.0;
		}
	}

	private int kth(int[] a, int aLeft, int aRight, int[] b, int bLeft, int bRight, int k) {
		if (aLeft > aRight) {
			return b[bLeft + k];
		}
		if (bLeft > bRight) {
			return a[aLeft + k];
		}
		// calculate length
		int aHalf = (aRight - aLeft) / 2;
		int bHalf = (bRight - bLeft) / 2;
		// calculate index
		int aMid = aLeft + aHalf;
		int bMid = bLeft + bHalf;
		if (aHalf + bHalf < k) {
			return a[aMid] < b[bMid] ? kth(a, aMid + 1, aRight, b, bLeft, bRight, k - (aHalf + 1)) : // drop left half of A
				kth(a, aLeft, aRight, b, bMid + 1, bRight, k - (bHalf + 1)); // drop left half of B
		} else { // aHalf + bHalf > k
			return a[aMid] < b[bMid] ? kth(a, aLeft, aRight, b, bLeft, bMid - 1, k) : // drop right half of B
				kth(a, aLeft, aMid - 1, b, bLeft, bRight, k); // drop right half of A
		}
	}
	
	/* test */
	public static void main(String[] args) {
		MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
		int[] a = {1,4};
		int[] b = {2,3};
		System.out.println(test.median(a, b));
	}
}
