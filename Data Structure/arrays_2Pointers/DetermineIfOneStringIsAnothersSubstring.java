package arrays_2Pointers;

/**
 * Determine if a small string is a substring of another large string.
 * Return the index of the first occurrence of the small string in the large string. Return -1 if the small string is 
 * not a substring of the large string.
 * 
 * Assumptions:
 * 1. Both large and small are not null
 * 2. If small is empty string, return 0
 * Examples:
 * 1. "ab" is a substring of "bcabc", return 2
 * 2. "bcd" is not a substring of "bcabc", return -1
 * 3. "" is substring of "abc", return 0
 * 
 * Time: O(mn)
 * Space: O(1)
 */
public class DetermineIfOneStringIsAnothersSubstring {
	public int strstr(String large, String small) {
		if (small.length() == 0) {
			return 0;
		}
		for (int i = 0; i <= large.length() - small.length(); i++) {
			boolean match = true;
			for (int j = 0; j < small.length(); j++) {
				if (large.charAt(i + j) != small.charAt(j)) {
					match = false; 
					break;
				}
			}
			if (match) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		DetermineIfOneStringIsAnothersSubstring test = new DetermineIfOneStringIsAnothersSubstring();
		String large = "abcdefghijklmnopqrstuvwxyzzabcdefghijklmnopqrstu";
		String small = "qrstuvwxyzzabcdefghijklmnopqrstu";
		System.out.println(test.strstr(large, small));
	}
}
