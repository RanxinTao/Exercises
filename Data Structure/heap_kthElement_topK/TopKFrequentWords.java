package heap_kthElement_topK;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import impl.Utils;

/**
 * Given a composition with different kinds of words, return a list of the top K most frequent words in the composition,
 * ordered from most frequent one to least frequent one
 * 
 * Assumptions: 
 * 1. the composition is not null and is not guaranteed to be sorted
 * 2. K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all
 * the distinct words
 * 
 * Examples:
 * 1. Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are ["b", "c"]
 * 2. Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are ["b", "c", "a", "d"]
 * 3. Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are ["b", "c", "a", "d"]
 * 
 * Time: O(n + (m - k)logk), where n is the number of words, m is the number of unique words
 * Space: O(m + k)
 */
public class TopKFrequentWords {
	public String[] topKFrequent(String[] combo, int k) {
		Map<String, Integer> freqMap = getFreqMap(combo);
		PriorityQueue<Map.Entry<String, Integer>> minHeap 
				= new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
					@Override
					public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
						return e1.getValue().compareTo(e2.getValue());
					}
				});
		// maintain a size k min heap
		for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			if (minHeap.size() < k) {
				minHeap.offer(entry);
			} else if (entry.getValue() > minHeap.peek().getValue()) {
				minHeap.poll();
				minHeap.offer(entry);
			}
		}
		return toArray(minHeap);
	}

	private Map<String, Integer> getFreqMap(String[] combo) {
		Map<String, Integer> freqMap = new HashMap<>();
		for (String word : combo) {
			Integer freq = freqMap.get(word);
			freq = freq == null ? 1 : freq + 1;
			freqMap.put(word, freq);
		}
		return freqMap;
	}

	private String[] toArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
		String[] res = new String[minHeap.size()];
		for (int i = res.length - 1; i >= 0; i--) {
			res[i] = minHeap.poll().getKey();
		}
		return res;
	}
	
	public static void main(String[] args) {
		TopKFrequentWords test = new TopKFrequentWords();
		String[] combo = {"a", "a", "b", "b", "b", "b", "c", "c", "c", "d"};
		Utils.printArray(test.topKFrequent(combo, 5));
	}
}
