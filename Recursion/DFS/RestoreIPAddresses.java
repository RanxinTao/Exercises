package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by retiring all possible valid IP address combinations.
 * IP address has 4 segments, every segments ranged from 0 to 255 (both inclusive).
 * 
 * Examples:
 * 1. Input: "25525511135", output: ["255.255.11.135", "255.255.111.35"]
 * 
 * Time: O(n^3)
 * Space: O(1)
 */
public class RestoreIPAddresses {
	public List<String> Restore(String ip) {
		List<String> res = new ArrayList<>();
		restore(ip, 0, new int[3], 0, res);
		return res;
	}
	
	private void restore(String ip, int start, int[] splits, int index, List<String> res) {
		if (index == 3) {
			if (isValidSeg(ip, start, ip.length() - 1)) {
				String seg1 = ip.substring(0, splits[0]);
				String seg2 = ip.substring(splits[0], splits[1]);
				String seg3 = ip.substring(splits[1], splits[2]);
				String seg4 = ip.substring(splits[2]);
				res.add(seg1 + '.' + seg2 + '.' + seg3 + '.' + seg4);
			}
			return;
		}
		for (int i = start; i <= start + 2; i++) {
			if (isValidSeg(ip, start, i)) {
				splits[index] = i + 1;
				restore(ip, i + 1, splits, index + 1, res);
			}
		}
	}
	
	private boolean isValidSeg(String ip, int start, int end) {
		if (start > end || end >= ip.length()) { // don't forget condition start > end
			return false;
		}
		int val = 0;
		int factor = 1;
		for (int i = end; i >= start; i--) {
			int digit = ip.charAt(i) - '0';
			val += digit * factor;
			factor *= 10;
		}
		int first = ip.charAt(start) - '0'; // first digit
		return val != 0 && first == 0 ? false : val <= 255;
	}
	
	public static void main(String[] args) {
		RestoreIPAddresses test = new RestoreIPAddresses();
		String ip = "25525511135";
		System.out.println(test.Restore(ip));
	}
}
