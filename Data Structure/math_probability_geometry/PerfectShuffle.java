package math_probability_geometry;

import java.util.Random;

import impl.Utils;

public class PerfectShuffle {
	public void shuffle(int[] array) {
		Random random = new Random();
		for (int i = array.length - 1; i >= 1; i--) {
			int randomIndex = random.nextInt(i + 1);
			swap(array, i, randomIndex);
		}
	}
	
	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void main(String[] args) {
		PerfectShuffle test = new PerfectShuffle();
		// corner case
		int[] array = {1};
		// int[] array = {1, 2, 3, 4, 5};
		test.shuffle(array);
		Utils.printArray(array);	
	}
}
