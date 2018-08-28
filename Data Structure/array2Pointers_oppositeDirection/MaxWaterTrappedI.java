package array2Pointers_oppositeDirection;

public class MaxWaterTrappedI {
	public int maxTrapped(int[] array) {
		int res = 0;
		int left = 0;
		int right = array.length - 1;
		// It needs at least 3 bars to trap water
		while (left + 1 < right) {
			if (array[left] < array[right]) {
				int min = array[left]; // bottle neck
				left++;
				while (left < right && array[left] < min) {
					res += (min - array[left]);
					left++;
				}
			} else {
				int min = array[right];
				right--;
				while (left < right && array[right] < min) {
					res += (min - array[right]);
					right--;
				}
			}
		}
		return res;
	}
}
