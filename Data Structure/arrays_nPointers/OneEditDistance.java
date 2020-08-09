package arrays_nPointers;

/**
 * Determine if two given Strings are one edit distance. One edit distance means you can only insert/delete/replace one
 * character to another character in one of the two given Strings and they will become identical.
 * 
 * Assumptions:
 * 1. The two given Strings are not null.
 * 
 * Examples:
 * 1. s = "abc", t = "ab" are one edit distance since you can remove the trailing 'c' from s so that s and t are identical.
 * 2. s = "abc", t = "bcd" are not one edit distance.
 * 
 * Time: O(m + n) where m is the length of the source and n is the length of the target
 * Space: O(1)
 */
public class OneEditDistance {
	public boolean oneEditDistance(String source, String target) {
		int si = 0;
		int ti = 0;
		int editRemain = 1;
		while (si < source.length() && ti < target.length()) {
			if (source.charAt(si) == target.charAt(ti)) {
				si++;
				ti++;
			} else if (editRemain == 0) {
				return false;
			} else {
				if (source.length() == target.length()) {
					si++;
					ti++;
				} else if (source.length() > target.length()) {
					si++;
				} else {
					ti++;
				}
				editRemain--;
			}
		}
		return source.length() - si + target.length() - ti == editRemain; // should return false when source and target are same
	}
	
	public static void main(String[] args) {
		OneEditDistance test = new OneEditDistance();
		String source = "abcdefggg";
		String target = "abcdef";
		System.out.println(test.oneEditDistance(source, target));
	}
}
