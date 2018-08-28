package test;

import array2Pointers_oppositeDirection.TwoSumAllPairII;

public class TestTwoSumAllPairII {
	public static void main(String[] args) {
		TwoSumAllPairII test = new TwoSumAllPairII();
		int[] array = {2, 1, 3, 2, 4, 3, 4, 2};
		int target = 6;
		System.out.println(test.allPairs(array, target));
	}
}
