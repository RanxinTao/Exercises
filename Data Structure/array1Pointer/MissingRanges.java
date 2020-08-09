package array1Pointer;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper],
 * return its missing ranges.
 * 
 * Examples:
 * 1. Given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class MissingRanges {
	public List<String> findMissingRanges(int[] num, int lower, int upper) {
		List<String> res = new ArrayList<>();
		int last = lower - 1; // why lower - 1 ? if lower = 0, array = [1, ...], 0 should be included in the result
		for (int i = 0; i < num.length; i++) {
			addRange(res, last, num[i]);
			last = num[i];
		}
		addRange(res, last, upper + 1); // why upper + 1 ? if upper = 99, array = [..., 98], 99 should be included in the result
		return res;
	}
	    
	private void addRange(List<String> res, int lo, int up) {
		if (lo + 2 == up) {
			res.add((lo + 1) + "");
		} else if (lo + 2 < up) {
			res.add((lo + 1) + "->" + (up - 1));
		}
	}
	
	public static void main(String[] args) {
		MissingRanges test = new MissingRanges();
		int[] num = {0, 1, 3, 50, 75};
		int lower = 0;
		int upper = 99;
		List<String> res = test.findMissingRanges(num, lower, upper);
		System.out.println(res);
	}
}
