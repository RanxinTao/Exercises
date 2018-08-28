package test;

import array2Pointers_oppositeDirection.TwoSumAllPairI;

public class TestTwoSumAllPairI {
	public static void main(String[] args) {
		TwoSumAllPairI test = new TwoSumAllPairI();
		int[] array = {1,3,2,4};
		int target = 5;
		System.out.println(test.allPairs(array, target));
	}
}
