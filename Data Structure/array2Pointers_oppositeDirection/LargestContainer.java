package array2Pointers_oppositeDirection;

/**
 * Given an array of non-negative integers, each of them representing the height of a board perpendicular to the horizontal line, 
 * the distance between any two adjacent boards is 1. Consider selecting two boards such that together with the horizontal line they 
 * form a container. Find the volume of the largest such container.
 * 
 * Assumptions:
 * The given array is not null and has size of at least 2
 * Examples:
 * { 2, 1, 3, 1, 2, 1 }, the largest container is formed by the two boards of height 2, the volume of the container is 2 * 4 = 8.
 */
public class LargestContainer {
	public int largest(int[] array) {
		int maxRes = 0;
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int curRes = Math.min(array[left], array[right]) * (right - left);
			maxRes = Math.max(maxRes, curRes);
			if (array[left] < array[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxRes;
	}
}
