package hashMap_hashSet;

/**
 * Determine if the characters of a given string are all unique.
 * 
 * Assumptions: 
 * 1. We are using ASCII charset, the value of valid characters are from 0 to 255
 * 2. The given string is not null
 * Examples:
 * 1. all the characters in "abA+\8" are unique
 * 2. "abA+\a88" contains duplicate characters
 */
public class AllUniqueCharactersII {
	public boolean allUnique(String word) {
		boolean[] visited = new boolean[256];
		for (int i = 0; i < word.length(); i++) {
			char cur = word.charAt(i);
			int curAscii = (int) cur;
			if (visited[curAscii]) {
				return false;
			} else {
				visited[curAscii] = true;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		AllUniqueCharactersII test = new AllUniqueCharactersII();
		String word = "abA+\\a88";
		System.out.println(test.allUnique(word));
	}
}
