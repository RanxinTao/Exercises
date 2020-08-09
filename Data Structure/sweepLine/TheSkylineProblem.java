package sweepLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import impl.Utils;

/**
 * A city's skyline is the outer coutour of the silhouette formed by all the buildings in that city when viewed from a distance.
 * Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo, write a program to
 * output the skyline formed by these buildings collectively.
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x
 * coordinates of the left and right edge of the ith building, respectively, and Hi is its height. 
 * The output is a list of "key points" in the format of [[x1, y1], [x2, y2], [x3, y3], ...] that uniquely defines a skyline.
 * A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building
 * ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any
 * two adjacent buildings should be considered part of the skyline contour.
 * The output list must be sorted by the x position, and there must be no consecutive horizontal lines of equal height in the
 * output skyline. For instance, [..., [2, 3], [4, 5], [7, 5], [11, 5], [12, 7], ...] is not acceptable; the three lines of height
 * 5 should be merged into one in the final output as such: [..., [2, 3], [4, 5], [12, 7], ...]
 * 
 * Assumptions:
 * 1. The number of buildings in any input list is guaranteed to be in the range [0, 10000] and Ri > Li.
 * 2. The input list is already sorted in ascending order by the left x position Li.
 * 3. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * 
 * Examples:
 * 1. The dimensions of all buildings are: [[2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8]], the skyline should
 * be represented as: [[2, 10], [3, 15], [7, 12], [12, 0], [15, 10], [20, 8], [24, 0]].
 * 
 * Thoughts: use a heap to track the current max height
 * 
 * Time: O(nlogn), where n is the length of the buildings array
 * Space: O(n)
 */
public class TheSkylineProblem {
	public int[][] getSkyline(int[][] buildings) {
		List<int[]> resList = new ArrayList<>();
		Point[] starts = new Point[buildings.length];
		Point[] ends = new Point[buildings.length];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		pq.add(0); // according to the requirement, the last key point always has zero height, so we just add a zero to the heap, everytime buildings are gone, it will be touched.
		for (int i = 0; i < buildings.length; i++) {
			int[] b = buildings[i];
			starts[i] = new Point(b[0], b[2]);
			ends[i] = new Point(b[1], b[2]);
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int si = 0;
		int ei = 0;
		while (ei < ends.length) {
			if (si < ends.length && starts[si].pos <= ends[ei].pos) { // use <= not <, in case of {{1, 2, 5}, {2, 4, 10}}, where 10 should be added to the heap before 5 left
				if (pq.isEmpty() || starts[si].height > pq.peek()) { // only when a higher building entered, we update the result.
					if (resList.isEmpty() || resList.get(resList.size() - 1)[0] != starts[si].pos) {
						resList.add(new int[] {starts[si].pos, starts[si].height});
					} else if (resList.get(resList.size() - 1)[1] < starts[si].height) { // if input contains {{1, 2, 10}, {1, 3, 5}}, should not output {1, 5} and {1, 10} in the result, should only output {1, 10}, which is the larger height
						resList.get(resList.size() - 1)[1] = starts[si].height;
					}		  
				}
				pq.add(starts[si].height);
				si++;
			} else {
				pq.remove(ends[ei].height);
				if (ends[ei].height > pq.peek()) { // only when the highest building left, we update the result. Here we don't have to check if heap is empty, because at least there is a 0
					if (resList.isEmpty() || resList.get(resList.size() - 1)[0] != ends[ei].pos) {
						resList.add(new int[] {ends[ei].pos, pq.peek()});
					} else if (resList.get(resList.size() - 1)[1] > pq.peek()) { // if input contains {{1, 5, 10}, {3, 5, 4}}, should not output {5, 10} and {5, 4} in the result, should only output {5, 4}, which is the smaller height
						resList.get(resList.size() - 1)[1] = pq.peek();
					}
				}
				ei++;
			}
		}
		int[][] res = new int[resList.size()][];
		for (int i = 0; i < resList.size(); i++) {
			res[i] = resList.get(i);
		}
		return res;
	}
	
	static class Point implements Comparable<Point> {
		int pos;
		int height;
		
		public Point(int pos, int height) {
			this.pos = pos;
			this.height = height;
		}

		@Override
		public int compareTo(Point o) {
			return ((Integer) pos).compareTo((Integer) o.pos);
		}
	}
	
	public static void main(String[] args) {
		TheSkylineProblem test = new TheSkylineProblem();
		int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
		//int[][] buildings = {{1, 2, 5}, {2, 5, 10}};
		int[][] res = test.getSkyline(buildings);
		Utils.print2dArray(res);
	}
}
