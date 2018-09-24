package math_probability_geometry;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of 2D coordinates of points (all the coordinates are integers), 
 * find the largest number of points that can be crossed by a single line in 2D space.
 * 
 * Assumptions:
 * The given array is not null and it has at least 2 points
 * 
 * Examples:
 * <0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum number of points on a line is 3(<0, 0>, <1, 1>, <3, 3> are on the same line)
 */
public class MostPointsOnALine {
	public int most(Point[] points) {
		int res = 0;
		for (int i = 0; i < points.length; i++) {
			Point p1 = points[i];
			// record the points with same (x, y)
			int same = 1;
			// record the points with same x
			int sameX = 0;
			// a map with all possible slopes
			Map<Double, Integer> counts = new HashMap<>();
			// record the maximum number of points on the same line crossing the current point
			int most = 0;
			for (int j = i + 1; j < points.length; j++) {
				Point p2 = points[j];
				if (p1.x == p2.x && p1.y == p2.y) {
					same++;
				} else if (p1.x == p2.x) {
					sameX++;
				} else {
					double slope = ((double) (p1.y - p2.y)) / (p1.x - p2.x);
					Integer count = counts.get(slope);
					if (count == null) {
						count = 1;
					} else {
						count++;
					}
					counts.put(slope, count);
					most = Math.max(most, count);
				}
			}
			most = Math.max(most, sameX) + same;
			res = Math.max(res, most);
		}
		return res;
	}
}

class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}