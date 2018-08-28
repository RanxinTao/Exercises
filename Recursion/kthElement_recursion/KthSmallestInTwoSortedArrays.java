package kthElement_recursion;

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
	
	public static void main(String[] args) {
		KthSmallestInTwoSortedArrays test = new KthSmallestInTwoSortedArrays();
		int[] a = new int[] {1,4,5,5,8,12,12,12};
		int[] b = new int[] {2,2,3,7,9,9,9};
		int k = 13;
		System.out.println(test.kth(a, b, k));
	}
}
