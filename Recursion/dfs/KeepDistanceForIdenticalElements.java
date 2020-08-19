package dfs;

import java.util.LinkedList;
import java.util.List;

import impl.Utils;

/**
 * Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ..., k - 1, k - 1, k, k], such that the
 * output integer array satisfy the condition:
 * Between each two i's, there are exactly i integers (for example: between the two 1s, there is one number, between
 * the two 2's there are two numbers).
 * if there does not exist such sequence, return null.
 * 
 * Assumptions:
 * 1. k is guaranteed to be > 0
 * 
 * Examples:
 * 1. k = 3. The output = {2, 3, 1, 2, 1, 3}.
 * 
 * Time: O(k!)
 * Space: O(k)
 */
public class KeepDistanceForIdenticalElements {
	public int[] keepDistance(int k) {
		int[] res = new int[2 * k];
		int[] numToResIdx = new int[k + 1];
		List<Integer> nums = new LinkedList<>();
		for (int i = 1; i <= k; i++) {
			nums.add(i);
			nums.add(i);
			numToResIdx[i] = -1;
		}
		return putNumAtIdx(nums, numToResIdx, 0, res) ? res : null;
	}
	
	private boolean putNumAtIdx(List<Integer> nums, int[] numToResIdx, int resIdx, int[] res) {
		if (resIdx == res.length) {
			return true;
		}
		for (int i = 0; i < nums.size(); i++) {
			int curNum = nums.get(i);
			int left = numToResIdx[curNum];
			if (left == -1) { // current candidate appears for the 1st time.
				res[resIdx] = curNum;
				numToResIdx[curNum] = resIdx;
				nums.remove(i);
				if (putNumAtIdx(nums, numToResIdx, resIdx + 1, res)) {
					return true;
				}
				numToResIdx[curNum] = -1;
				nums.add(curNum);
				i++; // if this is the first appearance, we can skip the next same number again.
			} else if (resIdx - left - 1 == curNum) { // current candidate appears for the 2nd time and meets requirement.
				res[resIdx] = curNum;
				nums.remove(i);
				if (putNumAtIdx(nums, numToResIdx, resIdx + 1, res)) {
					return true;
				}
				nums.add(curNum);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		KeepDistanceForIdenticalElements test = new KeepDistanceForIdenticalElements();
		Utils.printArray(test.keepDistance(4));
	}
}
