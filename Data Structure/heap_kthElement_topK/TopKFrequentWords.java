package heap_kthElement_topK;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import impl.Utils;

/**
 * Assumptions: 
 * 1. combo is not null 
 * 2. k >= 1 and could be larger than the number of distinct words in the combo, in this case, 
 * just return all the distinct words
 */
public class TopKFrequentWords {
	public String[] topKFrequent(String[] combo, int k) {
		if (combo.length == 0) {
			return new String[0];
		}
		Map<String, Integer> freqMap = getFreqMap(combo);
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
				new Comparator<Map.Entry<String, Integer>>() {
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
		for (String s : combo) {
			Integer freq = freqMap.get(s);
			if (freq == null) {
				freqMap.put(s, 1);
			} else {
				freqMap.put(s, freq + 1);
			}
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
