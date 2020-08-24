package math_probability_geometry;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner.
 * 
 * Assumptions:
 * 1. Assume that the total area is never beyond the maximum possible value of int.
 * 
 * Time: O(1)
 * Space: O(1)
 * 
 * Reference: https://www.programcreek.com/2014/06/leetcode-rectangle-area-java/
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		if (C <= E || G <= A || D <= F || H <= B) { // no overlap
			return (G - E) * (H - F) + (C - A) * (D - B);
		}
		int right = Math.min(C, G);
		int left = Math.max(A, E);
		int top = Math.min(H, D);
		int bottom = Math.max(F, B);
		return (G - E) * (H - F) + (C - A) * (D - B) - (right - left) * (top - bottom);
	}
}
