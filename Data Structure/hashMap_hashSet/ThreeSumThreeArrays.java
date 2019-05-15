package hashMap_hashSet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Given three arrays, determine if a set can be made by picking one element from each array that sums to the given target number.
 * 
 * Assumptions: 
 * The three given arrays are not null and have length of at least 1
 * 
 * Examples:
 * A = {1, 3, 5}, B = {8, 2}, C = {3}, target = 14, return true (pick 3 from A, pick 8 from B and pick 3 from C)
 */
public class ThreeSumThreeArrays {
	public boolean exist(int[] a, int[] b, int[] c, int target) {
		int[][] arrays = {a, b, c};
		Arrays.sort(arrays, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				return ((Integer) arr1.length).compareTo(arr2.length);
			} 
		});
		for (int num : arrays[2]) {
			int newTarget = target - num;
			if (existTwoSum(arrays[0], arrays[1], newTarget)) {
				return true;
			}
		}
		return false;
	}

	private boolean existTwoSum(int[] shorter, int[] longer, int target) {
		Set<Integer> set = new HashSet<>();
		for (int num : shorter) {
			set.add(num);
		}
		for (int num : longer) {
			int diff = target - num;
			if (set.contains(diff)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		ThreeSumThreeArrays test = new ThreeSumThreeArrays();
		int[] a = {-1,0,1};
		int[] b = {3,7,2};
		int[] c = {4,9};
		int target = 14;
		System.out.println(test.exist(a, b, c, target));
	}
}
