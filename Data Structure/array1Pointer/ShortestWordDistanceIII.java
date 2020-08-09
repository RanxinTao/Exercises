package array1Pointer;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 * 
 * Assumptions:
 * 1. word1 and word2 are both in the list.
 * 
 * Examples:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 1. Given word1 = "makes", word2 = "coding", return 1.
 * 1. Given word1 = "makes", word2 = "makes", return 3.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int shortest = Integer.MAX_VALUE;
		int idx1 = -1;
		int idx2 = -1;
		for (int i = 0; i < words.length; i++) {
			if (word1.equals(word2)) {
				if (words[i].equals(word1)) {
					idx1 = idx2;
					idx2 = i;
				}
			} else if (words[i].equals(word1)) {
				idx1 = i;
			} else if (words[i].equals(word2)) {
				idx2 = i;
			}
			if (idx1 != -1 && idx2 != -1) {
				shortest = Math.min(shortest, Math.abs(idx1 - idx2));
			}
		}
		return shortest;
	}
	
	public static void main(String[] args) {
		ShortestWordDistanceIII test = new ShortestWordDistanceIII();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "makes";
		String word2 = "makes";
		System.out.println(test.shortestWordDistance(words, word1, word2));
	}
}
