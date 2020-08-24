package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given eight cards with number 0, 1, 2, ..7 on them, the cards are placed in two rows with 4 cards in each row. In each step
 * only card 0 could swap with one of its adjacent(top, right, bottom, left) card. Your goal is to make all cards placed in order
 * like this:
 * 0 1 2 3
 * 4 5 6 7
 * Find the minimum number of steps from the given state to the final state. If there is no way to the final state, then return -1.
 * The state of cards is represented by an array of integer, for example [0, 1, 2, 3, 4, 5, 6, 7] where the first four numbers are
 * in the first row from left to right while the others are placed in the second row from left to right.
 * 
 * Examples:
 * Input: [4, 1, 2, 3, 5, 0, 6, 7]     Output: 2
 * Initial state is:
 * 4 1 2 3
 * 5 0 6 7
 * First swap 0 with 5, then the state is:
 * 4 1 2 3
 * 0 5 6 7
 * Then swap 0 with 4, then we get the final state:
 * 0 1 2 3
 * 4 5 6 7
 *  
 * Time: O(1)
 * Space: O(1)
 */
public class SevenPuzzle {
	public static int[][] swapTgts = {{1, 4}, {0, 2, 5}, {1, 3, 6}, {2, 7}, {0, 5}, {1, 4, 6}, {2, 5, 7}, {3, 6}};
	
	public int numOfSteps(int[] values) {
		int res = 1;
		List<Integer> begin = new ArrayList<>();
		for (int value : values) {
			begin.add(value);
		}
		List<Integer> end = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
		if (begin.equals(end)) {
			return 0;
		}
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.offer(begin);
		Set<List<Integer>> visited = new HashSet<>();
		visited.add(begin);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				List<Integer> cur = queue.poll();
				int idx0 = cur.indexOf(0);
				int[] curSwapTgts = swapTgts[idx0];
				for (int tgt : curSwapTgts) {
					Collections.swap(cur, idx0, tgt);
					if (cur.equals(end)) {
						return res;
					}
					List<Integer> copy = new ArrayList<>(cur);
					if (visited.add(copy)) {
						queue.offer(copy);
					}
					Collections.swap(cur, idx0, tgt);
				}
			}
			res++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] values = {4, 1, 2, 3, 5, 0, 6, 7};
		SevenPuzzle test = new SevenPuzzle();
		System.out.println(test.numOfSteps(values));
	}
}
