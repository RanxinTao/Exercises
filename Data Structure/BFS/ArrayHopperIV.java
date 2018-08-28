package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Assumptions: array is not null and has length >= 1
 * Examples:
 * {1, 3, 1, 2, 2}, if the initial position is 2, the minimum jumps needed is 2 (jump to index 1 then to the right end of array).
 * {3, 3, 1, 0, 0}, if the initial position is 2, the minimum jumps needed is 2 (jump to index 1 then to the right end of array).
 * {4, 0, 1, 0, 0}, if the initial position is 2, not able to reach the right end of array, return -1 in this case.	
 * Algorithm: BFS
 */
public class ArrayHopperIV {
	public int minJump(int[] array, int index) {
		if (index == array.length - 1) {
			return 0;
		}
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[array.length];
		queue.offer(index);
		visited[index] = true;
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int k = 0; k < size; k++) {
				int curI = queue.poll();
				for (int i = Math.max(curI - array[curI], 0); i <= Math.min(curI + array[curI], array.length - 1); i++) {
					if (i == array.length - 1) {
						return level;
					} else {
						if (!visited[i]) {
							queue.offer(i);
							visited[i] = true;
						}
					}
				}
			}
			level++;
		}
		return -1;
	}

	public static void main(String[] args) {
		ArrayHopperIV test = new ArrayHopperIV();
		int[] array = new int[] {1, 3, 1, 2, 2};
		System.out.println(test.minJump(array, 0));
	}
}
