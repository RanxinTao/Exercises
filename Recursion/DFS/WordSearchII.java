package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those 
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * 
 * Assumptions:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * Examples:
 * Given words = ["oath", "pea", "eat", "rain"] and board = 
 * ['o', 'a', 'a', 'n']
 * ['e', 't', 'a', 'e']
 * ['i', 'h', 'k', 'r']
 * ['i', 'f', 'l', 'v']
 * Return ["eat", "oath"].
 * 
 * Time: O(kmn*4^min(l, mn)), where k is the size of dictionary, m is the length of the board, n is the width of the 
 * board, and l is the length of the word.
 * Space: O(mn)
 */
public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		Set<String> wordSet = new HashSet<>(); // there could be duplicates in word array, use a set to deduplicate
		Collections.addAll(wordSet, words);
		for (String word : wordSet) {
			if (existWord(board, word)) {
				res.add(word);
			}
		}
		return res;
	}
	
	private boolean existWord(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (matchChar(board, i, j, word, 0, new boolean[board.length][board[0].length])) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean matchChar(char[][] board, int x, int y, String word, int wordIdx, boolean[][] visited) {
		if (wordIdx == word.length()) { // base case: if all the characters are matched, we found a path representing the word.
			return true;
		}
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length // out of bound
				|| visited[x][y] // already visited
				|| board[x][y] != word.charAt(wordIdx)) { // can not match the current character
			return false;
		}
		visited[x][y] = true;
		if (matchChar(board, x - 1, y, word, wordIdx + 1, visited) 
				|| matchChar(board, x + 1, y, word, wordIdx + 1, visited) 
				|| matchChar(board, x, y - 1, word, wordIdx + 1, visited) 
				|| matchChar(board, x, y + 1, word, wordIdx + 1, visited)) {
			return true;
		}
		visited[x][y] = false; // mark the current position as not visited to make it available for other paths.
		return false;
	}
	
	public static void main(String[] args) {
		WordSearchII test = new WordSearchII();
		String[] words = {"oath", "pea", "eat", "rain"};
		char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
		System.out.println(test.findWords(board, words));
	}
}
