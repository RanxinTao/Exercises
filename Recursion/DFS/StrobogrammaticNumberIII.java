package DFS;

import java.util.LinkedList;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 * Note: Because the range might be a large number, the low and high numbers are represented as string.
 * 
 * Examples:
 * 1. Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
 * 
 * Thoughts: A better solution can be found here: 
 * https://evelynn.gitbooks.io/google-interview/content/strobogrammatic_number_iii.html
 * We actually don't need to construct the strobogrammatic number from scratch, we can construct from low to high. 
 * Also, we can take advantage of built-in compareTo() function to simplify the implementation.
 * 
 * Time: O(n), where n is the count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 * Space: O(logn)
 */
public class StrobogrammaticNumberIII {
	private static int[][] pairs = {{0, 0}, {1, 1}, {8, 8}, {6, 9}, {9, 6}};
	
	public int strobogrammaticInRange(String low, String high) {
		int[] cnt = new int[1];
		cnt[0] = 0;
		List<Integer> num = new LinkedList<>();
		count(low, high, num, cnt); // execute as an empty list so we include numbers like 88.
		for (int[] pair : pairs) {
			if (pair[0] == pair[1]) {
				num.add(pair[0]);
				count(low, high, num, cnt);
				num.remove(0);
			}
		}
		return cnt[0];
	}
	
	private void count(String low, String high, List<Integer> cur, int[] cnt) {
		if (compare(high, cur) < 0) {
			return;
		}
		if (isValidNum(cur) && compare(low, cur) <= 0) { // in range means low <= num <= high
			cnt[0]++;
		}		
		for (int[] pair : pairs) {
			cur.add(pair[0]);
			cur.add(0, pair[1]);
			count(low, high, cur, cnt);
			cur.remove(cur.size() - 1); // remove the last digit
			cur.remove(0); // remove the first digit
		}
	}
	
	private int compare(String num1, List<Integer> num2) { // can't convert the range to integer because it might be a large number
		int len1 = num1.length();
		int len2 = num2.size();
		if (len1 != len2) {
			return len1 - len2;
		}
		for (int i = 0; i < num1.length(); i++) {
			int digit1 = num1.charAt(i) - '0';
			int digit2 = num2.get(i);
			if (digit1 != digit2) {
				return digit1 - digit2;
			}
		}
		return 0; // two numbers are equal
	}
	
	private boolean isValidNum(List<Integer> num) { // we should not count numbers that start with 0, except 0 itself
		return (num.size() == 1 || (num.size() > 1 && num.get(0) != 0));
	}
	
	public static void main(String[] args) {
		StrobogrammaticNumberIII test = new StrobogrammaticNumberIII();
		//String low = "50";
		//String high = "100";
		String low = "0";
		String high = "1";
		System.out.println(test.strobogrammaticInRange(low, high));
	}
}
