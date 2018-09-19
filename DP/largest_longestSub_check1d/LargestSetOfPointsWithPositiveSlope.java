package largest_longestSub_check1d;

import java.util.Arrays;
import java.util.Comparator;

import impl.Point;

/**
 * Given an array of 2D coordinates of points (all the coordinates are integers), find the largest number of points that can 
 * form a set such that any pair of points in the set can form a line with positive slope. Return the size of such a maximal set.
 * 
 * Assumptions: 
 * 1. array is not null and not empty
 * 2. Note: if there does not even exist 2 points can form a line with positive slope, should return 0.
 * Examples:
 * <0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum set of points are {<0, 0>, <1, 1>, <2, 3>}, the size is 3.
 */
public class LargestSetOfPointsWithPositiveSlope {
	public int largest(Point[] points) {
		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if (p1.x != p2.x) {
					return ((Integer) p1.x).compareTo(p2.x);
				} else {
					return ((Integer) p1.y).compareTo(p2.y);
				}
			}
		});
		return longestAscendingSubsequence(points);
	}

	private int longestAscendingSubsequence(Point[] array) {
		int[] longest = new int[array.length];
		int res = 0;
		for (int i = 0; i < longest.length; i++) {
			longest[i] = 1;
			for (int j = 0; j < i; j++) {
				if (array[i].y > array[j].y) {
					longest[i] = Math.max(longest[i], longest[j] + 1);
				}
			}
			res = Math.max(res, longest[i]);
		}
		return res == 1 ? 0 : res;
	}
}
