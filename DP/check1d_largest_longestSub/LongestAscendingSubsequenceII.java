package check1d_largest_longestSub;

import java.util.ArrayList;
import java.util.List;

import impl.Utils;

/**
 * Given an array A[0]...A[n-1] of integers, find out the longest ascending subsequence.
 * If there are multiple results, then return any valid result.
 * 
 * Assumptions: array is not null
 * 
 * Examples:
 * Input: A = {5, 2, 6, 3, 4, 7, 5} Output: {2, 3, 4, 5}, 
 * Because [2, 3, 4, 5] is one of the longest ascending subsequences.
 * 
 * Time: O(n^2)
 * Space: O(n^2)
 */
public class LongestAscendingSubsequenceII {
	public int[] longest(int[] a) {
		List<List<Integer>> longest = new ArrayList<>(); // longest ascending subsequences for each element in the array
		for (int i = 0; i < a.length; i++) {
			List<Integer> curLongest = new ArrayList<>(); 
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && longest.get(j).size() > curLongest.size()) {
					curLongest = longest.get(j);
				}
			}
			curLongest = new ArrayList<>(curLongest); // don't forget to create a new list, otherwise previous results will be changed
			curLongest.add(a[i]);
			longest.add(curLongest);
		}
		List<Integer> longestSeq = new ArrayList<>(); 
		for (int i = 0; i < longest.size(); i++) {
			if (longest.get(i).size() > longestSeq.size()) {
				longestSeq = longest.get(i);
			}
		}
		int[] res = new int[longestSeq.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = longestSeq.get(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		LongestAscendingSubsequenceII test = new LongestAscendingSubsequenceII();
		int[] array = {5, 2, 6, 3, 4, 7, 5};
		Utils.printArray(test.longest(array));
	}
}
