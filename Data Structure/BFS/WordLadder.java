package BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given a begin word, an end word and a dictionary, find the least number transformations from begin word to end word,
 * and return the length of the transformation sequence. Return 0 if there is no such transformations.
 * In each transformation, you can only change one letter, and the word should still in dictionary after each
 * transformation (including the end word).
 * 
 * Assumptions:
 * 1. All words have the same length.
 * 2. All words contain only lower case alphabetic characters.
 * 3. There is no duplicates in the word list.
 * 4. The beginWord and endWord are non-empty and are not the same.
 * 
 * Examples:
 * start = "git", end = "hot", dictionary = {"git", "hit", "hog", "hot"}
 * Output: 3 (git -> hit -> hot)
 *  
 * Time: O(kn), where k is the length of the words, n is the dictionary size.
 * Space: O(n)
 * 
 * Thoughts: on first thought this problem requires a set to record if a word has been visited before, but actually 
 * the deduplication can also be achieved by removing words from the word set.
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (beginWord.equals(endWord)) {
			return 1;
		}
		Set<String> dict = new HashSet<>(wordList);
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		int minLen = 2;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				char[] cur = queue.poll().toCharArray();
				for (int j = 0; j < cur.length; j++) {
					char chCopy = cur[j];
					for (char ch = 'a'; ch <= 'z'; ch++) {
						if (ch != chCopy) {		
							cur[j] = ch;
							String next = new String(cur);
							if (dict.contains(next)) {
								if (next.equals(endWord)) {
									return minLen;
								}
								queue.add(next);
								dict.remove(next);
							}
						}
					} 
					cur[j] = chCopy; //undo the change for the next round
				}
			}
			minLen++;
		}
        return 0;
	}
	
	public static void main(String[] args) {
		WordLadder test = new WordLadder();
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		System.out.println(test.ladderLength(beginWord, endWord, wordList));
	}
}
