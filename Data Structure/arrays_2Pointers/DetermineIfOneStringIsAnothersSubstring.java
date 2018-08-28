package arrays_2Pointers;

/**
 * Assumptions: both two strings are not null
 */
public class DetermineIfOneStringIsAnothersSubstring {
	public int strstr(String large, String small) {
		if (small.length() == 0) {
			return 0;
		}
		for (int i = 0; i <= large.length() - small.length(); i++) {
			boolean found = true;
			for (int j = 0; j < small.length(); j++) {
				if (large.charAt(i + j) != small.charAt(j)) {
					found = false;
					break;
				}
			}
			if (found) {
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
