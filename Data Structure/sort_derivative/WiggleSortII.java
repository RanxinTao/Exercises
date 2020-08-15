package sort_derivative;

import java.util.Random;

import impl.Utils;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[i] > nums[2] < nums[3]....
 * Follow up: Can you do it in O(1) time and/or in place with O(1) extra space?
 * 
 * Assumptions:
 * 1. You may assume all input has valid answer.
 * 
 * Examples:
 * 1. Given nums = [1, 5, 1, 1, 6, 4], one possible anwser is [1, 4, 1, 5, 1, 6].
 * 2. Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Time: average O(n), worst O(n^2), because of quick select algorithm
 * Space: average O(logn), worst O(n), because of quick select algorithm
 * 
 * Reference: https://leetcode.com/problems/wiggle-sort-ii/discuss/77677/O(n)%2BO(1)-after-median-Virtual-Indexing
 */
public class WiggleSortII {
	public int[] wiggleSort(int[] nums) { // this method is not in place, but good enough
		int n = nums.length;
		int[] res = new int[n];
		quickSelect(nums, 0, n - 1, n / 2);
		int l = 0;
		int r = n - 1;
		for (int i = 0; i < n; i++) {
			res[i] = i % 2 == 0 ? nums[l++] : nums[r--];
		}
		return res;
	}
	
	private void quickSelect(int[] arr, int l, int r, int k) { // process array from index l to r such that all elements between l and k - 1 < arr[k] and all elements between k + 1 and r > arr[k] (both inclusive)
		int pIdx = partition(arr, l, r); // now all elements from index l to pi - 1 < arr[pi] and all elements from index pi + 1 to r > arr[pi] (both inclusive)
		if (k > pIdx) { // if k > pi then index l to pi are ready (both inclusive) because they are < arr[k]
			quickSelect(arr, pIdx + 1, r, k); // in this case, still need to handle pi + 1 to r such that all elements between pi + 1 and k - 1 < arr[k] and all elements between k + 1 and r > arr[k] (both inclusive)
		} else if (k < pIdx) { // if k < pi then index pi to r are ready (both inclusive) because they are > arr[k]
			quickSelect(arr, l, pIdx - 1, k); // in this case, still need to handle l to pi - 1 such that all elements between l and k - 1 < arr[k] and all elements between k + 1 and pi - 1 > arr[k] (both inclusive)
		} else { // if k == pi, then it is done because all elements between l and k - 1 < arr[k] and all elements between k + 1 and r > arr[k] (both inclusive)
			return; 
		}
	}
	
	private int partition(int[] arr, int l, int r) {
		int pIdx = l + new Random().nextInt(r - l + 1); // pivot index
		int pivot = arr[pIdx];
		swap(arr, pIdx, r);
		pIdx = l;
		for (int i = l; i < r; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, pIdx);
				pIdx++;
			}
		}
		swap(arr, pIdx, r);
		return pIdx;
	}

	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	/*public int[] wiggleSort(int[] nums) { // this method sorts the whole array first so the time complexity is no less than nlogn
		int[] res = new int[nums.length];
		Arrays.sort(nums);
		int l = 0;
		int r = nums.length - 1;
		for (int i = 0; i < nums.length; i++) {
			res[i] = i % 2 == 0 ? nums[l++] : nums[r--];
		}
		return res;
	}*/
	
	public static void main(String[] args) {
		WiggleSortII test = new WiggleSortII();
		int[] nums = {1, 5, 1, 1, 6, 4};
		Utils.printArray(test.wiggleSort(nums));
	}
}
