package kthElement_recursion;

/**
 * Given two sorted arrays of integers, find the Kth smallest number.
 * 
 * Assumptions:
 * 1. The two given arrays are not null and at least one of them is not empty.
 * 2. K >= 1, K <= total lengths of the two sorted arrays.
 * 
 * Examples:
 * 1. A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
 * 2. A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
 * 
 * Time: O()
 * Space: O()
 */
public class KthSmallestInTwoSortedArrays {
	public int kth(int[] a, int[] b, int k) {
		return kth(a, 0, a.length - 1, b, 0, b.length - 1, k - 1);
	}

	private int kth(int[] a, int aLeft, int aRight, int[] b, int bLeft, int bRight, int k) {
		if (aLeft > aRight) {
			return b[bLeft + k];
		}
		if (bLeft > bRight) {
			return a[aLeft + k];
		}
		int aHalf = (aRight - aLeft) / 2;
		int aMid = aLeft + aHalf; // calculate the middle of A
		int bHalf = (bRight - bLeft) / 2;
		int bMid = bLeft + bHalf; // calculate the middle of B
		if (aHalf + bHalf < k) {
			return a[aMid] < b[bMid] ? kth(a, aMid + 1, aRight, b, bLeft, bRight, k - (aHalf + 1)) : // drop left half of A
				kth(a, aLeft, aRight, b, bMid + 1, bRight, k - (bHalf + 1)); // drop left half of B
		} else { // aHalf + bHalf >= k
			return a[aMid] < b[bMid] ? kth(a, aLeft, aRight, b, bLeft, bMid - 1, k) : // drop right half of B
				kth(a, aLeft, aMid - 1, b, bLeft, bRight, k); // drop right half of A
		}
	}
	
	public static void main(String[] args) {
		KthSmallestInTwoSortedArrays test = new KthSmallestInTwoSortedArrays();
		int[] a = new int[] {1, 4, 5, 5, 8, 12, 12, 12};
		int[] b = new int[] {2, 2, 3, 7, 9, 9, 9};
		int k = 13;
		System.out.println(test.kth(a, b, k));
	}
}
