package array1Pointer;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * 
 * Assumptions:
 * 1. You may assume that word1 does not equal to word2.
 * 2. word1 and word2 are both in the list.
 * 
 * Examples:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 1. Given word1 = "coding", word2 = "practice", return 3.
 * 2. Given word1 = "makes", word2 = "coding", return 1.
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		int shortest = Integer.MAX_VALUE;
		int idx1 = -1;
		int idx2 = -1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
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
		ShortestWordDistance test = new ShortestWordDistance();
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String word1 = "coding";
		String word2 = "makes";
		System.out.println(test.shortestDistance(words, word1, word2));
	}
}
