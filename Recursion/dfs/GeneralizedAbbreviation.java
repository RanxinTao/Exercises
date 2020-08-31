package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 * 
 * Examples:
 * 1. Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 * Time: O(2^n)
 * Space: O(n)
 */
public class GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();
		genAbbr(word, new StringBuilder(), 0, 0, res);
		return res;
	}
	
	private void genAbbr(String word, StringBuilder cur, int idx, int cnt, List<String> res) {
		if (idx == word.length()) {
			if (cnt != 0) {
				cur.append(cnt);
			}
			res.add(cur.toString());
			if (cnt != 0) {
				int cntLen = String.valueOf(cnt).length();				
				cur.delete(cur.length() - cntLen, cur.length());
			}
			return;
		}
		if (cnt == 0) { // Although we can merge two cases where cnt == 0 and cnt != 0 (by using if cnt != 0), but it is easier to think in two separate logics
			cur.append(word.charAt(idx));
			genAbbr(word, cur, idx + 1, 0, res); // not abbreviate the current character
			cur.deleteCharAt(cur.length() - 1);
			genAbbr(word, cur, idx + 1, 1, res); // abbreviate the current character
		} else {
			cur.append(cnt).append(word.charAt(idx));
			genAbbr(word, cur, idx + 1, 0, res); // not abbreviate the current character
			int cntLen = String.valueOf(cnt).length();
			cur.delete(cur.length() - cntLen - 1, cur.length());
			genAbbr(word, cur, idx + 1, cnt + 1, res); // abbreviate the current character
		}
	}
	
	public static void main(String[] args) {
		GeneralizedAbbreviation test = new GeneralizedAbbreviation();
		String word = "word";
		System.out.println(test.generateAbbreviations(word));
	}
}
