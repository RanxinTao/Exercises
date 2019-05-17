package heap_kthElement_topK;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given a dictionary containing many words, find the largest product of two words' lengths, such that the two words do 
 * not share any common characters.
 * 
 * Assumptions:
 * 1. The words only contains characters of 'a' to 'z'
 * 2. The dictionary is not null and does not contains null string, and has at least two strings
 * 3. If there is no such pair of words, just return 0
 * 
 * Examples:
 * dictionary = ["abcde", "abcd", "ade", "xy"], the largest product is 5 * 2 = 10 (by choosing "abcde" and "xy")
 * 
 * Time: O((n^2)logn)
 * Space: O(n^2)
 */
public class LargestProductOfLength {
	public int largestProduct(String[] dict) {
		Arrays.sort(dict, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return ((Integer) s2.length()).compareTo(s1.length());
			}
		});
		PriorityQueue<Entry> maxHeap = new PriorityQueue<>(new Comparator<Entry>() {
			public int compare(Entry e1, Entry e2) {
				return ((Integer) e2.product).compareTo(e1.product);
			}
		});
		boolean[][] visited = new boolean[dict.length][dict.length];
		maxHeap.offer(new Entry(1, 0, dict));
		visited[1][0] = true;
		while (!maxHeap.isEmpty()) {
			Entry entry = maxHeap.poll();
			if (!hasDup(dict[entry.i], dict[entry.j])) {
				return entry.product;
			} else {
				if (entry.i + 1 < dict.length && !visited[entry.i + 1][entry.j]) {
					maxHeap.offer(new Entry(entry.i + 1, entry.j, dict));
					visited[entry.i + 1][entry.j] = true;
				}
				if (entry.j + 1 < entry.i && !visited[entry.i][entry.j + 1]) {
					maxHeap.offer(new Entry(entry.i, entry.j + 1, dict));
					visited[entry.i][entry.j + 1] = true;
				}
			}
		}
		return 0;
	}

	private boolean hasDup(String shorter, String longer) {
		Set<Character> charSet = new HashSet<>();
		for (int i = 0; i < shorter.length(); i++) {
			charSet.add(shorter.charAt(i));
		}
		for (int i = 0; i < longer.length(); i++) {
			if (charSet.contains(longer.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	static class Entry {
		int i;
		int j;
		int product;

		Entry(int i, int j, String[] dict) {
			this.i = i;
			this.j = j;
			product = dict[i].length() * dict[j].length();
		}
	}
	
	public static void main(String[] args) {
		String[] dict = {"abcde", "abcd", "ade", "xy"};
		LargestProductOfLength test = new LargestProductOfLength();
		System.out.println(test.largestProduct(dict));
	}
}
