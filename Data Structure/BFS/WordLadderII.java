package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given a begin word, an end word and a dictionary, find the least number transformations from begin word to end word,
 * and return the transformation sequence. Return empty list if there is no such transformations.
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
 * start = "git", end = "hot", dictionary = {"git", "hit", "hog", "hot", "got"}
 * Output: [["git","hit","hot"], ["git","got","hot"]]
 *  
 * Time: O(kn), where k is the length of the words, n is the dictionary size.
 * Space: O(n)
 * 
 * Thoughts: A visited set must be used in this problem, without the visited set, when no transformations, there is a chance to cause infinite loop.
 * We can just use the visited set for both problems.
 */
public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<>();
		Set<String> dict = new HashSet<>(wordList);
		Set<String> visited = new HashSet<>();
		Queue<List<String>> queue = new LinkedList<>();
		List<String> seq = new ArrayList<>();
		seq.add(beginWord);
		queue.add(seq);
		visited.add(beginWord);
		while (!queue.isEmpty() && res.isEmpty()) { // if there is already a solution, future solutions will be longer so we can stop
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				List<String> curSeq = queue.poll();
				String curWord = curSeq.get(curSeq.size() - 1);
				visited.add(curWord); // must mark visited here, because it is possible for the same word to appear at a certain position more than once
				char[] charArr = curWord.toCharArray();
				for (int j = 0; j < charArr.length; j++) {
					char chCopy = charArr[j];
					for (char ch = 'a'; ch <= 'z'; ch++) {
						if (ch != chCopy) {		
							charArr[j] = ch;
							String nextWord = new String(charArr);
							if (dict.contains(nextWord)) {
								List<String> newSeq = new ArrayList<>(curSeq);
								newSeq.add(nextWord);
								if (nextWord.equals(endWord)) {
									res.add(newSeq);
								}
								if (!visited.contains(nextWord)) { // cannot mark visited here
									queue.add(newSeq);
								}
							}
						}
					}
					charArr[j] = chCopy; //undo the change for the next round
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		WordLadderII test = new WordLadderII();
		String beginWord = "red";
		String endWord = "tax";
		List<String> wordList = Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee");
		System.out.println(test.findLadders(beginWord, endWord, wordList));
	}
}
