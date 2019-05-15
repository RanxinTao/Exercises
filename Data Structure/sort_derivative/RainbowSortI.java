package sort_derivative;
import static impl.Utils.*;

/**
 * Given an array of balls, where the color of the balls can only be Red, Green or Blue, sort the balls such that 
 * all the Red balls are grouped on the left side, all the Green balls are grouped in the middle and all the Blue 
 * balls are grouped on the right side. (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).
 * 
 * Examples:
 * 1. {0} is sorted to {0}
 * 2. {1, 0} is sorted to {0, 1}
 * 3. {1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
 * 4. Assumptions: The input array is not null.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class RainbowSortI {
	public int[] rainbowSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}	
		int neg = 0; // the left side of neg are -1 (exclusive of neg)
		int zero = 0; // current index, the part between neg and zero are 0 (exclusive of zero)
		int one = array.length - 1; // the right side of one are 1 (exclusive of one)
		// between zero and one are to be discovered (inclusive of both)
		while (zero <= one) {
			if (array[zero] == -1) {
				swap(array, neg, zero);
				neg++;
				zero++;
			} else if (array[zero] == 0) {
				zero++;
			} else if (array[zero] == 1) {
				swap(array, zero, one);
				one--;
			}
		}
		return array;
	}
	
	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void main(String[] args) {
		RainbowSortI test = new RainbowSortI();
		int[] array = new int[] {1, 0, 1, -1, 0};
		printArray(test.rainbowSort(array));
	}
	
}
