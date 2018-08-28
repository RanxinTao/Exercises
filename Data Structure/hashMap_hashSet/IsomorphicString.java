package hashMap_hashSet;

/**
 * Two Strings are called isomorphic if the letters in one String can be remapped to get the second String. Remapping a letter means 
 * replacing all occurrences of it with another letter. The ordering of the letters remains unchanged. The mapping is two way and no two 
 * letters may map to the same letter, but a letter may map to itself. Determine if two given String are isomorphic.
 * 
 * Assumptions: 
 * The two given Strings are not null.
 * Examples:
 * "abca" and "xyzx" are isomorphic since the mapping is 'a' <-> 'x', 'b' <-> 'y', 'c' <-> 'z'.
 * "abba" and "cccc" are not isomorphic.
 */
public class IsomorphicString {
	public boolean isomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] s_counts = new int[256];
		int[] t_counts = new int[256];
		for (int i = 0; i < s.length(); i++) {
			s_counts[s.charAt(i)]++;
			t_counts[t.charAt(i)]++;
			if (s_counts[s.charAt(i)] != t_counts[t.charAt(i)]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		IsomorphicString test = new IsomorphicString();
		String s = "abba";
		String t = "xyyc";
		System.out.println(test.isomorphic(s, t));
	}
}
