package largestAreaOf1s;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Determine the largest rectangle of 1s in a binary matrix (a binary matrix only contains 0 and 1), 
 * return the area.
 * 
 * Assumptions:
 * The given matrix is not null and has size of M * N, M >= 0 and N >= 0
 * Examples:
 * {{0, 0, 0, 0},
 *  {1, 1, 1, 1},
 *  {0, 1, 1, 1},
 *  {1, 0, 1, 1}}
 * the largest rectangle of 1s has area of 2 * 3 = 6
 */
public class LargestRectangleOf1s {
	public int largest(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int res = 0;
		int[] heights = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				heights[j] = matrix[i][j] == 0 ? 0 : heights[j] + 1;
			}
			res = Math.max(largestRectangleArea(heights), res);
		}
		return res;
	}

	private int largestRectangleArea(int[] array) {
		int res = 0;
		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i <= array.length; i++) {
			// explicitly add a bar of height 0, to pop out all the elements in the stack at last
			int curHeight = i == array.length ? 0 : array[i];
			while (!stack.isEmpty() && array[stack.peekFirst()] >= curHeight) {
				int height = array[stack.pollFirst()];
				int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
				res = Math.max(res, height * (i - left));
			}
			stack.offerFirst(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		LargestRectangleOf1s test =  new LargestRectangleOf1s();
		int[][] matrix = {{0,0,0,0}, {1,1,1,1}, {0,1,1,1}, {1,0,1,1}};
		System.out.println(test.largest(matrix));
	}
}
