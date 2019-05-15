package hashMap_hashSet;

/**
 * Determine if the characters of a given string are all unique.
 * 
 * Assumptions: 
 * 1. The only set of possible characters used in the string are 'a' - 'z', the 26 lower case letters.
 * 2. The given string is not null.
 * 
 * Examples:
 * The characters used in "abcd" are unique, the characters used in "aba" are not unique
 */
public class AllUniqueCharactersI {
	public boolean allUnique(String word) {
		boolean[] visited = new boolean[26];
		for (int i = 0; i < word.length(); i++) {
			char cur = word.charAt(i);
			if (visited[cur - 'a']) {
				return false;
			} else {
				visited[cur - 'a'] = true;
			}
		}
		return true;
	}
}
